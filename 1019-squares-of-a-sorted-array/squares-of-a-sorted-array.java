class Solution {
    public int[] sortedSquares(int[] nums) {
        
        int[] res=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums[i]=nums[i]*nums[i];
        }
        int l=0;
        int r=nums.length-1;

        for(int p=nums.length-1;p>=0;p--){
            if(nums[l]>nums[r]){
               res[p]=nums[l];
               l++;
            }
            else{
                res[p]=nums[r];
                r--;
            }
        }
        return res;
    }
}