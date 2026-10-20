package module1;

public class Solution {
    public static int[] productExceptSelf(int[] nums){
        int n = nums.length;
        int[] answer = new int[n];

        int prefix = 1;
        for (int i=0; i<n; i++){
            answer[i] = prefix;
            prefix *= nums[i];
        }

        int suffix = 1;
        for (int i = nums.length-1; i>=0; i--){
            answer[i] *= suffix;
            suffix *= nums[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[] result = productExceptSelf(nums);

        for (int i=0; i< result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
