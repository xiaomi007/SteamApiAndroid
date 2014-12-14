package steamapi.xiaomi.fr.androidapi.user;

import net.minidev.json.JSONObject;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class Friend implements JsonBasedObject{

    private static final String kSteamId= "steamid";
    private static final String kRelationship = "relationship";
    private static final String kFriendSince = "friend_since";

    private String steamId;
    private String relationship;
    private String friendSince;

    public Friend() {
        this.steamId = "";
        this.relationship = "";
        this.friendSince = "";
    }

    public String getSteamId() {
        return steamId;
    }

    public String getRelationship() {
        return relationship;
    }

    public String getFriendSince() {
        return friendSince;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        if(json.containsKey(kSteamId)){
            this.steamId = json.getAsString(kSteamId);
        }

        if(json.containsKey(kRelationship)){
            this.relationship = json.getAsString(kRelationship);
        }

        if(json.containsKey(kFriendSince)){
            this.friendSince = json.getAsString(kFriendSince);
        }
    }

    @Override
    public String toString() {
        return "Friend{" + "\n" +
                "steamId='" + steamId + '\'' + "\n" +
                ", relationship='" + relationship + '\'' + "\n" +
                ", friendSince='" + friendSince + '\'' + "\n" +
                '}';
    }
}
