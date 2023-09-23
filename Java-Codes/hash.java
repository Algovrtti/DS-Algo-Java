import java.util.*;
public class hash{
    public static void main(String args[]){
        HashMap<String ,Integer> hm = new HashMap<>();
        hm.put("India",100);
        hm.put("China",150);
        hm.put("US",50);
        hm.put("Indonasia",6);
        hm.put("Nepal",5);
        
        //Iterate
        Set<String> keys = hm.keySet();
        System.out.println(keys);
        for (String k : keys){
            System.out.println("keys="+k+",values="+ hm.get(k));
        }
    }
}