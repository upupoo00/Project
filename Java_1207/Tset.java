package Java_1207;

import java.util.Arrays;

public class Tset {
    public int[] twoSum(int[] nums, int target){
        for (int i = 0; i <nums.length ; i++) {
            for (int j =i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }
    public int majorityElement(int[] nums) {
        if(nums==null||nums.length<=0){
            return -1;
        }
        Arrays.sort(nums);
        int middle =nums[nums.length/2];
        int left = 0;
        int right = nums.length-1;
        while(left<=right&&(nums[left]!=middle||nums[right]!=middle)){
            if(nums[left]!=middle){
                left++;
            }
            if(nums[right]!=middle){
                right--;
            }
        }
        return right-left+1>nums.length/2?middle:-1;
    }
}
