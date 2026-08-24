class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //paso 1. tienes 1 mapa
        Map<Integer, Integer> freq = new HashMap<>();
        //paso 2. sumamos las ocurrencias
        for (int n : nums) freq.merge(n, 1, Integer::sum);

        //paso 3. ahora si viene el heap
        PriorityQueue<Integer> heap =
        //lambda con una operación que ordena con el menos frecuente hasta arriba para sacarlo fácil
            new PriorityQueue<>((a, b) -> freq.get(a) - freq.get(b));

        //paso 4. sacamos el mínimo por cada clave única
        for (int key : freq.keySet()) {
            heap.offer(key);
            //si el tamaño es mayor a k lo eliminamos del monticulo
            if (heap.size() > k) heap.poll();
        }

        //paso 5. al final literalmente sacamos los k elementos del heap
        int[] out = new int[k];
        for (int i = k - 1; i >= 0; i--) out[i] = heap.poll();
        return out;
        }
}
