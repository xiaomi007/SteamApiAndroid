package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.models.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class ApiList implements JsonBasedObject {

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


    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        JSONObject apiList = (JSONObject) json.get("apilist");

        JSONArray interfaces = (JSONArray) apiList.get("interfaces");

        for (int i = 0; i < interfaces.size(); i++) {
            JSONObject interF = (JSONObject) interfaces.get(i);
            Interfaces newInterface = new Interfaces();
            newInterface.fromJsonObject(interF);
            this.interfacesList.add(newInterface);
        }
    }
}
