package steamapi.xiaomi.fr.androidapi.game;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class Games implements JsonBasedObject {

    private static final String kResponse = "response";
    private static final String kGames = "games";
    private static final String kGameCount = "game_count";


    private int gameCount;
    private List<GameLight> gameLights;

    public Games() {
        this.gameCount = 0;
        this.gameLights = new LinkedList<>();
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
        if (json.containsKey(kResponse)) {
            JSONObject gamesJson = (JSONObject) json.get(kResponse);

            if (gamesJson.containsKey(kGameCount)) {
                this.gameCount = (Integer) gamesJson.get(kGameCount);
            }

            if (gamesJson.containsKey(kGames)) {
                JSONArray gameJson = (JSONArray) gamesJson.get(kGames);

                for (int i = 0; i < gameJson.size(); i++) {
                    JSONObject jsonObject = (JSONObject) gameJson.get(i);
                    GameLight gameLight = new GameLight();
                    gameLight.fromJsonObject(jsonObject);
                    this.gameLights.add(gameLight);
                }
            }
        }

    }

}
