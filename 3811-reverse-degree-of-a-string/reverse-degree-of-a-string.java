class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        for(int i=0;i<s.length();i++){
            int ind=s.charAt(i)-'a';
            int rev=26-ind;
            ans+=rev*(i+1);
        }
        return ans;
    }
}