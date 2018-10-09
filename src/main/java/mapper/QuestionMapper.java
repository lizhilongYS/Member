package mapper;

import java.util.List;

import dto.QuestionDTO;
import entity.Question;
import entity.checkQuestion;

public interface QuestionMapper {
	List<Question> getQuestions(QuestionDTO questionDTO);
	void addQuestion(Question question);
	void modifyQuestion(Question question);
	String getState(Question question);
	List<checkQuestion> getQuestionsForAdmin(QuestionDTO questionDTO);
	void checkQuestion(Question question);
	void delQuestion(Question question);
}
