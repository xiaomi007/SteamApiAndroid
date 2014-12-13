package steamapi.xiaomi.fr.androidapi.models;

import net.minidev.json.JSONObject;

import org.apache.http.client.methods.HttpUriRequest;

import steamapi.xiaomi.fr.androidapi.services.SteamCallback;

/**
 * Created by xiaomi on 14/12/10.
 */
public class Steam {

    private String gameStats = "ISteamUserStats";
    private String userStats = "ISteamUser";

    private String url = "http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/?appid=250900&key=75AC25959B324D8CD38090997C85C3B2&steamid=76561197964628349";


    public String getUrl() {
        return url;
    }


    protected void asyncJsonRequest(final HttpUriRequest request, final SteamCallback<JSONObject> callback) {




    }
}
