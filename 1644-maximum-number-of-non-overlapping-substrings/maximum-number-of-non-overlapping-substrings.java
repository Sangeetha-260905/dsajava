class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] count=new int[26];
        int[] first_ind=new int[26];
        int[] last_ind=new int[26];

        Arrays.fill(first_ind,-1);
        Arrays.fill(last_ind,-1);

        List<Integer> list=new ArrayList<>();

        for(int i=0;i<s.length();i++){
            int c=s.charAt(i)-'a';

            if(count[c]==0){
                first_ind[c]=i;
                list.add(c);
            }
            count[c]++;
            last_ind[c]=i;
        }
        List<String> res=new ArrayList<>();
        Deque<int[]>queue=new ArrayDeque<>();

        for(int c:list){
            queue.addFirst(new int[]{
                first_ind[c],last_ind[c],count[c]
            });

            int l=Integer.MAX_VALUE;
            int r=Integer.MIN_VALUE;
            int total=0;

            for(int[] item:queue){
                total+=item[2];
                l=Math.min(l,item[0]);
                r=Math.max(r,item[1]);

                if(total==r-l+1){
                    break;
                }
            }
            if(total==r-l+1){
                res.add(s.substring(l,r+1));
                queue.clear();
            }
        }
        return res;
    }
}