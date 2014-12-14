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

    private static final String kName = "name";
    private static final String kVersion = "version";
    private static final String kHttpMethod = "httpmethod";
    private static final String kParameters = "parameters";

    private String name;
    private int version;
    private String httpMethod;
    private List<Parameters> parametersList;

    public Methods() {
        this.name = "";
        this.version = 0;
        this.httpMethod = "";
        this.parametersList = new ArrayList<>();
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

    public List<Parameters> getParametersList() {
        return parametersList;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        if(json.containsKey(kName)) {
            this.name = json.getAsString(kName);
        }

        if(json.containsKey(kVersion)) {
            this.version = (Integer) json.get(kVersion);
        }

        if(json.containsKey(kHttpMethod)) {
            this.httpMethod = json.getAsString(kHttpMethod);
        }

        if(json.containsKey(kParameters)) {
            JSONArray parameters = (JSONArray) json.get(kParameters);

            for (int i = 0; i < parameters.size(); i++) {
                Parameters parameter = new Parameters();
                parameter.fromJsonObject((JSONObject) parameters.get(i));
                this.parametersList.add(parameter);
            }
        }
    }
}

