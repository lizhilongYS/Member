package entity;

import java.util.Date;

public class Resources {
    private int id;
    private String resourceName;//资源名字
    private int title;//章节
    private int category;//专业
    private String url;
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getTitle() {
		return title;
	}
	public void setTitle(int title) {
		this.title = title;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@Override
	public String toString() {
		return "Resources [id=" + id + ", resourceName=" + resourceName + ", title=" + title + ", url=" + url + "]";
	}
	
    
}
