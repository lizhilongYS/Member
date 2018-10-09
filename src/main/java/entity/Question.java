package entity;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {
	private int Id;
	private int cId;
	private String question;
	private String qpId;  //提问者会员编号或者体验者编号
	private String qperson;  //提问者姓名
	private String solution;
	private Date time;    //问答提交时间
	private String spId;  //审核者
	private Date checktime; //问答审核时间
	private String state;//问题审核状态  0未审核   1审核通过  2待修改  3已修改(但尚未通过)
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getQperson() {
		return qperson;
	}
	public void setQperson(String qperson) {
		this.qperson = qperson;
	}
	public String getSolution() {
		return solution;
	}
	public void setSolution(String solution) {
		this.solution = solution;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getSpId() {
		return spId;
	}
	public void setSpId(String spId) {
		this.spId = spId;
	}
	public Date getChecktime() {
		return checktime;
	}
	public void setChecktime(Date checktime) {
		this.checktime = checktime;
	}
	public String getQpId() {
		return qpId;
	}
	public void setQpId(String qpId) {
		this.qpId = qpId;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Question [Id=" + Id + ", cId=" + cId + ", question=" + question + ", qpId=" + qpId + ", qperson="
				+ qperson + ", solution=" + solution + ", time=" + time + ", spId=" + spId + ", checktime=" + checktime
				+ ", state=" + state + "]";
	}


	
	
	
}
