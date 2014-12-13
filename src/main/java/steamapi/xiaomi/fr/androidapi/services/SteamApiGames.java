package steamapi.xiaomi.fr.androidapi.services;

import steamapi.xiaomi.fr.androidapi.games.Games;
import steamapi.xiaomi.fr.androidapi.games.GamesRecent;

/**
 * Created by xiaomi on 14/12/14.
 */
public class SteamApiGames extends AbstractService {



    protected SteamApiGames(SteamAPI steamAPI) {
        super(steamAPI);
    }

    public void getMyGameLight(SteamCallback<Games> callback) {
        String path = "IPlayerService/GetOwnedGames/v0001/?key=" +
                this.steamAPI.key +
                "&steamid=" +
                this.steamAPI.steamId;

        this.steamAPI.asyncAPIRequestWithObject(
                Games.class,
                httpGet(path),
                callback
        );
    }

    public void getMyGameExtra(SteamCallback<Games> callback) {
        String path = "IPlayerService/GetOwnedGames/v0001/?key=" +
                this.steamAPI.key +
                "&steamid=" +
                this.steamAPI.steamId +
                "&include_appinfo=1";

        this.steamAPI.asyncAPIRequestWithObject(
                Games.class,
                httpGet(path),
                callback
        );
    }

    public void getRecentGame(String steamId, int limit, SteamCallback<GamesRecent> callback){
        String path = "IPlayerService/GetRecentlyPlayedGames/v0001/?key=" +
                this.steamAPI.key +
                "&steamid=" +
                steamId +
                "&count=" +
                limit;

        this.steamAPI.asyncAPIRequestWithObject(
                GamesRecent.class,
                httpGet(path),
                callback
        );
    }

    public void getRecentGame(String steamId, SteamCallback<GamesRecent> callback){
        String path = "IPlayerService/GetRecentlyPlayedGames/v0001/?key=" +
                this.steamAPI.key +
                "&steamid=" +
                steamId;

        this.steamAPI.asyncAPIRequestWithObject(
                GamesRecent.class,
                httpGet(path),
                callback
        );

    }

    public void getMyRecentGame(SteamCallback<GamesRecent> callback){
        this.getRecentGame(this.steamAPI.steamId, callback);
    }

}
