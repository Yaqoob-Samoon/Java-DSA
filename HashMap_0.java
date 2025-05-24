import java.util.*;

public class HashMap_0 {
    public static void main(String[] args) {
        // create
        HashMap<String, Integer> hm = new HashMap<>();
        // Insert
        hm.put("India", 100);
        hm.put("US", 150);
        hm.put("China", 120);
        hm.put("Saudi Arabia", 220);
        // printing hashmap in unordered way not as jo first add howa wo first print ko
        // hoga or na hee alphatics way main
        System.out.println(hm);
        // Get operation TC O(1)
        int population = hm.get("India");
        System.out.println(population);
        // now if we get key that doesn't exist in our hasmap will print null

        System.out.println(hm.get("Pakistan"));
        // Contains Key will check key hai ya nahii get direct value check kerny jata ha
        System.out.println(hm.containsKey("India"));// print true
        System.out.println(hm.containsKey("Pakistan")); // print false value does not exist

        //Remove
       System.out.println(hm.remove("China")); // this will retun popultion of china and completely deleted
        System.out.println(hm); // china deleted

        //Iterate Hasmap
        // entrykey()is function that iterate directly both key and values
        Set<String> key = hm.keySet();
       
        System.out.println(key);
        // iteration
        for (String k : key) {
            System.out.println("key="+k+",value="+hm.get(k));
        }


    }
}
