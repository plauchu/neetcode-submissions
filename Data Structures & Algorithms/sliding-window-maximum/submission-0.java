class Solution {
/*
Dentro del bucle, en este orden exacto

Caducar por delante. Mientras la cola no esté vacía y dq.peekFirst() < i - k + 1, haz dq.pollFirst(). Ese índice ya quedó fuera de la ventana.
Limpiar por detrás. Mientras la cola no esté vacía y nums[dq.peekLast()] <= nums[i], haz dq.pollLast(). Son los que el nuevo elemento acaba de dejar inútiles.
Insertar. dq.offerLast(i).
Registrar, solo si la ventana está completa. Si i >= k - 1, entonces res[i - k + 1] = nums[dq.peekFirst()].

Al final
8. return res;
*/
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if (nums == null || nums.length == 0) return new int[0];

        int[] res = new int[nums.length - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            while (!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();

            }
            while (!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
                
            }
            dq.offerLast(i);
             if (i >= k - 1) res[i - k + 1] = nums[dq.peekFirst()];
        } 

        return res;
    }
}
