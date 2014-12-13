package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Parameters {

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

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isOptional() {
        return optional;
    }

    public void setOptional(boolean optional) {
        this.optional = optional;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void fromJson(JSONObject json){
        this.name = json.getAsString("name");
        this.type = json.getAsString("type");
        this.description = json.getAsString("description");
        this.optional = (Boolean) json.get("optional");
    }

    @Override
    public String toString() {
        return "\nParameters{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", optional=" + optional +
                ", description='" + description + '\'' +
                '}';
    }
}
