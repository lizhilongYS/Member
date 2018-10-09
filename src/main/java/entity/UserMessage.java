package entity;

import java.util.Date;
/* 内容:用户留言类，作为参数提供给留言存取使用
 * 作者:吴文波 最后修改日期:2017-11-16 
 */		
public class UserMessage {
	private int id;
	private String usertype;
	private String loginnumber;
	private String name;
	private String sex;
	private String message;
	private String created;
	private int pid;
	
	public String getLoginnumber() {
		return loginnumber;
	}
	public void setLoginnumber(String loginnumber) {
		this.loginnumber = loginnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}


}
