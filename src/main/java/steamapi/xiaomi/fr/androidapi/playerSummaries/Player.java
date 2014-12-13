package steamapi.xiaomi.fr.androidapi.playerSummaries;

import net.minidev.json.JSONObject;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Player implements JsonBasedObject {

    private String steamId;
    private int communityVisibilityState;
    private int profileState;
    private String personaName;
    private int lastLogOff;
    private String profileURL;
    private String avatar;
    private String avatarMedium;
    private String avatarFull;
    private int personaState;
    private String realName;
    private String primaryClanId;
    private int timeCreated;
    private int personaStateFlags;
    private String locCountryCode;
    private String locStateCode;
    private String locCityId;

    public Player() {
        this.steamId = "";
        this.communityVisibilityState = 0;
        this.profileState = 0;
        this.personaName = "";
        this.lastLogOff = 0;
        this.profileURL = "";
        this.avatar = "";
        this.avatarMedium = "";
        this.avatarFull = "";
        this.personaState = 0;
        this.realName = "";
        this.primaryClanId = "";
        this.timeCreated = 0;
        this.personaStateFlags = 0;
        this.locCountryCode = "";
        this.locStateCode = "";
        this.locCityId = "";
    }

    public Player(String steamId, int communityVisibilityState, int profileState, String personaName, int lastLogOff, String profileURL, String avatar, String avatarMedium, String avatarFull, int personaState, String realName, String primaryClanId, int timeCreated, int personaStateFlags, String locCountryCode, String locStateCode, String locCityId) {
        this.steamId = steamId;
        this.communityVisibilityState = communityVisibilityState;
        this.profileState = profileState;
        this.personaName = personaName;
        this.lastLogOff = lastLogOff;
        this.profileURL = profileURL;
        this.avatar = avatar;
        this.avatarMedium = avatarMedium;
        this.avatarFull = avatarFull;
        this.personaState = personaState;
        this.realName = realName;
        this.primaryClanId = primaryClanId;
        this.timeCreated = timeCreated;
        this.personaStateFlags = personaStateFlags;
        this.locCountryCode = locCountryCode;
        this.locStateCode = locStateCode;
        this.locCityId = locCityId;
    }


    public String getSteamId() {
        return steamId;
    }

    public int getCommunityVisibilityState() {
        return communityVisibilityState;
    }

    public int getProfileState() {
        return profileState;
    }

    public String getPersonaName() {
        return personaName;
    }

    public int getLastLogOff() {
        return lastLogOff;
    }

    public String getProfileURL() {
        return profileURL;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getAvatarMedium() {
        return avatarMedium;
    }

    public String getAvatarFull() {
        return avatarFull;
    }

    public int getPersonaState() {
        return personaState;
    }

    public String getRealName() {
        return realName;
    }

    public String getPrimaryClanId() {
        return primaryClanId;
    }

    public int getTimeCreated() {
        return timeCreated;
    }

    public int getPersonaStateFlags() {
        return personaStateFlags;
    }

    public String getLocCountryCode() {
        return locCountryCode;
    }

    public String getLocStateCode() {
        return locStateCode;
    }

    public String getLocCityId() {
        return locCityId;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {

        this.steamId = json.getAsString("steamid");
        this.communityVisibilityState = (Integer) json.get("communityvisibilitystate");
        this.profileState = (Integer) json.get("profilestate");
        this.personaName = json.getAsString("personaname");
        this.lastLogOff = (Integer) json.get("lastlogoff");
        this.profileURL = json.getAsString("profileurl");
        this.avatar = json.getAsString("avatar");
        this.avatarMedium = "avatarmedium";
        this.avatarFull = json.getAsString("avatarfull");
        this.personaState = (Integer) json.get("personastate");
        this.realName = json.getAsString("realname");
        this.primaryClanId = json.getAsString("primaryclanid");
        this.timeCreated = (Integer) json.get("timecreated");
        this.personaStateFlags = (Integer) json.get("personastateflags");
        this.locCountryCode = json.getAsString("loccountrycode");
        this.locStateCode = json.getAsString("locstatecode");
        this.locCityId = json.getAsString("loccityid");
    }

    @Override
    public String toString() {
        return "Players{" + "\n" +
                "steamId='" + steamId + '\'' + "\n" +
                ", communityVisibilityState=" + communityVisibilityState +"\n" +
                ", profileState=" + profileState +"\n" +
                ", personaName='" + personaName + '\'' +"\n" +
                ", lastLogOff=" + lastLogOff +"\n" +
                ", profileURL='" + profileURL + '\'' +"\n" +
                ", avatar='" + avatar + '\'' +"\n" +
                ", avatarMedium='" + avatarMedium + '\'' +"\n" +
                ", avatarFull='" + avatarFull + '\'' +"\n" +
                ", personaState=" + personaState +"\n" +
                ", realName='" + realName + '\'' +"\n" +
                ", primaryClanId='" + primaryClanId + '\'' +"\n" +
                ", timeCreated=" + timeCreated +"\n" +
                ", personaStateFlags=" + personaStateFlags +"\n" +
                ", locCountryCode='" + locCountryCode + '\'' +"\n" +
                ", locStateCode='" + locStateCode + '\'' +"\n" +
                ", locCityId='" + locCityId + '\'' +"\n" +
                '}';
    }
}
