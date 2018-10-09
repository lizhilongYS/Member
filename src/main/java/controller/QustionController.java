package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import dao.CourseDAO;
import dao.QuestionDAO;
import dto.QuestionDTO;
import entity.Admin;
import entity.Experience;
import entity.Question;
import entity.User;
import entity.checkQuestion;

/**
 * 发布图区问题分享服务
 * @author 曾堉萱
 *
 */
@Controller
public class QustionController {
	 
	@Autowired
	private QuestionDAO questionDAO;
	
	@ResponseBody
	@RequestMapping("/question/getQuestion")
	public List<Question> getQuestion(QuestionDTO questionDTO,HttpSession session)
	{
		List<Question> list = null;
		try {
			list = questionDAO.getQuestions(questionDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/question/getQuestionForAdmin")
	public List<checkQuestion> getQuestionForAdmin(QuestionDTO questionDTO,HttpSession session)
	{
		List<checkQuestion> list = null;
		try {
			list = questionDAO.getQuestionsForAdmin(questionDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(list);
		return list;
	}
	/**
	 * 
	 * 发布添加问题分享的服务
	 */
	@ResponseBody
	@RequestMapping("/question/addQuestion")
	public String addQuestion(Question question,HttpSession session)
	{
		// 判断session是否过期,过期返回0
		if(session.getAttribute("myuser")!=null)
		{
			User user = (User) session.getAttribute("myuser");
			question.setQpId(user.getName());
			question.setQperson(user.getMember().getName());
			question.setState("0");
			questionDAO.addQuestion(question);
			return "1";
		}else if(session.getAttribute("experience")!=null){
			Experience experience=(Experience)session.getAttribute("experience");
			question.setQpId(experience.getNum());
			question.setQperson(experience.getName());
			question.setState("0");
			questionDAO.addQuestion(question);
			return "1";
		}
		
		/*ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("/question/questions");
		return modelAndView;*/
		return "0";
	}
	
	/**
	 * 
	 * 发布修改问题分享的服务
	 */
	@ResponseBody
	@RequestMapping("/question/modifyQuestion")
	public String modifyQuestion(Question question,HttpSession session)
	{
		//判断session是否过期,过期返回0
		if(session.getAttribute("myuser")!=null||session.getAttribute("experience")!=null)
		{
			String state=questionDAO.getState(question);
			question.setState(state);
			//若问题已通过审核，则返回2
			if(!"1".equals(state)){
				//若问题状态为待修改，则修改后状态为已修改
				if("2".equals(state))
				{
					question.setState("3");
				}
				questionDAO.modifyQuestion(question);
				return "1";
			}else{
				return "2";
			}
		}
		return "0";
	}
	
	/**
	 * 
	 * 管理员审核通过问题
	 */
	@ResponseBody
	@RequestMapping("/question/passQuestion")
	public String passQuestion(Question question,HttpSession session){
		//判断session是否过期,过期返回0
		if(session.getAttribute("admin")!=null)
		{
			String state=questionDAO.getState(question);
			//若问题已通过审核，则返回2
			if(!"1".equals(state)){
				Admin admin=(Admin)session.getAttribute("admin");
				System.out.println("-----------------------------------------");
				System.out.println(admin);
				question.setState("1");
				question.setSpId(admin.getId()+"");
				questionDAO.checkQuestion(question);
				return "1";
			}else{
				return "2";
			}
		}
		return "0";
	}

	/**
	 * 
	 * 管理员审核删除问题
	 */
	@ResponseBody
	@RequestMapping("/question/delQuestion")
	public String delQuestion(Question question,HttpSession session){
		//判断session是否过期,过期返回0
		if(session.getAttribute("admin")!=null)
		{
			String state=questionDAO.getState(question);
			//若问题已通过审核，则返回2
			if(!"1".equals(state)){
				questionDAO.delQuestion(question);
				return "1";
			}else{
				return "2";
			}
		}
		return "0";
	}
	/**
	 * 
	 * 管理员审核修改问题
	 */
	@ResponseBody
	@RequestMapping("/question/modQuestion")
	public String modQuestion(Question question,HttpSession session){
		//判断session是否过期,过期返回0
		if(session.getAttribute("admin")!=null)
		{
			String state=questionDAO.getState(question);
			//若问题已通过审核，则返回2
			if(!"1".equals(state)){
				Admin admin=(Admin)session.getAttribute("admin");
				question.setState("2");
				question.setSpId(admin.getId()+"");
				questionDAO.checkQuestion(question);
				return "1";
			}else{
				return "2";
			}
		}
		return "0";
	}
}
