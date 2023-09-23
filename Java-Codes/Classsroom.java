import java.util.*;
public class ClasssRoom{
    static class Stack{
        Deque<Integer> deque = new ArrayDeque<>();
        public void push(int data){
            deque.addLast(data);
        }
        public int pop(){
            return deque.removeLast();
        }
        public int peek(){
            return deque.getLast();
        }
    }
        static class Queue{
            Deque<Integer> deque = new ArrayDeque<>();
            public void push(int data){
                deque.addLast(data);
            }
            public int remove(){
                return deque.removeFirst();
            
        }
        public int peek(){
           return deque.getFirst();
        }
    }
    public static void main(String args[]){
        Queue q = new Queue();
      q.push(1);
      q.push(2);
      q.push(3);
      System.out.println("peek = " + q.peek());
      System.out.println(q.remove());
      System.out.println(q.remove());
      System.out.println(q.remove());
    }
}
