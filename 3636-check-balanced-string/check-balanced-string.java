class Solution {
    public boolean isBalanced(String num) {
        int even=0;
        int odd=0;

        for(int i=0;i<num.length();i++){
            int d=num.charAt(i)-'0';
            
            if(i%2==0)
                even+=d;            
        else
        odd+=d;
    }
    return even==odd;
}
}