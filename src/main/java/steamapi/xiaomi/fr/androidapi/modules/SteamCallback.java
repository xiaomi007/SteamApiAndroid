package steamapi.xiaomi.fr.androidapi.modules;

/**
 * Created by xiaomi on 14/12/10.
 */
public interface SteamCallback<T>{

    public void onComplete(final T data, final Exception exception);

}
