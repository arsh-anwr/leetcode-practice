class Solution {
    public int longestSubarray(int[] arr, int k) {
        // code here
        int n = arr.length;
        int left  =  0;
        int right = 0;
        int sum = arr[0];
        int maxlen = 0;


        while (right < n) {
            // if sum > k, reduce the subarray from left
            // until sum becomes less or equal to k:
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            }

            // if sum = k, update the maxLen i.e. answer:
            if (sum == k) {
                maxlen = Math.max(maxlen, right - left + 1);
            }

            // Move forward thw right pointer:
            right++;
            if (right < n) sum += arr[right];
        }

        return maxlen;

    }
}


/**
 * static int longestSubarray(int[] arr, int k) {
 *         int res = 0;
 *
 *         for (int i = 0; i < arr.length; i++) {
 *
 *             // Sum of subarray from i to j
 *             int sum = 0;
 *             for (int j = i; j < arr.length; j++) {
 *                 sum += arr[j];
 *
 *                 // If subarray sum is equal to k
 *                 if (sum == k) {
 *
 *                     // find subarray length and update result
 *                     int subLen = j - i + 1;
 *                     res = Math.max(res, subLen);
 *                 }
 *             }
 *         }
 *
 *         return res;
 *     }
 */