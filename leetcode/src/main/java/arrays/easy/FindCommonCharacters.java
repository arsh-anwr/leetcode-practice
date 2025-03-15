package arrays.easy;

import java.util.ArrayList;
import java.util.List;

public class FindCommonCharacters {
    public List<String> commonChars(String[] words) {
        /**
         HashMap<Character> map;

         b e l l a

         map.put(b, e, l , l, a); b -> 1 e -> 1 l -> 2 a -> 1

         l a b e l; l -> 2 a -> 1 b -> 1, e -> 1
         b -> 1 e -> 1 a -> 1 l -> 2

         r o l l e r; r -> 2 o -> 1 l -> 2 e -> 1 b -> 0


         */

        int[] commonfreq = new int[26];
        int[] currFreq = new int[26];

        for (int i = 0; i < words[0].length(); i++) { // bella
            char ch = words[0].charAt(i);
            commonfreq[ch - 'a']++;
        }

        for (int i = 1; i < words.length; i++) {
            Arrays.fill(currFreq, 0);

            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                currFreq[ch - 'a']++;
            }

            for (int l = 0; l < 26; l++) {
                commonfreq[l] = Math.min(commonfreq[l], currFreq[l]);
            }
        }

        List<String> ans = new ArrayList();

        for (int l = 0; l < 26; l++) {
            for (int x = 0; x < commonfreq[l]; x++) ans.add((char) (l + 'a') + "");
        }

        return ans;
    }
}
