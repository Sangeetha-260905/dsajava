class Solution {
    public int totalNumbers(int[] digits) {
        int count=0;

        for(int num=100;num<=999;num++){
        if(num%2!=0){
            continue;
        }
         int a=num/100;
         int b=(num/10)%10;
         int c=num%10;

         int[] freq=new int[10];
        for(int d:digits){
            freq[d]++;
        }
        freq[a]--;
        freq[b]--;
        freq[c]--;

        if(freq[a]>=0 && freq[b]>=0 && freq[c]>=0){
            count++;
        }
        }
        return count;
    }
}