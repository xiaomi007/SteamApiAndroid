package steamapi.xiaomi.fr.androidapi.userStats;


import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/09.
 */
public class PlayerStats implements JsonBasedObject {

    private static final String kPlayerStats = "playerstats";

    private static final String kSteamId = "steamID";
    private static final String kGameName = "gameName";
    private static final String kAchievements = "achievements";
    private static final String kStats = "stats";
    private static final String kSuccess = "success";

    private String steamID;
    private String gameName;
    private List<Achievement> achievements;
    private List<Stats> statsList;
    private boolean success;

    public PlayerStats() {
        this.steamID = "";
        this.gameName = "";
        this.achievements = new LinkedList<>();
        this.statsList = new LinkedList<>();
        this.success = false;
    }


    public String getSteamID() {
        return steamID;
    }


    public String getGameName() {
        return gameName;
    }


    public List<Achievement> getAchievements() {
        return achievements;
    }

    public List<Stats> getStatsList() {
        return statsList;
    }

    public boolean isSuccess() {
        return success;
    }


    @Override
    public JSONObject toJsonObject() {

        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        System.out.println(json);
        if (json.containsKey(kPlayerStats)) {
            JSONObject jsonPlayerStats = (JSONObject) json.get(kPlayerStats);

            if (jsonPlayerStats.containsKey(kSteamId)) {
                this.steamID = jsonPlayerStats.getAsString(kSteamId);
            }

            if (jsonPlayerStats.containsKey(kGameName)) {
                this.gameName = jsonPlayerStats.getAsString(kGameName);
            }

            if (jsonPlayerStats.containsKey(kSuccess)) {
                this.success = (Boolean) jsonPlayerStats.get(kSuccess);
            }

            if (jsonPlayerStats.containsKey(kAchievements)) {
                JSONArray jsonAchievements = (JSONArray) jsonPlayerStats.get(kAchievements);

                for (int i = 0; i < jsonAchievements.size(); i++) {

                    Achievement achievement = new Achievement();
                    achievement.fromJsonObject((JSONObject) jsonAchievements.get(i));
                    this.achievements.add(achievement);

                }
            }

            if (jsonPlayerStats.containsKey(kStats)) {
                JSONArray jsonStats = (JSONArray) jsonPlayerStats.get(kStats);

                for (int i = 0; i < jsonStats.size(); i++) {
                    Stats stats = new Stats();
                    stats.fromJsonObject((JSONObject) jsonStats.get(i));
                    this.statsList.add(stats);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "PlayerStats{" + "\n" + "\n" +
                "steamID='" + steamID + '\'' + "\n" +
                ", gameName='" + gameName + '\'' + "\n" +
                ", achievements=" + achievements + "\n" +
                ", statsList=" + statsList + "\n" +
                ", success=" + success + "\n" +
                '}';
    }
}
