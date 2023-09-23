import java.util.*;
public class HashMapCode{
    static class HashMap<K,V> { // generic can be boolen, int,string , etc
    private class Node{
        K key;
        V value;
        public Node(K key ,V value){
            this.key = key;
            this.value = value;
        }
    }
        Private int n; //n
        Private int N;
        Private LinkedList<Node> buckets[]; // N = buckets.length

        @SupperessWarnings("unchecked")
        Public HashMap(){
           
                this.N= 4;
                this.buckets = new LinkedList[4];
                for(int i = 0 ; i <= 4 ;i++){
                    this.buckets[i] =new LinkedList<>();
                
        }
        }
        private int HashFunction(K key){
            int hc = key.hashcode();
            return Math.abs(hc) % N;
        }
        private int SearchInLL(K key , int bi){
            LinkedList<Node> ll = buckets[bi];
            int di = 0;

            for(int i = 0; i < ll.size(); i++){
                Node node = ll.get(i);
                if(node.key == key){
                    return di;
                }
                di++;
            }
            return -1;
        }
        private void rehash(){
            LinkedList<Node> oldBuck[] = buckets;
            buckets = new LikedList[N*2];
            N = 2*N;
            for(int i = 0; i <buckets.length ;i++){
                buckets[i] = new LinkedList<>();
            }

            //nodes -> add in bucket
            for(int i = 0; i < buckets.length ; i++){
                LinkedList<Node> ll = oldbuck[i];
                for(int j = 0; j < ll.size(); j++){
                    Node node = ll.remove();
                    put(Node.key ,node.value);
                }
            }
        }
        public void put(K key , V value){ // O(lambda)
            int bi = hashFunction(key);
            int di = SearchInll(key,bi);

            if(di != -1){
                Node node = buckets[bi].get(di);
                node.value = value;
            } else{
                buckets[bi].add(new Node(key , value));
                n++;
            }
            double lambda = (double)n/N;
            if(lambda > 2.0){
                rehash();
            }
        }
        public boolean ContainsKey(K key){
            int bi = hashFunction(key);
            int di = SearchInll(key,bi);

            if(di != -1){
                return true;
            } else{
                return false;
            }
        }
        public V remove(K key){ //O(1)
            int bi = hashFunction(key);
            int di = SearchInll(key,bi);

            if(di != -1){
                Node node = buckets[bi].remove(di);
                return node.value;
            } else{
                return null;
            }
        }
        public V get(K key){ //O(1)
            int bi = hashFunction(key);
            int di = SearchInll(key,bi);

            if(di != -1){
                Node node = buckets[bi].get(di);
                return node.value;
            } else{
                return null;
            }
        }
        public ArrayList<K> keyset(){
            ArrayList<K> keys = new ArrayList<>();

            for(int i = 0; i < buckets.length; i++) {
                LinkedList<Node> ll = buckets[i];
                for(Node node : ll) {
                    keys.add(node.key);
                }
            }
            return keys;
        }
        public boolean isEmpty(){
            return n == 0;
        }
    }
        public static void main(String args[]){
            HashMap<String,Integer> hm = new HashMap<>();
            hm.put("India", 100);
            hm.put("China", 150);
            hm.put("US", 50);
            hm.put("Nepal", 5);

            ArrayList<String> keys = hm.keySet();
            for(String key : keys){
                System.out.println(key);
            }
               
        }
    }

