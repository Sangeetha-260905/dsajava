class Solution {
    public boolean checkGoodInteger(int n) {
        int ds=0;
        int sqs=0;

        while(n>0){
            int d=n%10;
            ds=ds+d;
            sqs+=d*d;
            n=n/10;
        }
        return sqs-ds>=50;
    }
}