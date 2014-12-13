package steamapi.xiaomi.fr.androidapi.modules;

import android.os.AsyncTask;

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
import java.util.List;

import steamapi.xiaomi.fr.androidapi.models.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/10.
 */
public class SteamAPI {

    protected String baseURL;
    protected final String key = "75AC25959B324D8CD38090997C85C3B2";

    private String id;

    public SteamAPI(String id) {
        this.id = id;
        baseURL = "http://api.steampowered.com/";
    }

    protected void asyncJsonRequest(
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
            final Class<T> clazz,
            final HttpUriRequest request,
            final SteamCallback<List<T>> callback) {
        this.asyncJsonRequest(request,
                new SteamCallback<JSONObject>() {
                    @Override
                    public void onComplete(JSONObject data, Exception exception) {
                        if (exception != null) {
                            callback.onComplete(null, exception);
                            return;
                        } else {
                            JSONArray list = (JSONArray) data.get("");

                        }
                    }
                });

    }

    public final SteamAPIList list = new SteamAPIList(this);


}