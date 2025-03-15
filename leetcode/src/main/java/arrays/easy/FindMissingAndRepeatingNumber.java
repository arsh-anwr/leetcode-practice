package arrays.easy;

import java.util.ArrayList;

public class FindMissingAndRepeatingNumber {

    ArrayList<Integer> findTwoElement(int arr[]) {
        // code here

        /**
         *  sum = n (n + 1) / 2; (1 -> n)
         *  sum - x + y = arrSum;
         *  y - x = arrSum - sum;
         *
         * (1ˆ2 -> n^2) -> = n (n + 1) (2n + 1)/ 6;
         * squaresum - x^2 + y^2 = arrSquareSum;
         * yˆ2 - xˆ2 = arrSquareSum - squaresum;
         *
         * y2 - x2 = (y -x)(y +x);
         *
         * (arrSum - sum) * (y + x) = arrSquareSum - squaresum;
         * y + x = arrSquareSum - squaresum / (arrSum - sum);
         *
         * y = (arrSquareSum - squaresum) * (arrSum - sum) ^ 2 / 2 * (arrSum - sum);
         *
         * x = sum - arrSum + y;
         *
         * y -> repeating number
         * x -> missing number
         */

        int n = arr.length;
        long arrSum = (n * (n + 1) / 2);
        long arrSquareSum = ( n * (n + 1) * (2 * n + 1)/ 6);
        long sum = 0l;
        long squareSum = 0l;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            squareSum += arr[i] * arr[i];
        }


        long extraNumber = ((squareSum - arrSquareSum)/ (sum - arrSum)) + (sum - arrSum);
        int extraNumber1 = (int) ( extraNumber / 2);
        int missingNumber = (int) (arrSum - sum + extraNumber1);

        ArrayList<Integer> list = new ArrayList();
        list.add(extraNumber1);
        list.add(missingNumber);

        return list;
    }
}
