package steamapi.xiaomi.fr.androidapi.game.gameTest;

import net.minidev.json.JSONObject;

/**
 * Created by xiaomi on 14/12/14.
 */
public class GameTestExtra extends Game{

    private static final String kName = "name";
    private static final String kImgLogoUrl = "img_logo_url";
    private static final String kImgIconUrl = "img_icon_url";
    private static final String kHasCommunityVisibleStats = "has_community_visible_stats";

    private String name;
    private String imgIconUrl;
    private String imgLogoUrl;
    private boolean hasCommunityVisibleStats;

    public GameTestExtra() {
        super();
        this.name = "";
        this.imgIconUrl = "";
        this.imgLogoUrl = "";
        this.hasCommunityVisibleStats = false;
    }

    public String getName() {
        return name;
    }

    public String getImgIconUrl() {
        return imgIconUrl;
    }

    public String getImgLogoUrl() {
        return imgLogoUrl;
    }

    public boolean isHasCommunityVisibleStats() {
        return hasCommunityVisibleStats;
    }

    @Override
    public JSONObject toJsonObject() {
        return null;
    }

    @Override
    public void fromJsonObject(JSONObject json) {
        super.fromJsonObject(json);

        if(json.containsKey(kName)){
            this.name = json.getAsString(kName);
        }

        if(json.containsKey(kImgIconUrl)){
            this.imgIconUrl = json.getAsString(kImgIconUrl);
        }

        if(json.containsKey(kImgLogoUrl)){
            this.imgLogoUrl = json.getAsString(kImgLogoUrl);
        }

        if(json.containsKey(kHasCommunityVisibleStats)){
            this.hasCommunityVisibleStats = (Boolean) json.get(kHasCommunityVisibleStats);
        }
    }

    @Override
    public String toString() {
        return super.toString() + "\n" +
                "GameTestExtra{" +"\n" +
                "name='" + name + '\'' +"\n" +
                ", imgIconUrl='" + imgIconUrl + '\'' +"\n" +
                ", imgLogoUrl='" + imgLogoUrl + '\'' +"\n" +
                ", hasCommunityVisibleStats=" + hasCommunityVisibleStats +"\n" +
                '}';
    }
}
