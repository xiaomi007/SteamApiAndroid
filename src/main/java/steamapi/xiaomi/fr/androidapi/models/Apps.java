package steamapi.xiaomi.fr.androidapi.models;

/**
 * Created by xiaomi on 14/12/09.
 */
public class Apps {

    private int appID;
    private String name;

    public Apps(int appID, String name) {
        this.appID = appID;
        this.name = name;
    }

    public int getAppID() {
        return appID;
    }

    public void setAppID(int appID) {
        this.appID = appID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
