/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        
        
        int fsindex=-1;
        int lsindex=-1;
        int mindis=Integer.MAX_VALUE;
        int preVal=head.val;
        ListNode curr=head.next;
        int ind=1;
        while(curr.next!=null){

            int currVal=curr.val;
            int nextVal=curr.next.val;
            if((currVal>preVal && currVal>nextVal)||
            (currVal<preVal && currVal<nextVal)){


                if(fsindex==-1){
                    fsindex=ind;
                }
                else{
                    mindis=Math.min(mindis,ind-lsindex);
                }
                lsindex=ind;
            }
            preVal=currVal;
            curr=curr.next;
            ind++;
        }
        
        if(fsindex==-1||fsindex==lsindex){
            return new int[]{-1,-1};
        }
        
        return new int[]{mindis,lsindex-fsindex};
    }
}