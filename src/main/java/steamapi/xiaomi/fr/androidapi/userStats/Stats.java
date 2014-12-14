package steamapi.xiaomi.fr.androidapi.userStats;

import net.minidev.json.JSONObject;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class Stats implements JsonBasedObject {

    private static final String kName = "name";
    private static final String kValue = "value";

    private String name;
    private int value;

    public Stats() {
        this.name = "";
        this.value = 0;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        if (json.containsKey(kName)) {
            this.name = json.getAsString(kName);
        }

        if (json.containsKey(kValue)) {
            this.value = (Integer) json.get(kValue);
        }
    }

    @Override
    public String toString() {
        return "Stats{" + "\n" +
                "name='" + name + '\'' + "\n" +
                ", value=" + value + "\n" +
                '}';
    }
}
