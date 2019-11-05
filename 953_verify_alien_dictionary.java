class Solution {
    // set the map as a global variable
    Map<Character, Integer> map = new HashMap<>();
    public boolean isAlienSorted(String[] words, String order) {
        // edge cases
        if (words == null || order == null) {
            return true;
        }
        // first of all, we want to use some data structures to store
        // the character and its order, we should think about hashmap
        // and the space complexity for hashmap would be o(1) since there
        // are only 26 characters in total
        // syntax of hashmap, the pair you wanna store for it

        // traversal the order
        for (int i = 0; i < order.length(); i++) {
            map.put(order.charAt(i), i);
        }

        // now we want to compare the words within the words array one by one
        // here we may think about construct a new helper function to solve
        // this sub-problem
        for (int i = 1; i < words.length; i++) {
            if (helper(words[i-1], words[i]) == false) {
                return false;
            }
        }
        return true;
    }

    private boolean helper(String a, String b) {
        for (int i = 0; i < a.length(); i++) {
            // if the length of the string a smaller than
            // the length of the string b
            // we return false
            // apple, app
            // here it has to be small or equal to
            if (i >= b.length()) {
                return false;
            }
            // character at i in a is bigger than i in b
            else if (map.get(a.charAt(i)) > map.get(b.charAt(i))) {
                return false;
            }
            // the equal case
            else if (map.get(a.charAt(i)) == map.get(b.charAt(i))) {
                continue;
            }
            else {
                return true;
            }
        }
            return true;

    }
}
