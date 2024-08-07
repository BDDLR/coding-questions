import java.util.HashMap;
import java.util.Map;

public class DomainCounting {
    public static void main(String[] args) {
        String[] counts = {
                "900,google.com",
                "60,mail.yahoo.com",
                "10,mobile.sports.yahoo.com",
                "40,sports.yahoo.com",
                "300,yahoo.com",
                "10,stackoverflow.com",
                "20,overflow.com",
                "5,com.com",
                "2,en.wikipedia.org",
                "1,m.wikipedia.org",
                "1,mobile.sports",
                "1,google.co.uk"
        };

        System.out.println(calculateClicksByDomain(counts));
    }

    private static Map<String, Integer> calculateClicksByDomain(String[] counts) {

        var resultMap = new HashMap<String, Integer>();

        // Iterate array
        for (int i = 0; i <= counts.length - 1; i++) {
            // Split by , to separate count from domain
            var splitItem = counts[i].split("\\,");
            var count = Integer.parseInt(splitItem[0]);
            System.out.println("%s - %s".formatted(splitItem[0], splitItem[1]));

            // Split the domain by . to get all of the domains of that item
            var splitDomain = splitItem[1].split("\\.");

            var tmpDomain = "";
            // Insert/update the domain in the map (key) and the count (value)
            for (int j = splitDomain.length - 1; j >= 0; j--) {
                var domain = "";
                if(j == splitDomain.length - 1) {
                    domain = splitDomain[j];
                } else {
                    domain = splitDomain[j]  + "." + tmpDomain;
                }
                
                System.out.println("Domain - " + domain);

                var tmpCount = 0;
                if (resultMap.containsKey(domain)) {
                    tmpCount = resultMap.get(domain);
                }
                resultMap.put(domain, count + tmpCount);

                tmpDomain = domain;

            }

        }

        return resultMap;
    }
}
