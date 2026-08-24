class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums){
            set.add(num);
        }

        int longest = 0;
        for (int number : set) {
            if (!set.contains(number - 1)) {
                int current = number;
                int length = 0;
                while (set.contains(current)) {
                    length++;
                    current++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }
}
