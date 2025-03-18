package LinkedListInterviewQuestions.src.main.java.io.pavan;

public class LL {
    private Node head;
    private Node tail;
    private int size;
    public LL() {
        this.size = 0;
    }
    public void insertFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        if (tail == null) {
            tail = head;
        }
        size += 1;
    }
    public void insertLast(int val) {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

    public void bubbleSort() {
        bubbleSort(size - 1, 0);
    }
    public void bubbleSort(int row,int col){
        if(row==0)
            return;
        if(col<row){
            Node first = get(col);
            Node second = get(col+1);
            if(first.val > second.val){
                // swap
                if(first==head){
                    head=second;
                    first.next=second.next;
                    head.next=first;
                }
                else if(second==tail){
                    Node prev = get(col - 1);
                    prev.next=second;
                    tail=first;
                    tail.next=null;
                    second.next=tail;
                }else{
                    Node prev = get(col - 1);
                    prev.next=second;
                    first.next=second.next;
                    second.next=first;
                }

            }
            bubbleSort(row, col + 1);
        }else{
            bubbleSort(row-1, 0);
        }

    }
    public Node get(int index) {
        Node node = head;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    public class Node{
        private int val;
        private Node next;

        public Node(int val) {
            this.val=val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }
    //recursion reverse
    public void reverseRec(Node node){
        if(node==tail){
            head = tail;
            return;
        }
        reverseRec(node.next);
        tail.next=node;
        tail=node;
        tail.next=null;
    }
    //https://leetcode.com/problems/reverse-linked-list/
    public void recursionIt(){
        if(size<2)
            return;
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
        head=prev;
    }
// https://leetcode.com/problems/reverse-linked-list-ii/
    public Node reverseBetween(Node head, int left, int right) {
        if(left ==right)
            return head;
        Node current = head;
        Node prev=null;

        for (int i = 0; current!=null &&  i < left - 1; i++) {
            prev=current;
            current = current.next;
        }

        Node last = prev;
        Node newNode = current;
        Node next= current.next;
        for (int i = 0; current!=null && i < right - left + 1; i++) {
            while(current!=null){
                current.next=prev;
                prev=current;
                current=next;
                if(next!=null)
                    next= next.next;
            }
        }
        if(last!=null){
            last.next=prev;
        }else{
            head=prev;
        }
        newNode.next=current;
        return head;
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
//    https://leetcode.com/problems/palindrome-linked-list/
    public boolean isPalindrome(Node head) {
        Node mid = middle(head);
        Node headSecond = reverseList(mid);
        Node rereverseHead = headSecond;

        // compare both the halves
        while (head != null && headSecond != null) {
            if (head.val != headSecond.val) {
                break;
            }
            head = head.next;
            headSecond = headSecond.next;
        }
        reverseList(rereverseHead);

        return head == null || headSecond == null;
    }
    public void reorderList(Node head) {
        Node mid = middle(head);
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
    public Node reverseList(Node head){
        Node prev = null;
        Node current = head;
        Node next = current.next;
        while(current != null){
            current.next = prev;
            prev = current;
            current = next;
            if(next != null)
                next = next.next;
        }
        head=prev;
        return head;
    }
// https://leetcode.com/problems/rotate-list/
    public Node rotateRight(Node head, int k) {
        if (k <= 0 || head == null || head.next == null) {
            return head;
        }
        Node last = head;
        int length = 1;
        while (last.next != null) {
            last = last.next;
            length++;
        }
        last.next = head;
        int rotations = k % length;
        int skip = length - rotations;
        Node newLast = head;
        for (int i = 0; i < skip - 1; i++) {
            newLast = newLast.next;
        }
        head = newLast.next;
        newLast.next = null;

        return head;
    }

// https://leetcode.com/problems/reverse-nodes-in-k-group/
    public Node reverseKGroup(Node head, int k) {
        if (k <= 1 || head == null) {
            return head;
        }

        Node current = head;
        Node prev = null;

        int length = getLength(head);
        int count = length / k;
        while (count > 0) {
            Node last = prev;
            Node newEnd = current;

            Node next = current.next;
            for (int i = 0; current != null && i < k; i++) {
                current.next = prev;
                prev = current;
                current = next;
                if (next != null) {
                    next = next.next;
                }
            }

            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }

            newEnd.next = current;

            prev = newEnd;
            count--;
        }
        return head;
    }
    public int getLength(Node head){
        Node current = head;
        int length=1;
        while(current.next != null){
            length++;
            current = current.next;
        }
        return length;
    }
    public static void main(String[] args) {
        LL list = new LL();
        for (int i = 7; i > 0 ; i--) {
            list.insertLast(i);
        }
        list.display();
        list.bubbleSort();
        list.display();
    }
}
