package steamapi.xiaomi.fr.androidapi.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaomi on 14/12/09.
 */
public class AppNews {

    private int appID;
    private List<NewsItems> newsItemsList;

    public AppNews() {
        this.appID = 0;
        this.newsItemsList = new ArrayList<>();
    }

    public AppNews(int appID, List<NewsItems> newsItemsList) {
        this.appID = appID;
        this.newsItemsList = new ArrayList<>(newsItemsList);
    }

    public int getAppID() {
        return appID;
    }

    public void setAppID(int appID) {
        this.appID = appID;
    }

    public List<NewsItems> getNewsItemsList() {
        return newsItemsList;
    }

    public void setNewsItemsList(List<NewsItems> newsItemsList) {
        this.newsItemsList = newsItemsList;
    }
}
