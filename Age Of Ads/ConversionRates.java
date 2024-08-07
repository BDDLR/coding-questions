import java.util.HashMap;
import java.util.Map;

public class ConversionRates {
    public static void main(String[] args) {
        String[] completedPurchaseUsers = {
                "3123122444", "234111110", "8321125440", "99911063"
        };

        // "IP Address, timestamp, Ad text"
        String[] adClicks = {
                "122.121.0.1,2016-11-03 11:41:19,Buy wool coats for your pets",
                "96.3.199.11,2016-10-15 20:18:31,2017 Pet Mittens",
                "122.121.0.250,2016-11-01 06:13:13,The Best Hollywood Coats",
                "82.1.106.8,2016-11-12 23:05:14,Buy wool coats for your pets",
                "92.130.6.144,2017-01-01 03:18:55,Buy wool coats for your pets",
                "122.121.0.155,2017-01-01 03:18:55,Buy wool coats for your pets",
                "92.130.6.145,2017-01-01 03:18:55,2017 Pet Mittens"
        };

        // "User ID, IP address"
        String[] allUserIps = {
                "2339985511,122.121.0.155",
                "234111110,122.121.0.1",
                "3123122444,92.130.6.145",
                "39471289472,2001:0db8:ac10:fe01:0000:0000:0000:0000",
                "8321125440,82.1.106.8",
                "99911063,92.130.6.144"
        };

        System.out.println(conversionRates(completedPurchaseUsers, adClicks, allUserIps));

    }

    private static String conversionRates(String[] completedPurchaseUsers, String[] adClicks, String[] userIps) {
        var totalClicks = preprocessClickMap(adClicks);
        var userIpsMap = preprocessUserIpsMap(userIps);
        var ipAdMap = preprocessIpsAdMap(adClicks);
        var purchasedMap = new HashMap<String, Integer>();

        for (int i = 0; i <= completedPurchaseUsers.length - 1; i++) {
            var ip = userIpsMap.get(completedPurchaseUsers[i]);
            if (ipAdMap.containsKey(ip)) {
                var ad = ipAdMap.get(ip);
                var tmpCount = 0;
                if (purchasedMap.containsKey(ad)) {
                    tmpCount = purchasedMap.get(ad);
                }
                purchasedMap.put(ad, tmpCount + 1);
            }

        }

        var sb = new StringBuilder();
        totalClicks.forEach((k, v) -> {
            var safeValue = purchasedMap.get(k) != null ? purchasedMap.get(k) : 0;
            sb.append("%d of %d %s".formatted(safeValue, v, k));
            sb.append("\n");
        });

        return sb.toString();
    }

    private static Map<String, Integer> preprocessClickMap(String[] clicks) {
        var map = new HashMap<String, Integer>();
        for (int i = 0; i <= clicks.length - 1; i++) {
            var tmpCount = 0;
            var adText = clicks[i].split("\\,")[2];
            if (map.containsKey(adText)) {
                tmpCount = map.get(adText);
            }
            map.put(adText, tmpCount + 1);
        }
        return map;
    }

    private static Map<String, String> preprocessUserIpsMap(String[] userIps) {
        var map = new HashMap<String, String>();
        for (int i = 0; i <= userIps.length - 1; i++) {
            var split = userIps[i].split("\\,");
            map.put(split[0], split[1]);
        }
        return map;
    }

    private static Map<String, String> preprocessIpsAdMap(String[] clicks) {
        var map = new HashMap<String, String>();
        for (int i = 0; i <= clicks.length - 1; i++) {
            var split = clicks[i].split("\\,");
            map.put(split[0], split[2]);
        }
        return map;
    }
}
