package entity;



import java.util.List;

public class Summary {
	private int id;
	private int mid;
	private int pid;
	private int cid;
	private int ischeck;
	private String time;
	private String title;
	private String content;
	private int aid;
	private Admin admin;
	private Clue clue;
	private List<Summary> summaries;
	private Member member;
	private int eid;
	private int recommend;
	private Experience experience;
	private List<SummaryVisit> summaryVisits;
	public List<SummaryVisit> getSummaryVisits() {
		return summaryVisits;
	}
	public void setSummaryVisits(List<SummaryVisit> summaryVisits) {
		this.summaryVisits = summaryVisits;
	}
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public Clue getClue() {
		return clue;
	}
	public void setClue(Clue clue) {
		this.clue = clue;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public Experience getExperience() {
		return experience;
	}
	public void setExperience(Experience experience) {
		this.experience = experience;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public List<Summary> getSummaries() {
		return summaries;
	}
	public void setSummaries(List<Summary> summaries) {
		this.summaries = summaries;
	}
	public int getIscheck() {
		return ischeck;
	}
	public void setIscheck(int ischeck) {
		this.ischeck = ischeck;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public int getAid() {
		return aid;
	}
	public void setAid(int aid) {
		this.aid = aid;
	}
	public int getRecommend() {
		return recommend;
	}
	public void setRecommend(int recommend) {
		this.recommend = recommend;
	}
	@Override
	public String toString() {
		return "Summary [id=" + id + ", mid=" + mid + ", pid=" + pid + ", ischeck=" + ischeck + ", time=" + time
				+ ", title=" + title + ", content=" + content + ", aid=" + aid + ", admin=" + admin + ", summaries="
				+ summaries + ", member=" + member + ", eid=" + eid + ", recommend=" + recommend + ", experience="
				+ experience + ", summaryVisits=" + summaryVisits + "]";
	}


	
	
	
}
