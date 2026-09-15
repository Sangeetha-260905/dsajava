class Solution {
    public int maxPalindromes(String s, int k) {
        int n=s.length();
        boolean[][] isPalindrome=new boolean[n][n];
        for(int len=1;len<=n;len++){
            for(int left=0;left<=n-len;left++){
                int right=left+len-1;

                isPalindrome[left][right]=s.charAt(left)==s.charAt(right)&&(len<=2||isPalindrome[left+1][right-1]);
            }
        }
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            if(i>0){
                dp[i]=dp[i-1];
            }
            for(int j=0;j<i-k+2;j++){
                if(isPalindrome[j][i]){
                    int prev=(j>0)?dp[j-1]:0;
                    dp[i]=Math.max(dp[i],prev+1);
                }
            }
        }
        return dp[n-1];
    }
}