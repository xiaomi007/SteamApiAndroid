package steamapi.xiaomi.fr.androidapi.user;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class FriendList implements JsonBasedObject{

    private static final String kFriendList = "friendslist";
    private static final String kFriend = "friends";

    private List<Friend> friends;

    public FriendList() {
        this.friends = new LinkedList<>();
    }

    public List<Friend> getFriends() {
        return friends;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        if(json.containsKey(kFriendList)){
            JSONObject friendListJson = (JSONObject) json.get(kFriendList);
            if(friendListJson.containsKey(kFriend)) {
                JSONArray friendsJson = (JSONArray) friendListJson.get(kFriend);

                for(int i = 0; i < friendsJson.size(); i++){
                    Friend friend = new Friend();
                    friend.fromJsonObject((JSONObject) friendsJson.get(i));
                    this.friends.add(friend);
                }
            }
        }
    }
}
