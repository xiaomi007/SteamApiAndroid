package steamapi.xiaomi.fr.androidapi.services;

import android.os.AsyncTask;
import android.util.Log;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaomi on 14/12/10.
 */
public class SteamAPI {

    protected String baseURL;
    protected final String key = "75AC25959B324D8CD38090997C85C3B2";
    protected String steamId;

    public SteamAPI(String steamId) {
        this.steamId = steamId;
        baseURL = "http://api.steampowered.com/";
    }

    private void asyncJsonRequest(
            final HttpUriRequest request,
            final SteamCallback<JSONObject> callback) {

        final HttpClient client = new DefaultHttpClient();

        new AsyncTask<Void, Void, Void>() {

            JSONObject json = null;
            Exception exception = null;

            @Override
            protected Void doInBackground(Void[] params) {

                BufferedReader rd = null;
                try {
                    HttpResponse response = client.execute(request);

                    rd = new BufferedReader(
                            new InputStreamReader(response.getEntity().getContent()));

                    StringBuilder stringBuilder = new StringBuilder();

                    String line;
                    while ((line = rd.readLine()) != null) {
                        stringBuilder.append(line).append("\n");
                    }
                    Log.d("truc", stringBuilder.toString());
                    this.json = (JSONObject) JSONValue.parse(stringBuilder.toString());


                } catch (IOException | NullPointerException e) {
                    this.exception = e;
                    e.printStackTrace();
                } finally {
                    if (rd != null) {
                        try {
                            rd.close();
                        } catch (IOException e) {
                            this.exception = e;
                            e.printStackTrace();
                        }
                    }
                }

                if (exception != null) {
                    callback.onComplete(null, this.exception);
                } else {
                    callback.onComplete(this.json, null);
                }

                return null;
            }
        }.execute(null, null);
    }


    protected <T extends JsonBasedObject> void asyncAPIRequestWithObject(
            final Class<T> clazz,
            final HttpUriRequest request,
            final SteamCallback<T> callback
    ) {
        this.asyncJsonRequest(request, new SteamCallback<JSONObject>() {
            @Override
            public void onComplete(JSONObject data, Exception exception) {
                if (exception != null) {
                    callback.onComplete(null, exception);
                } else {
                    try {

                        T t = clazz.newInstance();
                        t.fromJsonObject(data);
                        callback.onComplete(t, null);
                    } catch (InstantiationException | IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }


    protected <T extends JsonBasedObject> void asyncAPIRequestWithListOfObjects(
            final String root,
            final Class<T> clazz,
            final HttpUriRequest request,
            final SteamCallback<List<T>> callback) {

        final List<T> objects = new ArrayList<>();

        this.asyncJsonRequest(request,
                new SteamCallback<JSONObject>() {
                    @Override
                    public void onComplete(JSONObject data, Exception exception) {
                        if (exception != null) {
                            callback.onComplete(null, exception);

                        } else {
                            try {
                                JSONArray list = (JSONArray) data.get(root);
                                for (int i = 0; i < list.size(); i++) {

                                    T t = clazz.newInstance();
                                    t.fromJsonObject((JSONObject) list.get(i));
                                    objects.add(t);

                                }
                            } catch (InstantiationException | IllegalAccessException e) {
                                e.printStackTrace();
                                callback.onComplete(null, e);
                            }

                            callback.onComplete(objects, null);

                        }
                    }
                });

    }


    public final SteamAPIList apiList = new SteamAPIList(this);

    public final SteamAPIPlayerSummaries playerSummaries = new SteamAPIPlayerSummaries(this);

    public final SteamApiGames games = new SteamApiGames(this);


}
