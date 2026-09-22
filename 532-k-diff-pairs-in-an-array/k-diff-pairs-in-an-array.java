class Solution {
    public int findPairs(int[] nums, int k) {
        
        if(k<0){
            return 0;
        }

        Arrays.sort(nums);
        int left=0;
        int right=1;
        int c=0;

        while(right<nums.length){
            if(left==right){
                right++;
                continue;
            }
            int d=nums[right]-nums[left];

            if(d<k){
                right++;
            }
            else if(d>k){
                left++;
            }
            else{
               c++;

               int lv=nums[left];
               int rv=nums[right]; 

               while(left<nums.length&& nums[left]==lv){
                left++;
               }
               while(right<nums.length && nums[right]==rv){
                right++;
               }
            }
        }
        return c;
    }
}