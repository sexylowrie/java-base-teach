package xin.sunce.chapter5.pattern.prototype;

/**
 * 搜索关键词类
 */
public class SearchWord {
    private String keyword;
    private int count;
    private long updateTime;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
    }
}
