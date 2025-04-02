package slidingWindow.medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstrWoutRepeatingChar {

    //OPTIMAL APPROACH--------------------------------------------------------------------------------------------------

    public int lengthOfLongestSubstring(String s) {
        /**
                0 1 2 3 4 5 6 7
              [ a b c a b c b b ]
         l->    l _ _ _ l _ _ l|left
         r->    r r r r r r r r|right
         maxA-> 1 2 3 3 3 3 3 3|r-l+1 or max
         Map->        T     T  |

         */
        HashMap<Character,Integer> map = new HashMap<>();

        int n = s.length();
        int left =0, right =0;
        int ans = 0;

        while(right < n){
            if(map.containsKey(s.charAt(right)))
                left = Math.max(map.get(s.charAt(right)) +1 , left);//

            map.put(s.charAt(right) , right);
            ans = Math.max(ans ,  right - left +1);
            right++;
        }
        return ans;
    }





    //BETTER APPROACH---------------------------------------------------------------------------------------------------




    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;

        int ans = Integer.MIN_VALUE;
        Set<Character> set = new HashSet<>();
        int left =0;
        for(int right =0; right < s.length(); right++){// outer loop for traversing the string

            if(set.contains(s.charAt(right))){//if duplicate element is found

                while(left < right && set.contains(s.charAt(right))){
                    set.remove(s.charAt(left));
                    left++;
                }
            }

            set.add(s.charAt(right));
            ans = Math.max(ans, right-left+1);
        }

        return ans;
    }
}
