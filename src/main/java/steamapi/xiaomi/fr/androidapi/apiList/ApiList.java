package steamapi.xiaomi.fr.androidapi.apiList;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

import steamapi.xiaomi.fr.androidapi.services.JsonBasedObject;

/**
 * Created by xiaomi on 14/12/13.
 */
public class ApiList implements JsonBasedObject {

    private static final String kApiList = "apilist";
    private static final String kInterfacesList = "interfaces";

    private List<Interfaces> interfacesList;

    public ApiList() {
        this.interfacesList = new LinkedList<>();
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
        if (json.containsKey(kApiList)) {
            JSONObject apiList = (JSONObject) json.get(kApiList);

            if (apiList.containsKey(kInterfacesList)) {
                JSONArray interfaces = (JSONArray) apiList.get(kInterfacesList);

                for (int i = 0; i < interfaces.size(); i++) {
                    JSONObject interF = (JSONObject) interfaces.get(i);
                    Interfaces newInterface = new Interfaces();
                    newInterface.fromJsonObject(interF);
                    this.interfacesList.add(newInterface);
                }
            }
        }
    }
}
