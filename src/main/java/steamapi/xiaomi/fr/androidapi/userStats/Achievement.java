package steamapi.xiaomi.fr.androidapi.userStats;

import net.minidev.json.JSONObject;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/09.
 */
public class Achievement implements JsonBasedObject{

    private static final String kApiName = "apiname";
    private static final String kAchieved = "achieved";

    private String apiName;
    private int achieved;

    public Achievement() {
        this.apiName = "";
        this.achieved = 0;
    }

    public int getAchieved() {
        return achieved;
    }


    public String getApiName() {
        return apiName;
    }


    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        if(json.containsKey(kApiName)){
            this.apiName = json.getAsString(kApiName);
        }
        if(json.containsKey(kAchieved)){
            this.achieved = (Integer) json.get(kAchieved);
        }
    }

    @Override
    public String toString() {
        return "Achievement{" +  "\n" +
                "apiName='" + apiName + '\'' + "\n" +
                ", achieved=" + achieved + "\n" +
                '}';
    }
}
