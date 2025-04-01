package arrays.medium;

import java.util.HashSet;

public class LongestSuccessiveElement {
    //OPTIMAL APPROACH C++ ----------------------------------------------------------------------------------------

    /**
     int longestSuccessiveElements(vector<int>&a) {
     // Write your code here.
     int n = a.length;
     if (n == 0)
     return 0;

     int longest = 1;
     Set<Integer> set = new HashSet<>();

     // put all the array elements into set
     for (int i = 0; i < n; i++) {
     set.add(a[i]);
     }

     // Find the longest sequence
     for (int it : set) {
     // if 'it' is a starting number
     if (!set.contains(it - 1)) {
     // find consecutive numbers
     int cnt = 1;
     int x = it;
     while (set.contains(x + 1)) {
     x = x + 1;
     cnt = cnt + 1;
     }
     longest = Math.max(longest, cnt);
     }
     }
     return longest;
     }

     */








    //OPTIMAL APPROACH----------------------------------------------------------------------------------------------
    public static int longestSuccessiveElements(int []a) {
        // Write your code here.
        int n = a.length;
        if (n == 0)
            return 0;

        int longest = 1;
        HashSet<Integer> set = new HashSet<>();

        // put all the array elements into set
        for (int i = 0; i < n; i++) {
            set.add(a[i]);
        }

        // Find the longest sequence
        for (int it : set) {
            // if 'it' is a starting number
            if (!set.contains(it - 1)) {
                // find consecutive numbers
                int cnt = 1;
                int x = it;
                while (set.contains(x + 1)) {
                    x = x + 1;
                    cnt = cnt + 1;
                }
                longest = Math.max(longest, cnt);
            }
        }
        return longest;

    }











    //BRUTE FORCE APPROACH------------------------------------------------------------------------------------------

    public static int longestSuccessiveElements(int []a) {

        // Write your code here.
        int n = a.length; //size of array
        int longest = 1;
        //pick a element and search for its
        //consecutive numbers:
        for (int i = 0; i < n; i++) {
            int x = a[i];
            int cnt = 1;
            //search for consecutive numbers
            //using linear search:
            while (linearSearch(a, x + 1) == true) {
                x += 1;
                cnt += 1;
            }

            longest = Math.max(longest, cnt);
        }
        return longest;
    }
    public static boolean linearSearch(int []a, int num) {
        int n = a.length; //size of array
        for (int i = 0; i < n; i++) {
            if (a[i] == num)
                return true;
        }
        return false;
    }
}
