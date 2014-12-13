package steamapi.xiaomi.fr.androidapi.models;

/**
 * Created by xiaomi on 14/12/09.
 */
public class NewsItems {

    private String gid;
    private String title;
    private String url;
    private boolean isExternalUrl;
    private String author;
    private String content;
    private String feedLabel;
    private String date;
    private String feedName;

    public NewsItems() {
        this.gid = "";
        this.title = "";
        this.url = "";
        this.isExternalUrl = false;
        this.author = "";
        this.content = "";
        this.feedLabel = "";
        this.date = "";
        this.feedName = "";
    }

    public NewsItems(String gid, String title, String url, boolean isExternalUrl, String author, String content, String feedLabel, String date, String feedName) {
        this.gid = gid;
        this.title = title;
        this.url = url;
        this.isExternalUrl = isExternalUrl;
        this.author = author;
        this.content = content;
        this.feedLabel = feedLabel;
        this.date = date;
        this.feedName = feedName;
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isExternalUrl() {
        return isExternalUrl;
    }

    public void setExternalUrl(boolean isExternalUrl) {
        this.isExternalUrl = isExternalUrl;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFeedLabel() {
        return feedLabel;
    }

    public void setFeedLabel(String feedLabel) {
        this.feedLabel = feedLabel;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFeedName() {
        return feedName;
    }

    public void setFeedName(String feedName) {
        this.feedName = feedName;
    }
}
