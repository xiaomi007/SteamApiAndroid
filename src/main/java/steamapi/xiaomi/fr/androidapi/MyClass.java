package steamapi.xiaomi.fr.androidapi;

import steamapi.xiaomi.fr.androidapi.models.PlayerStats;

public class MyClass {

    public static final String TAG = MyClass.class.getSimpleName();

    private PlayerStats playerStats;
    private OpenID openID;

    //public static void main(String[] a) {
    public void main(){
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



        ApiList apiList = new ApiList();
        Response response = new Response();
        JSONParser jsonParser = new JSONParser(JSONParser.MODE_PERMISSIVE);

        try{
            Object obj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/steamAPI.json"));

            JSONObject json = (JSONObject) obj;

            apiList.fromJsonObject(json);

            Object playerObj = jsonParser.parse(new FileReader("/home/xiaomi/Desktop/players.json"));

            response.fromJsonObject((JSONObject) playerObj);


        } catch (FileNotFoundException | ParseException e) {
            e.printStackTrace();
        }

        for(Players players : response.getPlayersList()){
            System.out.println(players.toString());
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

