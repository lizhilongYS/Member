package entity;
/* 内容:周报推荐类，作为参数提供给推荐周报读取使用
 * 作者:吴文波 最后修改日期:2017-11-16 
 */		
public class SummaryRecommend {
	private int sid;
	private int pid;
	private String sex;
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	
}
