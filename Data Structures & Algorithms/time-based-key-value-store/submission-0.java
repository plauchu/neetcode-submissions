class TimeMap {

    private static class Entry {

        int timestamp;
        String value;

        Entry(int timestamp, String value) {

            this.timestamp = timestamp;
            this.value = value;
        }
    }

    private Map<String, List<Entry>> map;

    public TimeMap() {

        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Entry(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        List<Entry> list = map.getOrDefault(key, new ArrayList<>());

        String res = "";
        int lo = 0;
        int hi = list.size() - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            Entry e = list.get(mid);

            if (e.timestamp <= timestamp) {
                res = e.value;      // candidato válido: lo guardo
                lo = mid + 1;       // pero busco uno mejor a la derecha
            } else {
                hi = mid - 1;       // demasiado tarde: descarto esta mitad
            }
        }

        return res;
    }
}
