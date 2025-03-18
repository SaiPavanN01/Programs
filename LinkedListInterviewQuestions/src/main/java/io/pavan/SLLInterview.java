package LinkedListInterviewQuestions.src.main.java.io.pavan;

public class SLLInterview {
    static Node head;
    Node tail;
    int size;
    public SLLInterview() {
        this.size=0;
    }

    public void insertFirst(int value){
        Node newNode = new Node(value);
        newNode.next=head;
        head=newNode;
        if(tail==null){
            tail=head;
        }
        size++;
    }
    public void insertAtPosition(int value, int index){
        if(index==0){
            insertFirst(value);
            return;
        }
        if(index==size-1){
            insert(value);
            return;
        }
        if(index>size+1){
            System.out.println("Please reenter the index between 0 and "+size);
            return;
        }
        Node temp = head;
        for (int i = 1; i < index; i++) {
            temp=temp.next;
        }
        Node newNode= new Node(value, temp.next);
        temp.next=newNode;

        size++;
    }
    public int deleteFirst(){
        Node temp = head;
        int value = head.val;
        head = temp.next;
        size--;
        return value;
    }
    public int deleteLast(){
        if(size<=1)
            return deleteFirst();

        Node secondLast = get(size-2);
        int value = tail.val;
        tail= secondLast;
        tail.next= null;
        size--;
        return value;
    }
    public int deleteAtPos(int index){
        if(index==0)
            return deleteFirst();
        if(index==size-1)
            return deleteLast();
        Node prev = get(index-1);
        int value = prev.next.val;

        prev.next= prev.next.next;
        size--;
        return value;
    }
    public Node get(int index){
        Node node = head;
        for(int i =0; i<index; i++){
            node=node.next;
        }
        return node;
    }
    public Node find(int value){
        Node node = head;
        while(node!=null){
            if(node.val == value){
                return node;
            }
            node=node.next;
        }
        return null;
    }
    public void display(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.println("END");

    }
    public void insert(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node newNode = new Node(value);
        tail.next=newNode;
        tail=newNode;
        size++;
    }
    public void insertRec(int val, int index) {
        head = insertRec(val, index, head);
    }
    private Node insertRec(int val, int index, Node node) {
        if (index == 0) {
            Node temp = new Node(val, node);
            size++;
            return temp;
        }

        node.next = insertRec(val, index-1, node.next);
        return node;
    }
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/
    public Node deleteDuplicates(Node head) {
        Node current = head;
        while(current!=null && current.next!=null){
            if(current.val == current.next.val)
                current.next = current.next.next;
            else
                current=current.next;
        }
        return head;
    }
  // Merge two sorted list
  // https://leetcode.com/problems/merge-two-sorted-lists/
  public Node mergeTwoLists(Node list1, Node list2) {
      Node dummy = new Node();
      Node cur = dummy;

      while (list1 != null && list2 != null) {
          if (list1.val > list2.val) {
              cur.next = list2;
              list2 = list2.next;
          } else {
              cur.next = list1;
              list1 = list1.next;
          }
          cur = cur.next;
      }

      cur.next = (list1 != null) ? list1 : list2;

      return dummy.next;
  }
  // https://leetcode.com/problems/linked-list-cycle/submissions/1540145400/
  public boolean hasCycle(Node node){
        Node fast = node;
        Node slow = node;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
  }
  // Find the length of the linked list cycle
  public int cycleLength(Node head){
        Node slow= head;
        Node fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                Node temp = slow;
                int length=0;
                do{
                  temp = temp.next;
                  length++;
                } while(slow!=temp);
                return length;
            }
        }
        return 0;
  }
  // https://leetcode.com/problems/linked-list-cycle-ii/
    public Node detectCycle(Node head) {
        int length = 0;

        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                length = cycleLength(slow);
                break;
            }
        }

        if (length == 0) {
            return null;
        }

        // find the start node
        Node f = head;
        Node s = head;

        while (length > 0) {
            s = s.next;
            length--;
        }

        // keep moving both forward and they will meet at cycle start
        while (f != s) {
            f = f.next;
            s = s.next;
        }
        return s;
    }
    // https://leetcode.com/problems/happy-number/
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do{
            slow = findSquare(slow);
            fast = findSquare(findSquare(fast));
        }while(slow!=fast);
        if(slow == 1)
            return true;
        return false;
    }
    public int findSquare(int n){
        int ans =0;
        while(n>0){
            int rem = n%10;
            ans += rem*rem;
            n/=10;
        }
        return ans;
    }
    public Node middle(Node head){
        Node slow=head;
        Node fast=head;
        do{
            slow=slow.next;
            fast=fast.next.next;
        }while(slow!=fast);
        return slow;
    }
    public void reverse(Node node){
        if(node == tail){
            head = node;
            return;
        }
        reverse(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }
    // https://leetcode.com/problems/reverse-linked-list/
    public Node reverseList(Node head) {
        if(head == null){
            return null;
        }
        Node prev = null;
        Node present = head;
        Node next = present.next;
        while(present!=null){
            present.next=prev;
            prev=present;
            present=next;
            if(next!=null)
                next=next.next;
        }
        return prev;

    }
    // https://leetcode.com/problems/reverse-linked-list-ii/
    public Node reverseBetween(Node head, int left, int right) {
        if(left == right){
            return head;
        }
        Node prev = null;
        Node current = head;
        for(int i=0; i<left-1;i++){
            prev = current;
            current = current.next;
        }
        Node newEnd = current;
        Node last=prev;

        Node next = current.next;
        for(int i=0; i <(right-left+1);i++){
            current.next=prev;
            prev=current;
            current=next;
            if(next!=null)
                next = next.next;
        }
        if(last!=null)
            last.next=prev;
        else
            head=prev;

        newEnd.next=current;

        return head;
    }

    // https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(Node head) {
        Node mid = getMiddle(head);
        Node headSecond = reverseList(mid);
        Node reReverse = headSecond;
        while(head != null && headSecond != null){
            if(head.val != headSecond.val)
                break;
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(reReverse);
        return head == null || headSecond == null;
    }
    // https://leetcode.com/problems/reorder-list/
    public void reorderList(Node head) {
        Node mid = getMiddle(head);
        Node hS = reverseList(mid);
        Node hF = head;

        while(hF != null && hS != null){
            Node temp = hF.next;
            hF.next = hS;
            hF = temp;

            temp= hS.next;
            hS.next= hF;
            hS = temp;
        }
        // next of tail to null
        if (hF != null) {
            hF.next = null;
        }
    }
    // https://leetcode.com/problems/rotate-list/
    public Node rotateRight(Node head, int k) {
        if(k <= 0 || head == null || head.next == null){
            return head;
        }
        Node last = head;
        int length = 1;
        while(last.next != null){
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k%length;
        int skip = length - rotations;
        Node newLast=head;
        for(int i=0; i < skip-1;i++){
            newLast=newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }
    public Node getMiddle(Node head){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public class Node{
        int val;
        Node next;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
}