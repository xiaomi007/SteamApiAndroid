package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Methods implements JsonBasedObject{

    private String name;
    private int version;
    private String httpMethod;
    private String description;
    private List<Parameters> parametersList;

    public Methods() {
        this.name = "";
        this.version = 0;
        this.httpMethod = "";
        this.description = "";
        this.parametersList = new ArrayList<>();
    }

    public Methods(String name, int version, String httpMethod, String description, List<Parameters> parametersList) {
        this.name = name;
        this.version = version;
        this.httpMethod = httpMethod;
        this.description = description;
        this.parametersList = parametersList;
    }

    public String getName() {
        return name;
    }

    public int getVersion() {
        return version;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public String getDescription() {
        return description;
    }

    public List<Parameters> getParametersList() {
        return parametersList;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        this.name = json.getAsString("name");
        this.version = (Integer) json.get("version");
        this.httpMethod = json.getAsString("httpmethod");

        JSONArray parameters = (JSONArray) json.get("parameters");

        for(int i = 0; i < parameters.size(); i++){
            Parameters parameter = new Parameters();
            parameter.fromJsonObject((JSONObject) parameters.get(i));
            this.parametersList.add(parameter);
        }
    }
}

