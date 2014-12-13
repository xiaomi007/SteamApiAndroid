package steamapi.xiaomi.fr.androidapi;

import android.accounts.AccountManager;
import android.os.AsyncTask;
import android.util.Log;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.NumberFormat;

import steamapi.xiaomi.fr.androidapi.apiList.ApiList;
import steamapi.xiaomi.fr.androidapi.models.Achievement;
import steamapi.xiaomi.fr.androidapi.models.PlayerStats;

public class MyClass {

    public static final String TAG = MyClass.class.getSimpleName();

    private PlayerStats playerStats;
    private OpenID openID;

    public static void main(String[] args) {



        /*
        Log.d(TAG, "main");
        String url = "http://api.steampowered.com/ISteamUserStats/GetPlayerAchievements/v0001/?appid=250900&key=75AC25959B324D8CD38090997C85C3B2&steamid=76561197964628349";

        final HttpClient client = new DefaultHttpClient();
        final HttpUriRequest request = new HttpGet(url);


        new AsyncTask<Void, Void, JSONObject>() {

            JSONObject json = null;
            Exception exception = null;

            @Override
            protected JSONObject doInBackground(Void[] params) {
                    Log.d(TAG, "async task");
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
                    if(rd != null) {
                        try {
                            rd.close();
                        } catch (IOException e) {
                            this.exception = e;
                            e.printStackTrace();
                        }
                    }
                }

                return this.json;
            }

            @Override
            protected void onPostExecute(JSONObject json) {
                super.onPostExecute(json);


                playerStats = new PlayerStats();
                playerStats.fromJsonObject(this.json);
                Log.d(TAG, playerStats.toString());

                Log.d(TAG, "%:" + playerStats.percentAchieved());

            }
        }.execute(null, null);

        */

        /*
        PlayerStats playerStats = new PlayerStats();
        JSONParser jsonParser = new JSONParser();

        try {
            Object obj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/api.steampowered.com.json"));

            JSONObject json = (JSONObject) obj;

            playerStats.fromJsonObject(json);

        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }




        System.out.println(playerStats.toString());

        for(Achievement achievement : playerStats.getAchievements()){
            System.out.println(achievement.toString());
        }
        */

        ApiList apiList = new ApiList();
        JSONParser jsonParser = new JSONParser(JSONParser.MODE_PERMISSIVE);

        try{
            Object obj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/steamAPI.json"));

            JSONObject json = (JSONObject) obj;

            apiList.fromJson(json);
        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

        System.out.println("apilist:" + apiList.toString());


    }

}

