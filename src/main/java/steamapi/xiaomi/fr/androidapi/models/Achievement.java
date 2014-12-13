package steamapi.xiaomi.fr.androidapi.models;

/**
 * Created by xiaomi on 14/12/09.
 */
public class Achievement {

    private String apiName;
    private long achieved;

    public Achievement() {
        this.apiName = "";
        this.achieved = 0;
    }

    public Achievement(String apiName, long achieved) {
        this.apiName = apiName;
        this.achieved = achieved;
    }

    public long getAchieved() {
        return achieved;
    }

    public void setAchieved(long achieved) {
        this.achieved = achieved;
    }

    public String getApiName() {
        return apiName;
    }

    public void setApiName(String apiName) {
        this.apiName = apiName;
    }

    @Override
    public String toString() {
        return "api name:" + apiName + "\nachieved:" + achieved;
    }


}
