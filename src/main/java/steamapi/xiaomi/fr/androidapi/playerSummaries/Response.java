package steamapi.xiaomi.fr.androidapi.playerSummaries;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.models.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Response implements JsonBasedObject {

    List<Players> playersList;

    public Response() {
        this.playersList = new ArrayList<>();
    }

    public Response(List<Players> playersList) {
        this.playersList = playersList;
    }

    public List<Players> getPlayersList() {
        return playersList;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        JSONObject responseJson = (JSONObject) json.get("response");

        JSONArray playersJson = (JSONArray) responseJson.get("players");

        for(int i = 0; i < playersJson.size(); i++){
            Players players = new Players();
            players.fromJsonObject((JSONObject) playersJson.get(i));
            this.playersList.add(players);
        }

    }
}
