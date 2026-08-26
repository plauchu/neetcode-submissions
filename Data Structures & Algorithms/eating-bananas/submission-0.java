class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int lo = 1, hi = 0;
        for (int p : piles) hi = Math.max(hi, p);
        int res = hi;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            long hours = 0;
            for (int p : piles) {
                hours += (p + mid - 1) / mid;
            }

            if (hours <= h) {
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
}