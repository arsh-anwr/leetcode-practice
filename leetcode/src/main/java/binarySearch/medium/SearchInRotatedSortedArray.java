package binarySearch.medium;

public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        /**
         [1 4 6 7 8] -> 0, N, 2N....
         [4 6 7 8 1] -> 1, N + 1, 2N + 1...

         [1 4 6 7 8] -> [4 6 7 8 1] -> [6 7 8 1 4]

         [6 7 8            1 4]

         8 9 10 11 1 4 6

         binSearch(0, 2)

         binSearch(3, 4)

         -1
         */

        int pivot = nums.length;

        /**
         BS for pivot;
         */
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] >= nums[0]) low = mid + 1;
            else if (nums[mid] < nums[0]) {
                high = mid - 1;
                pivot = mid;
            }
        }

        int left = binSearch(nums, target, 0, pivot - 1);
        int right = binSearch(nums, target, pivot, nums.length - 1);

        if (left == -1) {
            if (right == -1) return -1;
            else return right;
        } else return left;
    }


    private int binSearch(int[] nums, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) low = mid + 1;
            else if (nums[mid] > target) high = mid - 1;
            else return mid;
        }

        return -1;
    }
}
