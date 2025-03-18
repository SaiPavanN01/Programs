package LinkedListInterviewQuestions.src.main.java.io.pavan;

public class MergeSort {
    ListNode head;
    ListNode tail;
    public MergeSort merge(ListNode left, ListNode right){
        ListNode head1= left;
        ListNode head2= left;
        MergeSort ans = new MergeSort();
        while(head1 != null && head2 != null){
            if(head1.val<head2.val){
                ans.insert(head1.val);
                head1=head1.next;
            }else{
                ans.insert(head2.val);
                head2=head2.next;
            }
        }
        while(head1!=null){
            ans.insert(head1.val);
            head1=head1.next;
        }
        while(head2!=null){
            ans.insert(head2.val);
            head2=head2.next;
        }
        return ans;
    }
    public void insert(int value){
        ListNode newNode = new ListNode();
        tail.next=newNode;
        tail=newNode;
    }
    public class ListNode {
      private int val;
      private ListNode next;
      public ListNode() {

      }
      public ListNode(int val) {
          this.val = val;
      }
     public ListNode(int val, ListNode next) {
          this.val = val; this.next = next;
      }
    }
}
