class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];

        int acumLeft = 1;
        for (int left = 0; left < nums.length; left++){
            res[left] = acumLeft;
            acumLeft *= nums[left];
        }   

        int acumRight = 1;
        for (int right = nums.length - 1; right >= 0; right--){
            res[right] *= acumRight;
            acumRight *= nums[right];
        }

        return res;
    }
}  
