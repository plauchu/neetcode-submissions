class Solution {
    public boolean isPalindrome(String s) {

        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        char[] aux = s.toCharArray();

        for (int i = 0; i < aux.length; i++) {
            aux[i] = Character.toLowerCase(aux[i]);
        }
        

        while(left < right){
            while(left < right && !Character.isLetterOrDigit(aux[left])){
                left++;
            }

            while(left < right && !Character.isLetterOrDigit(aux[right])){
                right--;
            }

            if(aux[left] != aux[right]){
                return false;
            }

            left++;
            right--;
        }
        return true;
    }
}
