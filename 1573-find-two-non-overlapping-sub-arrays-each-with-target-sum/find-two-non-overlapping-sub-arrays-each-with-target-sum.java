class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        int[] b=new int[n];

        Arrays.fill(b,Integer.MAX_VALUE);
        int l=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;

        for(int r=0;r<n;r++){
            sum+=arr[r];

            while(sum>target){
                sum-=arr[l];
                l++;
            }
            if(sum==target){
                int length=r-l+1;

                if(l>0 && b[l-1]!=Integer.MAX_VALUE){
                    ans=Math.min(ans,length+b[l-1]);
                }
                    b[r]=length;
            }
                if(r>0){
                    b[r]=Math.min(b[r],b[r-1]);
                }
                
            }
        
        return ans==Integer.MAX_VALUE ?-1:ans;
    }
}