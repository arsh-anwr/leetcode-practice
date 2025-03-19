import java.util.*;
public class Solution {
    public int colorful(int A) {
        HashSet<Integer> hashSet = new HashSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        while(A != 0){
            int num = A % 10;
            list.add(num);
            A /= 10;
        }

        Collections.reverse(list);
        int n = list.size();

        for(int i=0; i < n; i++){
            for(int j=i; j < n; j++){
                int prod = 1;
                for(int k=i; k <=j; k++){
                    prod = prod * list.get(k);
                }
                if(hashSet.contains(prod))
                    return 0;
                hashSet.add(prod);
            }
        }
        return 1;
    }
}
