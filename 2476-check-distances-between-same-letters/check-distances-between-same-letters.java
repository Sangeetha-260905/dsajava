class Solution {
    public boolean checkDistances(String s, int[] distance) {
        
        for(int i=0;i<s.length();i++){

            int f=s.indexOf(s.charAt(i));
            int l=s.lastIndexOf(s.charAt(i));

            if(l-f-1!=distance[s.charAt(i)-'a']){
                return false;
            }
        }
        return true;
    }
}