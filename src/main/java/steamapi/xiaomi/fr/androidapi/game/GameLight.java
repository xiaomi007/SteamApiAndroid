package steamapi.xiaomi.fr.androidapi.game;

import net.minidev.json.JSONObject;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class GameLight implements JsonBasedObject {

    private static final String kAppId = "appid";
    private static final String kPlayTimeForever = "playtime_forever";
    private static final String kPlayTime2Weeks = "playtime_2weeks";
    private static final String kName = "name";
    private static final String kImgLogoUrl = "img_logo_url";
    private static final String kImgIconUrl = "img_icon_url";
    private static final String kHasCommunityVisibleStats = "has_community_visible_stats";

    private int appId;
    private int playTimeForever;
    private int playTime2Weeks;
    private String name;
    private String imgIconUrl;
    private String imgLogoUrl;
    private boolean hasCommunityVisibleStats;

    public GameLight() {
        this.appId = 0;
        this.playTimeForever = 0;
        this.playTime2Weeks = 0;
        this.name = "";
        this.imgIconUrl = "";
        this.imgLogoUrl = "";
        this.hasCommunityVisibleStats = false;
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

    public String getName() {
        return name;
    }

    public String getImgIconUrl() {
        return imgIconUrl;
    }

    public String getImgLogoUrl() {
        return imgLogoUrl;
    }

    public boolean isHasCommunityVisibleStats() {
        return hasCommunityVisibleStats;
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

        if(json.containsKey(kPlayTime2Weeks)){
            this.playTime2Weeks = (Integer) json.get(kPlayTime2Weeks);
        }

        if(json.containsKey(kName)){
            this.name = json.getAsString(kName);
        }

        if(json.containsKey(kImgIconUrl)){
            this.imgIconUrl = json.getAsString(kImgIconUrl);
        }

        if(json.containsKey(kImgLogoUrl)){
            this.imgLogoUrl = json.getAsString(kImgLogoUrl);
        }

        if(json.containsKey(kHasCommunityVisibleStats)){
            this.hasCommunityVisibleStats = (Boolean) json.get(kHasCommunityVisibleStats);
        }

    }

    @Override
    public String toString() {
        return "Game{" + "\n" +
                "appId=" + appId + "\n" +
                ", playTimeForever=" + playTimeForever + "\n" +
                ", playTime2Weeks=" + playTime2Weeks + "\n" +
                ", name='" + name + '\'' + "\n" +
                ", imgIconUrl='" + imgIconUrl + '\'' + "\n" +
                ", imgLogoUrl='" + imgLogoUrl + '\'' + "\n" +
                ", hasCommunityVisibleStats=" + hasCommunityVisibleStats + "\n" +
                '}';
    }
}
