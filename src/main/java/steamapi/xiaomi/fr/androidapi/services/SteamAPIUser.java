package steamapi.xiaomi.fr.androidapi.services;

import java.util.ArrayList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.user.FriendList;
import steamapi.xiaomi.fr.androidapi.user.Players;

/**
 * Created by xiaomi on 14/12/13.
 */
public class SteamAPIUser extends AbstractService {


    protected SteamAPIUser(SteamAPI steamAPI) {
        super(steamAPI);
    }

    public void getPlayersSummaries(List<String> steamIds, SteamCallback<Players> callback) {
        String path = "ISteamUser/GetPlayerSummaries/v0002/?key=" +
                this.steamAPI.key +
                "&steamids=";

        if (steamIds != null && steamIds.size() > 0) {
            for (int i = 0; i < steamIds.size(); i++) {
                path += steamIds.get(i);
                if (i < (steamIds.size() - 1)) {
                    path += ",";
                }
            }
        }

        this.steamAPI.asyncAPIRequestWithObject(
                Players.class,
                httpGet(path),
                callback
        );
    }

    public void getPlayerSummary(String steamId, SteamCallback<Players> callback){
        List<String> ids = new ArrayList<>();
        ids.add(steamId);
        this.getPlayersSummaries(ids, callback);
    }

    public void getMyPlayerSummary(SteamCallback<Players> callback){
        List<String> ids = new ArrayList<>();
        ids.add(this.steamAPI.steamId);
        this.getPlayersSummaries(ids, callback);
    }

    public void getFriendList(String steamId, SteamCallback<FriendList> callback){
        String path = "ISteamUser/GetFriendList/v0001/?key=" +
                this.steamAPI.key +
                "&steamid=" +
                steamId +
                "&relationship=friend";

        this.steamAPI.asyncAPIRequestWithObject(
                FriendList.class,
                httpGet(path),
                callback
        );
    }

    public void getMyFriendList(SteamCallback<FriendList> callback){
        this.getFriendList(this.steamAPI.steamId, callback);
    }


}
