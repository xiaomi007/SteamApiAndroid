package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Methods {

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

    public void setName(String name) {
        this.name = name;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public List<Parameters> getParametersList() {
        return parametersList;
    }

    public void setParametersList(List<Parameters> parametersList) {
        this.parametersList = parametersList;
    }

    public void fromJson(JSONObject json){
        this.name = json.getAsString("name");
        this.version = (Integer) json.get("version");
        this.httpMethod = json.getAsString("httpmethod");

        JSONArray parameters = (JSONArray) json.get("parameters");

        for(int i = 0; i < parameters.size(); i++){
            Parameters parameter = new Parameters();
            parameter.fromJson((JSONObject) parameters.get(i));
            this.parametersList.add(parameter);
        }

    }

    @Override
    public String toString() {
        return "\nMethods{" +
                "name='" + name + '\'' +
                ", version=" + version +
                ", httpMethod='" + httpMethod + '\'' +
                ", description='" + description + '\'' +
                ", parametersList=\n" + parametersList.toString() +
                '}';
    }
}

