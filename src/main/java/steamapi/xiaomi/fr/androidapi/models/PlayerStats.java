package steamapi.xiaomi.fr.androidapi.models;



import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.models.Achievement;
import steamapi.xiaomi.fr.androidapi.models.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/09.
 */
public class PlayerStats implements JsonBasedObject {

    private String steamID;
    private String gameName;
    private List<Achievement> achievements;
    private boolean success;

    public PlayerStats() {
        this.steamID = "";
        this.gameName = "";
        this.achievements = new ArrayList<>();
        this.success = false;
    }

    public PlayerStats(String steamID, String gameName, List<Achievement> achievements, boolean success) {
        this.steamID = steamID;
        this.gameName = gameName;
        this.achievements = achievements;
        this.success = success;
    }

    public String getSteamID() {
        return steamID;
    }

    public void setSteamID(String steamID) {
        this.steamID = steamID;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(List<Achievement> achievements) {
        this.achievements = achievements;
    }


    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "steam id:" + steamID + "\ngame name:" + gameName + "\nnumber of achievements:" + achievements.size() + "\nsuccess:" + success;
    }


    @Override
    public JSONObject toJsonObject() {


        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {

        JSONObject jsonPlayerStats = (JSONObject) json.get("playerstats");

        this.setSteamID((String) jsonPlayerStats.get("steamID"));
        this.setGameName((String) jsonPlayerStats.get("gameName"));
        this.setSuccess((Boolean) jsonPlayerStats.get("success"));

        JSONArray jsonAchievements = (JSONArray) jsonPlayerStats.get("achievements");

        for (int i = 0; i < jsonAchievements.size(); i++) {
            JSONObject jsonAchievement = (JSONObject) jsonAchievements.get(i);
            this.achievements.add(
                    new Achievement(
                            (String) jsonAchievement.get("apiname"),
                            (Long) jsonAchievement.get("achieved")
                    )
            );
        }

    }

    public double percentAchieved() {
        double total = achievements.size();
        double achieved = 0;
        for (Achievement achievement : achievements) {
            if (achievement.getAchieved() == 1) {
                achieved++;
            }
        }

        return (achieved / total) * 100;
    }
}
