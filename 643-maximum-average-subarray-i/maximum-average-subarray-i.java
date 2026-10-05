class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int ws=0;
        for(int i=0;i<k;i++){
            ws+=nums[i];
        }
        int max=ws;
        for(int j=k;j<nums.length;j++){
            ws+=nums[j];
            ws-=nums[j-k];

            max=Math.max(max,ws);
        }
        return (double)max/k;
    }
}