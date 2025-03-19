class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverseArray( nums, 0, n-1);
        reverseArray( nums, 0, k-1);
        reverseArray( nums, k, n-1);

    }

    public void reverseArray(int[] arr , int left, int right) {

        while(left<right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}