import java.util.*;

public class BrowsingHistoryComparison {

    public static void main(String[] args) {
        String[] user0 = { "/start", "/green", "/blue", "/pink", "/register", "/orange", "/one/two" };
        String[] user1 = { "/start", "/pink", "/register", "/orange", "/red", "a" };
        String[] user2 = { "a", "/one", "/two" };
        String[] user3 = { "/pink", "/orange", "/yellow", "/plum", "/blue", "/tan", "/red", "/amber", "/HotRodPink",
                "/CornflowerBlue", "/LightGoldenRodYellow", "/BritishRacingGreen" };
        String[] user4 = { "/pink", "/orange", "/amber", "/BritishRacingGreen", "/plum", "/blue", "/tan", "/red",
                "/lavender", "/HotRodPink", "/CornflowerBlue", "/LightGoldenRodYellow" };
        String[] user5 = { "a" };
        String[] user6 = { "/pink", "/orange", "/six", "/plum", "/seven", "/tan", "/red", "/amber" };

        System.out.println(findContiguousHistory(user0, user1)); // Output: [/pink, /register, /orange]
        System.out.println(findContiguousHistory(user0, user2)); // Output: []
        System.out.println(findContiguousHistory(user0, user0)); // Output: [/start, /green, /blue, /pink, /register,/orange, /one/two]
        System.out.println(findContiguousHistory(user2, user1)); // Output: [a]
        System.out.println(findContiguousHistory(user5, user2)); // Output: [a]
        System.out.println(findContiguousHistory(user3, user4)); // Output: [/plum, /blue, /tan, /red]
        System.out.println(findContiguousHistory(user4, user3)); // Output: [/plum,/blue, /tan, /red]
        System.out.println(findContiguousHistory(user3, user6)); // Output: [/tan,/red, /amber]
        System.out.println(findContiguousHistory(user6, user3)); // Output: [/tan, /red, /amber]
    }

    public static List<String> findContiguousHistory(String[] user1, String[] user2) {
        List<String> longestSegment = new ArrayList<>();
        int maxLength = 0;

        for (int i = 0; i <= user1.length - 1; i++) {
            for (int j = 0; j <= user2.length - 1; j++) {
                int user1index = i;
                int user2index = j;
                List<String> currentSegment = new ArrayList<>();
                while (user1index < user1.length && user2index < user2.length && user1[user1index].equals(user2[user2index])) {
                    currentSegment.add(user1[user1index]);
                    user1index++;
                    user2index++;
                }

                if (currentSegment.size() > maxLength) {
                    maxLength = currentSegment.size();
                    longestSegment = new ArrayList<>(currentSegment);
                }
            }
        }

        return longestSegment;
    }

}
