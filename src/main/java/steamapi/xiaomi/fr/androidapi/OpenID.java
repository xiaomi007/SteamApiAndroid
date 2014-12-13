package steamapi.xiaomi.fr.androidapi;

import android.util.Log;


import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xiaomi on 14/12/11.
 */
public class OpenID {

    /*
    private static final String TAG = OpenID.class.getSimpleName();

    public static final String OPEN_ID_PROVIDER = "http://steamcommunity.com/openid";
    private final Pattern STEAM_REGEX = Pattern.compile("(\\d+)");
    private final ConsumerManager consumerManager;
    private DiscoveryInformation discovered;

    public OpenID() throws ConsumerException {
        consumerManager = new ConsumerManager();
        consumerManager.setMaxAssocAttempts(0);
        try {
            discovered = consumerManager.associate(consumerManager.discover(OPEN_ID_PROVIDER));
        } catch (DiscoveryException e) {
            e.printStackTrace();
            discovered = null;
        }
    }

    public String login(String callbackURL) {
        if (this.discovered == null) {
            return null;
        }

        try {
            AuthRequest authRequest = consumerManager.authenticate(this.discovered, callbackURL);
            return authRequest.getDestinationUrl(true);
        } catch (MessageException | ConsumerException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String verify(String receivingURL, Map responseMap) {
        if (this.discovered == null) {
            return null;
        }

        ParameterList parameterList = new ParameterList(responseMap);
        try {
            VerificationResult verificationResult = consumerManager.verify(receivingURL, parameterList, this.discovered);
            Identifier identifier = verificationResult.getVerifiedId();
            if (identifier != null) {
                String id = identifier.getIdentifier();
                Matcher matcher = STEAM_REGEX.matcher(id);
                if (matcher.find()) {
                    Log.d(TAG, "id:" + matcher.group(1));
                    return matcher.group(1);
                } else {
                    return null;
                }
            } else {
                return null;
            }

        } catch (AssociationException | MessageException | DiscoveryException e) {
            e.printStackTrace();
            return null;
        }
}
*/

}
