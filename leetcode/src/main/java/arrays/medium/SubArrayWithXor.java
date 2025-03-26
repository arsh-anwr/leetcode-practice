package arrays.medium;

import java.util.ArrayList;
import java.util.HashMap;

public class SubArrayWithXor {
    public int solve(ArrayList<Integer> A, int B) {
        /**
         4 2 2 6 4

         prefixXor = 4 6 4 2 6

         map = {{prefixXorTillI, Occurence}}

         i = 0, prefixXor = 4, 4 ^ 6, map.put(4, 1);
         i = 1, prefixXor = 6, 6 ^ 6, map.put(4, 1);
         i = 2, prefixXor = 4, 4 ^ 6, map.put((4, 2));
         i = 3, prefixXor = 2, 2 ^ 6, map.put((4, 2), (2, 1));
         i = 4, prefixXor = 6, 6 ^ 6, map.put((4, 2), (2, 1), (6, 1));

         4 ^ 6 = 2

         B ^ B = 0

         1 4 2 1 6

         0 1 5 7 6 0

         7 (111) ^ 1(001) -> 110

         7(111) ^ B(6 -> 110) = 1

         4            -> 4
         #   4 2          -> 6
         4 2 2        -> 4
         4 2 2 6      -> 2
         #   4 2 2 6 4    -> 6
         2            -> 2
         2 2          -> 0
         #   2 2 6        -> 6
         2 2 6 4      -> 2
         2            -> 2
         2 6          -> 4
         2 6 4        -> 0
         #   6            -> 6
         6 4          -> 2
         4            -> 4
         */

        HashMap<Long, Integer> map = new HashMap<>();

        long prefixSum = 0L;
        int ans = 0;

        for (int j = 0; j < A.size(); j++) {
            prefixSum ^= A.get(j);
            if (map.containsKey(prefixSum ^ B)) {
                ans += map.get(prefixSum ^ B);
            }

            if (prefixSum == B) ans++;

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return ans;
    }
}
