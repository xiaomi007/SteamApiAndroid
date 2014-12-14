package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONObject;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Parameters implements JsonBasedObject {

    private static final String kName = "name";
    private static final String kType = "type";
    private static final String kOptional = "optional";
    private static final String kDescription = "description";

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
        if (json.containsKey(kName)) {
            this.name = json.getAsString(kName);
        }

        if (json.containsKey(kType)) {
            this.type = json.getAsString(kType);
        }

        if (json.containsKey(kDescription)) {
            this.description = json.getAsString(kDescription);
        }

        if (json.containsKey(kOptional)) {
            this.optional = (Boolean) json.get(kOptional);
        }
    }


}
