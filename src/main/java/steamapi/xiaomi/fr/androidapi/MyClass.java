package steamapi.xiaomi.fr.androidapi;

import net.minidev.json.JSONObject;
import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;

import steamapi.xiaomi.fr.androidapi.apiList.ApiList;
import steamapi.xiaomi.fr.androidapi.game.Games;
import steamapi.xiaomi.fr.androidapi.game.GamesRecent;
import steamapi.xiaomi.fr.androidapi.userStats.Achievement;
import steamapi.xiaomi.fr.androidapi.userStats.PlayerStats;
import steamapi.xiaomi.fr.androidapi.user.Friend;
import steamapi.xiaomi.fr.androidapi.user.FriendList;
import steamapi.xiaomi.fr.androidapi.user.Players;
import steamapi.xiaomi.fr.androidapi.userStats.Stats;

public class MyClass {

    public static final String TAG = MyClass.class.getSimpleName();

    private PlayerStats playerStats;
    private OpenID openID;

    public static void main(String[] a) {

        //    public void main(){
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
        Players players = new Players();
        Games games = new Games();
        Games extra = new Games();
        GamesRecent recent = new GamesRecent();
        FriendList friendList = new FriendList();
        PlayerStats playerStats = new PlayerStats();
        JSONParser jsonParser = new JSONParser(JSONParser.MODE_PERMISSIVE);

        try {
            /*
            Object obj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/steamAPI.json"));

            JSONObject json = (JSONObject) obj;

            apiList.fromJsonObject(json);

            Object playerObj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/players.json"));

            players.fromJsonObject((JSONObject) playerObj);

            Object gameObj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/game.json"));

            games.fromJsonObject((JSONObject) gameObj);

            Object extraObj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/game_extra.json"));

            extra.fromJsonObject((JSONObject) extraObj);

            Object recentObj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/recent.json"));

            recent.fromJsonObject((JSONObject) recentObj);


            Object friendListObj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/friend.json"));
            friendList.fromJsonObject((JSONObject) friendListObj);
            */

            Object achievementObj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/userstat.json"));
            playerStats.fromJsonObject((JSONObject) achievementObj);

        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }


        System.out.println(playerStats.toString());
        for(Stats stats : playerStats.getStatsList()){
            System.out.println(stats.toString());
        }




        /*
        for(Player player : players.getPlayerList()){
            System.out.println(player.toString());
        }
        System.out.println("game total:" + extra.getGameCount());
        for(GameLight gameLight : extra.getGameLights()){
            System.out.println(gameLight.toString());
        }

        System.out.println("recent game:" + recent.getTotalCount());

        for(GameLight gameLight : recent.getGameLights()){
            System.out.println(gameLight.toString());

        }

        System.out.println("number of friends:" + friendList.getFriends().size());
        for(Friend friend : friendList.getFriends()){
            System.out.println(friend.toString());
        }
        */


        /*
        System.out.println("ApiList:");
        for(Interfaces interfaces : apiList.getInterfacesList()){
            System.out.println("Interfaces:");
            System.out.println(interfaces.getName());
            for(Methods methods : interfaces.getMethodsList()){
                System.out.println("Methods:");
                System.out.println("name:" + methods.getName());
                System.out.println("version:" + methods.getVersion());
                System.out.println("httpmethod:" + methods.getHttpMethod());
                for(Parameters parameters : methods.getParametersList()){
                    System.out.println("Paramaters:");
                    System.out.println("name:" + parameters.getName());
                    System.out.println("type:" + parameters.getType());
                    System.out.println("optional:" + parameters.isOptional());
                    System.out.println("description:" + parameters.getDescription());
                }
            }
        }*/


        /*
        SteamAPI api = new SteamAPI("76561197964628349");
        api.list.queryListWithoutKey(new SteamCallback<ApiList>() {
            @Override
            public void onComplete(ApiList apiList, Exception exception) {
                if(exception == null && apiList != null){
                    Log.d(TAG, "ApiList:");
                    for(Interfaces interfaces : apiList.getInterfacesList()){
                        Log.d(TAG, "Interfaces:");
                        Log.d(TAG, interfaces.getName());
                        for(Methods methods : interfaces.getMethodsList()){
                            Log.d(TAG, "Methods:");
                            Log.d(TAG, "name:" + methods.getName());
                            Log.d(TAG, "version:" + methods.getVersion());
                            Log.d(TAG, "httpmethod:" + methods.getHttpMethod());
                            for(Parameters parameters : methods.getParametersList()){
                                Log.d(TAG, "Paramaters:");
                                Log.d(TAG, "name:" + parameters.getName());
                                Log.d(TAG, "type:" + parameters.getType());
                                Log.d(TAG, "optional:" + parameters.isOptional());
                                Log.d(TAG, "description:" + parameters.getDescription());
                            }
                        }
                    }
                }
            }
        });
        */


    }

}

