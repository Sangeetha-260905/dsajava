class Solution {
    public int minimumDeletions(int[] nums) {
        
        int n=nums.length;
        int minIndex=0;
        int min=nums[0];
        int maxIndex=0;
        int max=nums[0];

        for(int i=1;i<n;i++){

            if(nums[i]<min){
                minIndex=i;
                min=nums[i];
            }
            if(nums[i]>max){
                maxIndex=i;
                max=nums[i];
            }
        }
        int a=n;
        int left=minIndex<= maxIndex ?minIndex:maxIndex;
        int right=minIndex <=maxIndex?maxIndex:minIndex;

        a=Math.min(a,right+1);
        a=Math.min(a,n-left);
        a=Math.min(a,left+1+n-right);
        return a;
    }
}