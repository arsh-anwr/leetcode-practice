package binarySearch.hard;

public class KokoEatingBanana {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Integer.MIN_VALUE;
        int ans = -1;

        for (int pile: piles) high = Math.max(high, pile);

        while (low <= high) {
            int k = low + (high - low) / 2;

            if (solve(piles, k, h)) {
                high = k - 1;
                ans = k;
            } else {
                low = k + 1;
            }
        }

        return ans;
    }

    private boolean solve(int[] piles, int k, int h) {
        int hourCount = 0;

        for (int i = 0; i < piles.length; i++) {
            hourCount += piles[i] / k;
            hourCount += piles[i] % k != 0 ? 1 : 0;

            if (hourCount > h) return false;
        }

        return true;
    }
}
