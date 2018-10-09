package dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dto.QuestionDTO;
import entity.Question;
import entity.checkQuestion;
import mapper.QuestionMapper;

/**
 * 
 * 提取问题分享信息 
 * @author admin
 *
 */
@Service
public class QuestionDAO {
	
	@Autowired
	private QuestionMapper questionMapper;
	/**
	 * 
	 * 会员或者体验者提取问题分享信息
	 * @param questionDTO
	 * @return
	 */
	public List<Question> getQuestions(QuestionDTO questionDTO)
	{
		List<Question> list = null;
		try {
			list = questionMapper.getQuestions(questionDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 
	 * 管理员提取问题分享信息
	 * @param questionDTO
	 * @return
	 */
	public List<checkQuestion> getQuestionsForAdmin(QuestionDTO questionDTO)
	{
		List<checkQuestion> list = null;
		try {
			list = questionMapper.getQuestionsForAdmin(questionDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 
	 * 添加问题分享的信息
	 */
	public void addQuestion(Question question)
	{
		try {
			questionMapper.addQuestion(question);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 修改问题分享
	 */
	public void modifyQuestion(Question question)
	{
		try {
			questionMapper.modifyQuestion(question);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 
	 * 得到问题的审核状态
	 */
	public String getState(Question question)
	{
		return  questionMapper.getState(question);
	}
	
	/**
	 * 
	 * 管理员审核问题
	 */
	public void checkQuestion(Question question)
	{
		questionMapper.checkQuestion(question);
	}
	
	/**
	 * 
	 * 管理员审核删除问题
	 */
	public void delQuestion(Question question)
	{
		questionMapper.delQuestion(question);
	}
	
}
