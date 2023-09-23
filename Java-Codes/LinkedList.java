public class LinkedList{
    public class Node {
        int data;
        Node next;
        public Node (int data){
           
            this.data = data;
            this.next = null;
        }
    }
     public static Node head;
     public static Node tail;
     public static int size;
     public void addFirst(int data){
         // step 1 = create new node
         Node newNode = new Node(data);
         size++;
          if(head == null){
            head = tail = newNode;
            return;
          }
          // step2 - newNode Next = head
            newNode.next = head;
         // step3 - head = newNode
            head = newNode;
        }
        public void addlast(int data){
            Node newNode = new Node(data);
            size++;
            if( head == null){
             head = tail = newNode;
            return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public void print(){
            if(head == null){
                System.out.println("LL is empty");
                return;
            }
            Node temp = head;
            while(temp != null){
                System.out.print(temp.data+ "->");
                temp = temp.next;
            }
            System.out.println("null");
        }
        public void add(int idx , int data){
            if(idx == 0){
                addFirst(data);
                return;
            }
            Node newNode = new Node(data);
            size++;
            Node temp = head;
            int i = 0;

            while(i < idx-1){
                temp = temp.next;
                i++;
            }
            // idx = idx-1; temp -> prev
            newNode.next = temp.next;
            temp.next = newNode;
        }
        public int RemoveFirst() {
            if(size == 0) {
                System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            } else if(size == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            int val = head.data;
            head = head.next;
            size--;
            return val;
        }
        public int RemoveLast(){
            if(size == 0){
                 System.out.println("LL is empty");
                return Integer.MIN_VALUE;
            } else if(size == 1){
                int val = head.data;
                head = tail = null;
                size = 0;
                return val;
            }
            //  prev : i = size-2
            Node prev = head;
            for(int i = 0; i < size-2; i++){
                prev = prev.next;
            }
            int val = prev.next.data; // tail data
            prev.next = tail;
            tail = prev;
            size--;
            return val;
        }
        public int itrsearch(int key){
            Node temp = head;
            int i =0;

            while(temp != null){
                if(temp.data == key){ // key found
                    return i;
                }
                temp = temp.next;
                i++;
            }
            // key not found;
            return -1;
        }
        public int helper(Node head, int key){
            if(head == null){
                return -1;
            }
            if(head.data == key){
                return 0;
            }
            int idx = helper(head.next ,key);
            if(idx == -1){
                return -1;
            }
            return idx+1;
        }
        public int recSearch(int key){
            return helper(head,key);
        }
        public void reverse() {
            Node prev = null;
            Node curr = tail = head;
            Node next;

            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            head = prev;
        }
        public void deleteNthfromEnd(int n){
            //  calculate size
            int sz = 0;
            Node temp = head;
            while(temp != null){
                temp = temp.next;
                sz++;
            }
            if(n == sz){
                head = head.next;
                return;
            }
            //  sz-n
            int i = 1;
            int iToFind =sz-n;
            Node prev = head;
            while(i < iToFind){
                prev = prev.next;
                i++;
            }
            prev.next = prev.next.next;
            return;
        }
        // slow fast approch
        public Node findmid(Node head){
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;//+1
                fast = fast.next.next;//+2
            }
            return slow;//slow is my  mid node
        } 
        public boolean checkpalindrome(){
            if(head == null || head.next == null){
                return true;
            }
            // step 1 - find mid
            Node midNode = findmid(head);
            // step 2 - reverse second half
            Node prev = null;
            Node curr = midNode;
            Node next;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node right = prev;// right half head
            Node left = head;
            // check left half and right half
            while(right != null){
                if(left.data != right.data){
                    return false;
                }
                left = left.next;
                right = right.next;
            }
            return true;
        }
        public static boolean iscycle(){
            Node slow = head;
            Node fast = head;
            while(fast != null && fast.next != null){
                slow = slow.next;//+1
                head = head.next.next;//+2
                if(slow == fast){
                    return true; //cycle exist
                }
            }
            return false; //cycle dosen't exist
        }
        public static void removecycle(){
            //  remove cycle
            Node slow = head;
            Node fast = head;
            boolean cycle = false;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
                if(fast == slow){
                    cycle = true;
                    break;
                }
            }
            if(cycle = false){
                return;
            }
            //  find meeting point
            slow = head;
            Node prev = null; //last Node
            while(slow != fast){
                prev = fast;
                slow = slow.next;
                fast = fast.next;
            }
            //  remove cylce-> last Node = null
            prev.next = null;
        }
        private Node getmid(Node head){
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow; // mid Node
        }
        private Node merge(Node head1 , Node head2){
            Node mergedLL = new Node(-1);
            Node temp = mergedLL;
            while(head1 != null && head2 != null){
                if(head1.data <= head2.data){
                    temp.next = head1;
                    head1 = head1.next;
                    temp = temp.next;
                } else{
                    temp.next = head2;
                    head2 = head2.next;
                    temp = temp.next;
                }
            }
            while(head1 != null){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            while(head2 != null){
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
            return mergedLL.next;
        }
        public Node mergesort(Node head){
            if(head == null || head.next == null){
                return head;
            }
            // find mid
            Node mid = getmid(head);
            // left & right MS
            Node righthead = mid.next;
            mid.next = null;
            Node newleft = mergesort(head);
            Node newright = mergesort(righthead);
            // merge
            return merge(newleft , newright);
        }
        public void zigzag(){
            // find mid
            Node slow = head;
            Node fast = head.next;
            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }
            Node mid = slow;
            // reverse 2nd half
            Node curr = mid.next;
            mid.next = null;
            Node prev = null;
            Node next;
            while(curr != null){
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
            }
            Node left = head;
            Node right = prev;
            Node nextL, nextR;
            // alt merge - zig-zag merge
            while(left != null && right != null){
                nextL = left.next;
                left.next = right;
                nextR = right.next;
                right.next = nextL;

                left = nextL;
                right = nextR;
            }
        }
        public static void main(String args[]){
            LinkedList LL = new LinkedList();
            LL.addlast(1);
            LL.addlast(2);
            LL.addlast(3);
            LL.addlast(4);
            LL.addlast(5);
            // 5->4->3->2->1->null
            LL.print();
            LL.zigzag();
            LL.print();
        }

}
    
