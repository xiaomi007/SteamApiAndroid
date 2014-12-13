package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Interfaces implements JsonBasedObject{

    private String name;
    private List<Methods> methodsList;

    public Interfaces() {
        this.name = "";
        this.methodsList = new ArrayList<>();
    }

    public Interfaces(String name, List<Methods> methodsList) {
        this.name = name;
        this.methodsList = methodsList;
    }

    public String getName() {
        return name;
    }

    public List<Methods> getMethodsList() {
        return methodsList;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        this.name = json.getAsString("name");

        JSONArray methods = (JSONArray) json.get("methods");

        for(int i = 0; i < methods.size(); i++){
            Methods method = new Methods();
            method.fromJsonObject((JSONObject) methods.get(i));
            this.methodsList.add(method);
        }
    }
}
