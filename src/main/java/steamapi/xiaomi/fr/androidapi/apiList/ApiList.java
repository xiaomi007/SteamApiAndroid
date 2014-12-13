package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaomi on 14/12/13.
 */
public class ApiList {

    List<Interfaces> interfacesList;

    public ApiList() {
        this.interfacesList = new ArrayList<>();
    }

    public ApiList(List<Interfaces> interfacesList) {
        this.interfacesList = interfacesList;
    }

    public List<Interfaces> getInterfacesList() {
        return interfacesList;
    }

    public void setInterfacesList(List<Interfaces> interfacesList) {
        this.interfacesList = interfacesList;
    }

    public void fromJson(JSONObject json) {
        JSONObject apiList = (JSONObject) json.get("apilist");

        JSONArray interfaces = (JSONArray) apiList.get("interfaces");

        for (int i = 0; i < interfaces.size(); i++) {
            JSONObject interF = (JSONObject) interfaces.get(i);
            Interfaces newInterface = new Interfaces();
            newInterface.fromJson(interF);
            this.interfacesList.add(newInterface);
        }

    }

    @Override
    public String toString() {
        return "ApiList{\n" +
                "interfacesList=\n" + interfacesList.toString() +
                '}';
    }
}
