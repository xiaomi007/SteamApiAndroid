package steamapi.xiaomi.fr.androidapi.services;

import steamapi.xiaomi.fr.androidapi.games.Games;

/**
 * Created by xiaomi on 14/12/14.
 */
public class SteamApiGames extends AbstractService {

    protected SteamApiGames(SteamAPI steamAPI) {
        super(steamAPI);
    }

    public void getOwnGameLight(SteamCallback<Games> callback) {
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

    public void getOwnGameExtra(SteamCallback<Games> callback) {
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

}
