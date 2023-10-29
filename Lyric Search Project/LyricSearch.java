import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class LyricSearch{

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in); //takes input for Song Lyric search
        System.out.print("Enter Song Lyric:");
        int a = s.nextInt();
    }

    private static String getMatchingLyrics(String lyrics, List<String> keywords) {
        String[] lyricWords = lyrics.split(" ");

        // Split and get the word index for keyword matches
        Map<Integer, String> lyricEngine = new TreeMap<>();
        for(int i = 0; i < lyricWords.length; i++) {
            String search = lyricWords[i].toLowerCase().replaceAll(" ", "");
            if (keywords.contains(search) && !lyricEngine.values().contains(lyricWords[i])) {
                lyricEngine.put(i, lyricWords[i]);
            }
        }

        Integer min = null;
        Integer max = null;
        if (lyricEngine.size() == 1) {
            return lyricEngine.values().iterator().next();
        } else if (lyricEngine.size() <= keywords.size()) {
            List<Integer> coll = new ArrayList<>(lyricEngine.keySet());
            min = coll.get(0);
            max = coll.get(lyricEngine.size() - 1);
        } else {
            // Prepare the difference between the indexes
            Map<Integer, String> set = new TreeMap<>(); 
            List<Integer> keys = new ArrayList<>(lyricEngine.keySet());
            for(int i = 0; i <= lyricEngine.size() - keywords.size(); i++) {
                int j = i + keywords.size() - 1;
                int diff = keys.get(j);
                StringBuilder str = new StringBuilder(keys.get(j) + "");
                for (j = j - 1; j >= i; j--) {
                    diff -= keys.get(j);
                    str.append(',');
                    str.append(keys.get(j));
                }
                set.put(diff, str.toString());
            }

            // Get the value with minimum difference
            for(String s:set.get(set.keySet().toArray()[0]).split(",")) {
                int x = Integer.parseInt(s);
                if (min == null && max == null) {
                    max = x;
                    min = x;
                } else {
                    if (x > max) {
                        max = x;
                    } else if (x < min) {
                        min = x;
                    }
                }
            }
        }

        // Build the string from indexes
        StringBuilder s = new StringBuilder();
        for (int i = min; i <= max; i++) {
            s.append(lyricWords[i]);
            if (i < max) {
                s.append(" ");
            }
        }
        return s.toString();
    }
}