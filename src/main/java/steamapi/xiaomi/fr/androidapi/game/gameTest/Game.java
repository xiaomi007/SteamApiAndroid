package steamapi.xiaomi.fr.androidapi.game.gameTest;

import net.minidev.json.JSONObject;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class Game implements JsonBasedObject {

    private static final String kAppId = "appid";
    private static final String kPlayTimeForever = "playtime_forever";
    private static final String kPlayTime2Weeks = "playtime_2weeks";

    private int appId;
    private int playTimeForever;
    private int playTime2Weeks;

    public Game() {
        this.appId = 0;
        this.playTimeForever = 0;
        this.playTime2Weeks = 0;
    }

    public int getAppId() {
        return appId;
    }

    public int getPlayTimeForever() {
        return playTimeForever;
    }

    public int getPlayTime2Weeks() {
        return playTime2Weeks;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        if (json.containsKey(kAppId)) {
            this.appId = (Integer) json.get(kAppId);
        }

        if (json.containsKey(kPlayTimeForever)) {
            this.playTimeForever = (Integer) json.get(kPlayTimeForever);
        }

        if (json.containsKey(kPlayTime2Weeks)) {
            this.playTime2Weeks = (Integer) json.get(kPlayTime2Weeks);
        }
    }

    @Override
    public String toString() {
        return "Game{" + "\n" +
                "appId=" + appId + "\n" +
                ", playTimeForever=" + playTimeForever + "\n" +
                ", playTime2Weeks=" + playTime2Weeks + "\n" +
                '}';
    }
}
