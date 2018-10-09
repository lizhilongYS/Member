package dto;

import java.io.Serializable;

public class QuestionDTO implements Serializable {

	private int cId;//问题所属的某一节课
	private String qpId;//问题所属的某一个人
	private String spId;//审核该问题的管理员
	private String checkType;//所有人的问答-all；自己的问答-mine 所有的未审核：allno；所有的未审核：allnopass；某管理员审核的待修改：tomodify；某管理员审核的已修改：modified
	
	public String getCheckType() {
		return checkType;
	}

	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}

	public int getcId() {
		return cId;
	}

	public void setcId(int cId) {
		this.cId = cId;
	}

	public String getQpId() {
		return qpId;
	}

	public void setQpId(String qpId) {
		this.qpId = qpId;
	}

	public String getSpId() {
		return spId;
	}

	public void setSpId(String spId) {
		this.spId = spId;
	}

	@Override
	public String toString() {
		return "QuestionDTO [cId=" + cId + ", qpId=" + qpId + ", spId=" + spId + ", checkType=" + checkType + "]";
	}


	
	
	
}
