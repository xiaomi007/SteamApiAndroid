package steamapi.xiaomi.fr.androidapi.models;

/**
 * Created by xiaomi on 14/12/09.
 */
public class AppList {

    private Apps[] appses;

    public AppList(Apps[] appses) {
        this.appses = appses;
    }

    public Apps[] getAppses() {
        return appses;
    }

    public void setAppses(Apps[] appses) {
        this.appses = appses;
    }
}
