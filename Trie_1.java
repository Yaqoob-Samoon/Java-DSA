public class Trie_1 {
     static class Node { 
        Node children[] = new Node[26];
        boolean eow = false;
        int freq ;
        public Node(){
            for (int i = 0; i < children.length; i++) {
                children[i] = null;
            }
            freq = 1;
        }
     }

     public static Node root = new Node();
     //insert method 
     public static void insert(String words) {
        Node curr = root;
        for (int i = 0; i < words.length(); i++) {
            int idx = words.charAt(i) - 'a'; 
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            } else { 
              curr.children[idx].freq++;
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
     }
     public static void findPrefix(Node root, String ans) { // O(L) longest word
        if (root == null) {
            return;
        }
        if (root.freq == 1) {
            System.out.println(ans);
            return;
        }
        for (int i = 0; i < root.children.length; i++) {
            if (root.children[i] != null) {
                findPrefix(root.children[i], ans+(char)(i+'a'));
            }
        }
     }

     public static boolean startWith(String prefix) { //O(L)
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i)- 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
     }
    public static void main(String[] args) {
        String arr[] = {"zebra" , "dog" , "duck" , "dove"};
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
        root.freq = -1;
        findPrefix(root, "");
        // this is checking starting prefix of word that are in arr 
       System.out.println(startWith("zeb"));
        
    }
}
