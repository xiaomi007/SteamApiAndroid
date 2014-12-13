package steamapi.xiaomi.fr.androidapi.services;

import org.apache.http.client.methods.HttpGet;

/**
 * Created by xiaomi on 14/12/10.
 */
public abstract class AbstractService {

    protected SteamAPI steamAPI;

    protected AbstractService(SteamAPI steamAPI){
        this.steamAPI = steamAPI;
    }

    protected HttpGet httpGet(String path) {

        return new HttpGet(this.steamAPI.baseURL + path);
    }

}
