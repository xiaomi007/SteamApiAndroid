package steamapi.xiaomi.fr.androidapi.models;


import net.minidev.json.JSONObject;

/**
 * Created by xiaomi on 14/12/09.
 */
public interface JsonBasedObject {

    public JSONObject toJsonObject();

    public void fromJsonObject(JSONObject json);

}
