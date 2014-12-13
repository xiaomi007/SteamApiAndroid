package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaomi on 14/12/13.
 */
public class Interfaces {

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

    public void setName(String name) {
        this.name = name;
    }

    public List<Methods> getMethodsList() {
        return methodsList;
    }

    public void setMethodsList(List<Methods> methodsList) {
        this.methodsList = methodsList;
    }

    public void fromJson(JSONObject json){
        this.name = json.getAsString("name");

        JSONArray methods = (JSONArray) json.get("methods");

        for(int i = 0; i < methods.size(); i++){
            Methods method = new Methods();
            method.fromJson((JSONObject) methods.get(i));
            this.methodsList.add(method);
        }

    }

    @Override
    public String toString() {
        return "\nInterfaces{" +
                "name='" + name + '\'' +
                ", methodsList=\n" + methodsList.toString() +
                '}';
    }
}
