package arrays.easy;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayLeaders {


    //OPTIMAL APPROACH----------------------------------------------------------------------------------------------

    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> ls = new ArrayList<>();
        int n = arr.length;
        int leader = arr[n-1];

        for(int i = n-1; i >= 0; i--){
            if(arr[i] >= leader){
                leader = arr[i];
                ls.add(leader);
            }
        }

        Collections.reverse(ls);
        return ls;

    }





    //BRUTE FORCE APPROACH----------------------------------------------------------------------------------------



//    static ArrayList<Integer> leaders(int arr[]) {
//        // code here
//        int n = arr.length;
//        ArrayList<Integer> ls = new ArrayList<>();
//
//        for(int i =0; i < n; i++){
//            int j;
//            for( j = i + 1 ; j < n; j++){
//                if(arr[i] < arr[j]){
//                    break;
//                }
//            }
//            if(j == n)
//                ls.add(arr[i]);
//        }
//        return ls;
//
//    }



}
