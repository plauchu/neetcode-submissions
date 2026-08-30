class Twitter {
    private int time = 0;
    private final Map<Integer, List<int[]>> tweets = new HashMap<>();
    private final Map<Integer, Set<Integer>> following = new HashMap<>();

    public void postTweet(int userId, int tweetId) {
        tweets.computeIfAbsent(userId, k -> new ArrayList<>())
              .add(new int[]{time++, tweetId});
    }

    public List<Integer> getNewsFeed(int userId) {
        // max-heap por timestamp: {timestamp, tweetId, usuario, índice en
        // su lista}
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        Set<Integer> sources = new HashSet<>(following.getOrDefault(userId, 
            new HashSet<>()));
        sources.add(userId);

        for (int src : sources) {
            List<int[]> list = tweets.get(src);
            if (list == null || list.isEmpty()) continue;
            int last = list.size() - 1;
            heap.offer(new int[]{list.get(last)[0], list.get(last)[1], src, last});
        }

        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty() && res.size() < 10) {
            int[] top = heap.poll();
            res.add(top[1]);

            int idx = top[3] - 1;              // el anterior de esa misma lista
            if (idx >= 0) {
                List<int[]> list = tweets.get(top[2]);
                heap.offer(new int[]{list.get(idx)[0], list.get(idx)[1], top[2]
                , idx});
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        following.computeIfAbsent(followerId, k -> 
            new HashSet<>()).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = following.get(followerId);
        if (set != null) set.remove(followeeId);
    }
}