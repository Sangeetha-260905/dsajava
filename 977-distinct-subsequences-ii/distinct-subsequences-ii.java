class Solution {
    public int distinctSubseqII(String s) {
        int MOD=1_000_000_007;
        int n=s.length();

        long[] dp=new long[n+1];
        int[] last=new int[26];
        dp[0]=1;
        Arrays.fill(last,-1);
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int index=ch-'a';
            dp[i+1]=(dp[i]*2)%MOD;
            if(last[index]!=-1){
                dp[i+1]=(dp[i+1]-dp[last[index]]+MOD)%MOD;
            }
            last[index]=i;
        }
        return (int)((dp[n]-1+MOD)%MOD);
    }
}