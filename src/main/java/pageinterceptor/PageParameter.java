package pageinterceptor;

/**
 * 分页参数类
 * 
 */
public class PageParameter {

    public static final int DEFAULT_PAGE_SIZE = 10;

    private int pageSize;//页数长度
    private int currentPage;//当前页数
    private int prePage;//上一页
    private int nextPage;//下一页
    private int totalPage;//总页
    private int totalCount;//总数计算

    public PageParameter() {
        this.currentPage = 1;
        this.pageSize = DEFAULT_PAGE_SIZE;
    }

    /**
     * 
     * @param currentPage
     * @param pageSize
     */
    public PageParameter(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

	@Override
	public String toString() {
		return "PageParameter [pageSize=" + pageSize + ", currentPage=" + currentPage + ", prePage=" + prePage
				+ ", nextPage=" + nextPage + ", totalPage=" + totalPage + ", totalCount=" + totalCount + "]";
	}
    

}
