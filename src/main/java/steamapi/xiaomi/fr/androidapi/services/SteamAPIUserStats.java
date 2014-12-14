package steamapi.xiaomi.fr.androidapi.services;

import steamapi.xiaomi.fr.androidapi.userStats.PlayerStats;

/**
 * Created by xiaomi on 14/12/14.
 */
public class SteamAPIUserStats extends AbstractService {


    protected SteamAPIUserStats(SteamAPI steamAPI) {
        super(steamAPI);
    }

    public void getPlayerAchievementForGame(String steamId, int appId, SteamCallback<PlayerStats> callback){
        String path = "ISteamUserStats/GetPlayerAchievements/v0001/?key=" +
                this.steamAPI.key +
                "&steamid=" +
                steamId +
                "&appid=" +
                appId;

        this.steamAPI.asyncAPIRequestWithObject(
                PlayerStats.class,
                httpGet(path),
                callback
        );
    }

    public void getMyAchievementForGame(int appId, SteamCallback<PlayerStats> callback){
        this.getPlayerAchievementForGame(this.steamAPI.steamId, appId, callback);
    }

    public void getUserStatsForGame(String steamId, int appId, SteamCallback<PlayerStats> callback){
        String path = "ISteamUserStats/GetUserStatsForGame/v0002/?key=" +
                this.steamAPI.key +
                "&steamid=" +
                steamId +
                "&appid=" +
                appId;

        this.steamAPI.asyncAPIRequestWithObject(
                PlayerStats.class,
                httpGet(path),
                callback
        );
    }

    public void getMyStatsForGame(int appId, SteamCallback<PlayerStats> callback){
        this.getUserStatsForGame(this.steamAPI.steamId, appId, callback);
    }


}
