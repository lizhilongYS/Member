package dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dto.MemAndExpDTO;
import dto.SummaryDTO;
import entity.*;
import jedisService.JedisClient;
import mapper.SummaryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import tools.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SummaryDAO {
	@Autowired
	SummaryMapper summaryMapper;

	@Autowired
	private JedisClient jedisClient;
	
	public int add(Summary summary) {
		return summaryMapper.add(summary);
	}

	public int approveSumarry(Summary summary) {
		return summaryMapper.approveSumarry(summary);
	}

	public int updateSummary(Summary summary) {
		return summaryMapper.updateSummary(summary);
	}

	public int updateRemind(int id) {
		return summaryMapper.updateRemind(id);
	}

	public int deleteRemind(int id) {
		return summaryMapper.deleteRemind(id);
	}

	public int update1Summary(Summary summary) {
		return summaryMapper.update1Summary(summary);
	}

	public List<Summary> getgetSummaryAll(String week) {
		return summaryMapper.getSummaryAll(week);
	}

	public Summary getSumById(int id) {
		return summaryMapper.getSumById(id);
	}

	public int getMemId(int id) {
		return summaryMapper.getMemId(id);
	}

	public int getRemind(int id) {
		return summaryMapper.getRemind(id);
	}

	public int addTitle(Summary summary) {
		return summaryMapper.addTitle(summary);
	}

	public Summary getComment(int pid) {
		return summaryMapper.getComment(pid);
	}

	public int addComment(Summary summary) {
		return summaryMapper.addComment(summary);
	}

	public Summary getContent(Summary summary) {
		return summaryMapper.getContent(summary);
	}

	public int isChePid(int id) {
		return summaryMapper.isChePid(id);
	}

	public int isApprove(int id) {
		return summaryMapper.isApprove(id);
	}

	public int getAid(Summary summary) {
		return summaryMapper.getAid(summary);
	}

	public int getExpId(int id) {
		return summaryMapper.getExpId(id);
	}

	public int getMId(int id) {
		return summaryMapper.getMId(id);
	}
	public int getCId(int id) {
		return summaryMapper.getCId(id);
	}

	public String checkIsRepeatByTit(Summary summary) {
		return summaryMapper.checkIsRepeatByTit(summary);
	}

	public Summary getNewestComment(int pid) {
		return summaryMapper.getNewestComment(pid);
	}

	public int checkUserIsWrite(int mid) {
		return summaryMapper.checkUserIsWrite(mid);
	}

	public Summary getContent2(Summary summary) {
		return summaryMapper.getContent2(summary);
	}

	public int JudgeMemIsModify(Summary summary) {
		return summaryMapper.JudgeMemIsModify(summary);
	}

	public List<Summary> getSummaryByWeek(String week) {
		return summaryMapper.getSummaryByWeek(week);
	}

	public List<LookSummary> getSummarysByPage(SummaryDTO summaryDTO) {
		return summaryMapper.getSummarysByPage(summaryDTO);
	}

	public List<LookSummary> getSummarysByNameWithPage(SummaryDTO summaryDTO) {
		return summaryMapper.getSummarysByNameWithPage(summaryDTO);
	}

	public Summary getCurrentSummary(Summary summary) {
		return summaryMapper.getCurrentSummary(summary);
	}

	public void delSum(int id) {
		summaryMapper.delSum(id);
		summaryMapper.delCom(id);
		summaryMapper.delSummaryVisitBySid(id);
		return;
	}

	public void delCom(int id) {
		summaryMapper.delSum(id);
		return;
	}

	public int getEid(Summary summary) {
		return summaryMapper.getEid(summary);
	}

	public List<MemAndExp> getSummaryInfoByPage(MemAndExpDTO memAndExpDTO) {
		return summaryMapper.getSummaryInfoByPage(memAndExpDTO);
	}

	public List<LookSummary> getSummarysByMid(SummaryDTO summaryDTO) {
		return summaryMapper.getSummarysByMidByPage(summaryDTO);
	}

	public int checkHaveSumByNum(String cnum) {
		return summaryMapper.checkHaveSumByNum(cnum);
	}

	public void addSummaryVisit(SummaryVisit summaryVisit) {
		summaryMapper.addSummaryVisit(summaryVisit);
		return;
	}

	public int checkSummaryVisit(SummaryVisit summaryVisit) {
		return summaryMapper.checkSummaryVisit(summaryVisit);
	}

	public List<SummaryVisit> getSummaryVisit(int sid) {
		return summaryMapper.getSummaryVisit(sid);
	}

	public Summary getCommentById(int id) {
		return summaryMapper.getCommentById(id);
	}

	public int updateComment(Summary summary) {
		return summaryMapper.updateComment(summary);
	}
	public Result getSummarys(SummaryDTO summaryDTO,int page,int rows)
	{
		PageHelper.startPage(page, rows);
		List<Summary>list=summaryMapper.getSummarys(summaryDTO);
		long total = new PageInfo<>(list).getTotal();
		return Result.ok(list, page, (int)((total % rows ==0 ) ? total/rows : total/rows +1));
	}
	public Result getExperienceSummarys(String name,int page,int rows) {
		PageHelper.startPage(page, rows);
		List<LookSummary> list  = summaryMapper.getExperienceSummarys(name);
		PageInfo<LookSummary> pageInfo = new PageInfo<>(list);
		long total=pageInfo.getTotal();
		return Result.ok(list, pageInfo.getPageNum(), pageInfo.getPages(),total);
	}
	public int referralSumarry(HttpSession session, Summary summary)
	{
		return summaryMapper.referralSumarry(summary);
	}
	/* 功能:查询推荐周报列表，查询的数量限制根据settings.xml的配置参数。
	 * 作者:吴文波 最后修改日期:2017-11-16 
	 * 参数：title：周报周期
	 * 返回查询到的推荐周报列表，对象SummaryRecommend，包括：sid，pid，sex，前端显示用到的内容。
	 */		
	public List<SummaryRecommend> getRecommendvalSummarys(HttpServletRequest request, String title){

		//从配置文件中获取周报显示数量
		Integer DefaultCount = 8;
		Integer recommendvalCount = 0;
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
	        Element summaryElement = (Element) xmldoc.getElementsByTagName("summary").item(0);
	        Element recommendvalCountElement = null;
	        if(summaryElement==null){//如果没有配置项目，则新建该项目
	        	summaryElement =xmldoc.createElement("summary");
	        	recommendvalCountElement = xmldoc.createElement("recommendvalCount");
	        	recommendvalCountElement.setTextContent(DefaultCount.toString());
	        	summaryElement.appendChild(recommendvalCountElement);
	            root.appendChild(summaryElement);
		        //保存
		        TransformerFactory factory = TransformerFactory.newInstance();
		        Transformer former = factory.newTransformer();
		        former.transform(new DOMSource(xmldoc), new StreamResult(new File(xmlPath)));
	        }
	        //读取recommendvalCount推荐周报数量
	        recommendvalCountElement = (Element) summaryElement.getElementsByTagName("recommendvalCount").item(0);
	        recommendvalCount =Integer.parseInt(recommendvalCountElement.getTextContent());
	        
	    }catch(Exception e){
	    	//如何读取xml失败，则按默认最多8个周报查询数据库
	    	recommendvalCount = DefaultCount;
	        e.printStackTrace();
	    }
		//从数据库抓取数据
	    Map paramMap = new HashMap<>();
	    paramMap.put("title", title);
	    paramMap.put("countlimit", recommendvalCount);
		List<SummaryRecommend> resultlist = summaryMapper.getRecommendvalSummarys(paramMap);

		return resultlist;
	}
	//获取特定用户前一周的周报id
	public String getPreSummaryIdByUserId(String userType, Integer sid, Integer userId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userType", userType);
		paramMap.put("sid", sid);
		paramMap.put("userId", userId);
		List<String> list = summaryMapper.getPreSummaryIdByUserId(paramMap);
		if (list.size()>0){
			return list.get(0);
		}
		return "0";
	}
	//获取特定用户后一周的周报id
	public String getNextSummaryIdByUserId(String userType, Integer sid, Integer userId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userType", userType);
		paramMap.put("sid", sid);
		paramMap.put("userId", userId);
		List<String> list = summaryMapper.getNextSummaryIdByUserId(paramMap);
		if (list.size()>0){
			return list.get(0);
		}
		return "0";
	}
	//获取特定用户最近一周的周报id
	public String getCurrentSummaryIdByUserId(String userType, Integer userId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userType", userType);
		paramMap.put("userId", userId);
		List<String> list = summaryMapper.getCurrentSummaryIdByUserId(paramMap);
		if (list.size()>0){
			return list.get(0);
		}
		return "0";
	}
	//获取特定用户第一周的周报id
	public String getFirstSummaryIdByUserId(String userType, Integer userId){
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userType", userType);
		paramMap.put("userId", userId);
		List<String> list = summaryMapper.getFirstSummaryIdByUserId(paramMap);
		if (list.size()>0){
			return list.get(0);
		}
		return "0";
	}	
	
}
