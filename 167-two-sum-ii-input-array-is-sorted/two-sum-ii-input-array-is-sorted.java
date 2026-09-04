class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int left=0;
        int right=numbers.length-1;

        while(left<right){

            int csum=numbers[left]+numbers[right];
            if(csum==target){
                return new int[]{left+1,right+1};
            }
            else if(csum>target){
                right--;
            }
            else if(csum<target){
              left++;
            }
        }
        return null;
    }
}