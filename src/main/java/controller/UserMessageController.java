package controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import dao.UserMessageDAO;
import entity.UserMessage;
import jedisService.JedisClient;
import tools.JsonUtils;

@Controller
@RequestMapping("/usermessage")
public class UserMessageController {
	@Autowired
	private UserMessageDAO userMessageDAO;
	
	@Autowired
	private JedisClient jedisClient;
	
	//redis中的主键
	@Value("USER_MESSAGE_HKEY")
	private String USER_MESSAGE_HKEY;
	
	//redis中hash中小key
	@Value("USER_MESSAGE")
	private String USER_MESSAGE;
	/*功能:从用户留言表取一批记录。
	 * 作者:吴文波 最后修改日期:2017-11-16 
	 * gettype=0表示重新取，gettype=1表示继续取，
	 * 返回记录信息和该批的数量
	 */
	@RequestMapping("/getUserMessages.action")
	@ResponseBody
	//getype表示获取类型，0：从新获取，1：继续往后获取
	public String getUserMessages(HttpServletRequest request, String gettype){
		try {
			//新方法，直接从数据库取数据，从最新的记录开始取
			if (gettype.equals("0")){
				request.getSession().setAttribute("MSG_STARTID",Integer.MAX_VALUE);
			}
			int startid = (int)request.getSession().getAttribute("MSG_STARTID");
			List<UserMessage> userMessageList = userMessageDAO.getUserMessages(request, startid);
			//传回结果
			if (userMessageList.size()>=1){
				int lastid = userMessageList.get(userMessageList.size()-1).getId();
				request.getSession().setAttribute("MSG_STARTID",lastid);
			}
			Map resultMap = new HashMap<String,Object>();
			resultMap.put("COUNT", userMessageList.size());
			resultMap.put("LIST", userMessageList);
			return JsonUtils.objectToJson(resultMap); 			
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	/* 功能:从用户留言表取最新一批记录。
	 * 作者:吴文波 最后修改日期:2017-11-16 
	 * 返回记录信息和该批的数量
	 */
	@RequestMapping("/getNewUserMessages")
	@ResponseBody
	public String getNewUserMessages(HttpServletRequest request){
		
		try {
			String hget = jedisClient.hget(USER_MESSAGE_HKEY, USER_MESSAGE);
			if(hget!=null) {
				return hget;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try{
			//先判断是否有新留言，如果没有直接返回空值
			List<UserMessage> userMessageList = null;
			Integer maxId = (Integer) request.getSession().getAttribute("MSG_MAXID");
			if(maxId==0 || maxId < userMessageDAO.getMaxId()){
				userMessageList = userMessageDAO.getNewUserMessages(request);
				//保存最大的留言id，作为后续判断是否有新留言使用
				request.getSession().setAttribute("MSG_MAXID",userMessageList.get(0).getId());
			}else{
				userMessageList = new ArrayList<UserMessage>();
			}
			//传回结果
			Map resultMap = new HashMap<String,Object>();
			resultMap.put("COUNT", userMessageList.size());
			resultMap.put("LIST", userMessageList);
			String json = JsonUtils.objectToJson(resultMap);	
			try {
				jedisClient.hset(USER_MESSAGE_HKEY, USER_MESSAGE, json);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return json;
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}	
	}
	
	/*功能:把留言记录保存到数据库。
	 * 作者:吴文波 最后修改日期:2017-11-16 
	 * 参数：usertype：用户类型，member,experience,clue,admin，共4种;loginnumber:登录号,
	 * 		name:姓名,message:留言信息
	 * 返回记录信息和该批的数量
	 */
	@RequestMapping("/saveUserMessage.action")
	@ResponseBody
	public String saveUserMessage(HttpServletRequest request,String usertype, String  loginnumber, String name, String message){
		try {
			List<UserMessage> userMessageList =(List<UserMessage>) request.getSession().getServletContext().getAttribute("USER_MESSAGES");
			if(userMessageList==null){
				userMessageList = new ArrayList<UserMessage>();
			}
			//保存到application中		
			UserMessage userMessage = new UserMessage();
			userMessage.setUsertype(usertype);
			userMessage.setLoginnumber(loginnumber);
			userMessage.setName(name);
			userMessage.setMessage(message);
			Date date = new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String strDate=sdf.format(date);
			userMessage.setCreated(strDate);
			userMessageList.add(userMessage);
			request.getSession().getServletContext().setAttribute("USER_MESSAGES",userMessageList);
			//保存到数据库
			userMessageDAO.saveUserMessage(userMessage);
			try {
				jedisClient.hdel(USER_MESSAGE_HKEY, USER_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "1";
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
	}
	@RequestMapping("/initMaxMessageId")
	@ResponseBody
	public String initMaxMessageId(HttpServletRequest request){
		request.getSession().setAttribute("MSG_MAXID",0);
		return "1";
	}
}
