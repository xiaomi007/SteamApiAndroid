package steamapi.xiaomi.fr.androidapi.games;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class GamesRecent implements JsonBasedObject {
    private static final String kResponse = "response";
    private static final String kTotalCount = "total_count";
    private static final String kGames = "games";

    private int totalCount;
    private List<GameLight> gameLights;

    public GamesRecent() {
        this.totalCount = 0;
        this.gameLights = new LinkedList<>();
    }

    public int getTotalCount() {
        return totalCount;
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
            JSONObject gamesJson = (JSONObject) json.get("response");
            if (gamesJson.containsKey(kTotalCount)) {
                this.totalCount = (Integer) gamesJson.get(kTotalCount);
            }
            if (gamesJson.containsKey(kGames)) {
                JSONArray gameJson = (JSONArray) gamesJson.get("games");

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
