class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Siempre binary search sobre el array más corto: garantiza O(log(min(m,n)))
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int m = nums1.length, n = nums2.length;
        int half = (m + n + 1) / 2;   // tamaño de la mitad izquierda

        int lo = 0, hi = m;

        while (lo <= hi) {
            int i = lo + (hi - lo) / 2;   // cuántos cojo de nums1
            int j = half - i;             // los que faltan salen de nums2

            // Centinelas: si el corte cae en un extremo, no hay vecino real
            int left1  = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == m) ? Integer.MAX_VALUE : nums1[i];
            int left2  = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n) ? Integer.MAX_VALUE : nums2[j];

            if (left1 <= right2 && left2 <= right1) {          // corte correcto
                if ((m + n) % 2 == 1) {
                    return Math.max(left1, left2);
                }
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            } else if (left1 > right2) {                       // cogí de más en nums1
                hi = i - 1;
            } else {                                           // cogí de menos
                lo = i + 1;
            }
        }

        return 0.0;   // inalcanzable si las entradas están ordenadas
    }
}