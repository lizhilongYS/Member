package mapper;

import java.util.List;
import java.util.Map;
import entity.UserMessage;

public interface UserMessageMapper {
	public List<UserMessage> getNewUserMessages(int getLimitCount);
	
	public List<UserMessage> getUserMessages(Map paramMap);
	
	public void saveUserMessage(UserMessage userMessage);
	
	public int getMaxId();
}
