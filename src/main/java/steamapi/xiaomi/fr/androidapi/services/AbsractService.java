package steamapi.xiaomi.fr.androidapi.services;

import org.apache.http.client.methods.HttpGet;

import steamapi.xiaomi.fr.androidapi.models.Steam;

/**
 * Created by xiaomi on 14/12/10.
 */
public abstract class AbsractService {

    protected Steam steam;

    protected AbsractService(Steam steam){
        this.steam = steam;
    }

    protected HttpGet httpGet(String path) {

        return new HttpGet(this.steam.getUrl());
    }

}
