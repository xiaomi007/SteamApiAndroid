package steamapi.xiaomi.fr.androidapi.modules;

import steamapi.xiaomi.fr.androidapi.apiList.ApiList;

/**
 * Created by xiaomi on 14/12/13.
 */
public class SteamAPIList extends AbstractService {


    protected SteamAPIList(SteamAPI steamAPI) {
        super(steamAPI);
    }

    public void queryListWithKey(SteamCallback<ApiList> callback){
        this.steamAPI.asyncAPIRequestWithObject(
                ApiList.class,
                httpGet("ISteamWebAPIUtil/GetSupportedAPIList/v0001/?key=" + this.steamAPI.key),
                callback
        );

    }

    public void queryListWithoutKey(SteamCallback<ApiList> callback){
        this.steamAPI.asyncAPIRequestWithObject(
                ApiList.class,
                httpGet("ISteamWebAPIUtil/GetSupportedAPIList/v0001/"),
                callback
        );
    }


}
