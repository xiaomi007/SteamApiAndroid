package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONObject;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Parameters implements JsonBasedObject {

    private String name;
    private String type;
    private boolean optional;
    private String description;

    public Parameters() {
        this.name = "";
        this.type = "";
        this.optional = false;
        this.description = "";
    }

    public Parameters(String name, String type, boolean optional, String description) {
        this.name = name;
        this.type = type;
        this.optional = optional;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isOptional() {
        return optional;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        this.name = json.getAsString("name");
        this.type = json.getAsString("type");
        this.description = json.getAsString("description");
        this.optional = (Boolean) json.get("optional");
    }
}
