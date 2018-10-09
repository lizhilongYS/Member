package dao;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import entity.UserMessage;
import mapper.UserMapper;
import mapper.UserMessageMapper;
@Service
public class UserMessageDAO {
	@Autowired
	private UserMessageMapper userMessageMapper;
	/* 功能:从配置文件settings.xml取留言查询的每批限定数量，默认50条。
	 * 作者:吴文波 最后修改日期:2017-11-16 
	 * 返回留言查询每批限定数量
	 */
	private int getMessageLimitNumber(HttpServletRequest request){
		//从配置文件中获取周报显示数量
		Integer DefaultCount = 50;
		Integer getLimitCount = 0;
		//实际环境
		String xmlPath = request.getSession().getServletContext().getRealPath("/") + "/WEB-INF/settings.xml";
	    DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
	    dbf.setIgnoringElementContentWhitespace(false);
	    try{
	        DocumentBuilder db=dbf.newDocumentBuilder();
	        Document xmldoc=db.parse(xmlPath);
	        //读取xml根元素
	        Element root = xmldoc.getDocumentElement();
	        //读取summary项子元素
	        Element messageElement = (Element) xmldoc.getElementsByTagName("message").item(0);
	        Element getLimitCountElement = null;
	        if(messageElement==null){//如果没有配置项目，则新建该项目
	        	messageElement =xmldoc.createElement("message");
	        	getLimitCountElement = xmldoc.createElement("getLimitCount");
	        	getLimitCountElement.setTextContent(DefaultCount.toString());
	        	messageElement.appendChild(getLimitCountElement);
	            root.appendChild(messageElement);
		        //保存
		        TransformerFactory factory = TransformerFactory.newInstance();
		        Transformer former = factory.newTransformer();
		        former.transform(new DOMSource(xmldoc), new StreamResult(new File(xmlPath)));
	        }
	        //读取getLimitCount推荐周报数量
	        getLimitCountElement = (Element) messageElement.getElementsByTagName("getLimitCount").item(0);
	        getLimitCount =Integer.parseInt(getLimitCountElement.getTextContent());
	        
	    }catch(Exception e){
	    	//如何读取xml失败，则按默认值查询数据库
	    	getLimitCount = DefaultCount;
	        e.printStackTrace();
	    }
	    return getLimitCount;
	}	
	/* 功能:从用户留言表取最新一批记录。
	 * 作者:吴文波 最后修改日期:2017-11-16 
	 * 返回查询到的留言记录列表
	 */	
	public List<UserMessage> getNewUserMessages(HttpServletRequest request){
		int getLimitCount =getMessageLimitNumber(request);
		return userMessageMapper.getNewUserMessages(getLimitCount);
	}
	/* 功能:从用户留言表取最新记录。
	 * 作者:吴文波 最后修改日期:2017-11-16 
	 * 参数：查询开始的留言记录id，是上一批查询的最小id
	 * 返回查询到的留言记录列表
	 */		
	public List<UserMessage> getUserMessages(HttpServletRequest request, int startid){
		int getLimitCount =getMessageLimitNumber(request);
		Map paramMap = new HashMap<>();
		paramMap.put("startid", startid);
		paramMap.put("getLimitCount", getLimitCount);
		return userMessageMapper.getUserMessages(paramMap);
	}
	/* 功能:保存留言信息到数据库。
	 * 作者:吴文波 最后修改日期:2017-11-16 
	 * 参数：留言信息对象
	 */	
	public void saveUserMessage(UserMessage userMessage){
		userMessageMapper.saveUserMessage(userMessage);
	}	
	
	public int getMaxId(){
		return userMessageMapper.getMaxId();
	}
}
