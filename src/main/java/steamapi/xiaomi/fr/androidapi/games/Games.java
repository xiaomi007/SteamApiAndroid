package steamapi.xiaomi.fr.androidapi.games;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class Games implements JsonBasedObject{
    private int gameCount;
    private List<GameLight> gameLights;

    public Games() {
        this.gameCount = 0;
        this.gameLights = new LinkedList<>();
    }

    public Games(int gameCount, List<GameLight> gameLights) {
        this.gameCount = gameCount;
        this.gameLights = gameLights;
    }

    public int getGameCount() {
        return gameCount;
    }

    public List<GameLight> getGameLights() {
        return gameLights;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        JSONObject gamesJson = (JSONObject) json.get("response");

        this.gameCount = (Integer) gamesJson.get("game_count");

        JSONArray gameJson = (JSONArray) gamesJson.get("games");

        for(int i = 0; i < gameJson.size(); i++){
            JSONObject jsonObject = (JSONObject) gameJson.get(i);
            GameLight gameLight = new GameLight();
            gameLight.fromJsonObject(jsonObject);
            this.gameLights.add(gameLight);
        }

    }

}
