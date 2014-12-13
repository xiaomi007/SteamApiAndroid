package steamapi.xiaomi.fr.androidapi.playerSummaries;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Players implements JsonBasedObject {

    List<Player> playerList;

    public Players() {
        this.playerList = new ArrayList<>();
    }

    public Players(List<Player> playerList) {
        this.playerList = playerList;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        JSONObject response = (JSONObject) json.get("response");

        JSONArray players = (JSONArray) response.get("players");

        for(int i = 0; i < players.size(); i++){
            Player player = new Player();
            player.fromJsonObject((JSONObject) players.get(i));
            this.playerList.add(player);
        }

    }
}
