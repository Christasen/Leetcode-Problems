// example
// ()())()
// -> ()()() && (())()
// )( -> null;
// (a)())()
// thought on this problem
// first, only consider the case that left > right
// 1. find the nums of left first, if encounters right, left --
// 2. if found extra right parentheis, stop and remove all possible choice
// 3. which right parentheis to remove here? -> avoid repeatness
// 4. right case? right > left -> reverse string
we want to use dfs to search the whole string
and trying to identify different options and add it to result list
// this questions is asking about whether you can find matches between
// left and right paretheis
// there are several cases you should consider

// left > right  -> remove extra left
// right > left  -> remove extra right
// 时间复杂度O(2^n) 对于每个char来说 有remove它和保留它两种情况 一共有n个char
// 空间复杂度O(n) memorized stack worst case是每个char都需要remove
class Solution {
    // 1. we want to find the number of left paretheses
    // and right parethesis, if we found the number of right parethesis is
    // bigger than the left one, we do delete the right paretheses
    // 2. which one to delete?
    // 3. Avoid repeateness?
    // 4. if we have the case left paretheses > right paretheses?
    char [][] patterns = {{'(',')'}, {')', '('}};

    public List<String> removeInvalidParentheses(String s) {
        // edge cases?
        List<String> res = new ArrayList<>();
        dfs(res, s, patterns[0], 0, 0);
        return res;
    }

    private void dfs(List<String> res, String s, char[] pattern, int start, int lastRemove) {
        // scan and count
        int cnt = 0, n = s.length();
        for (int i = start; i < n; i++) {
            if (s.charAt(i) == pattern[0]) cnt++;
            if (s.charAt(i) == pattern[1]) cnt--;
            // delete things in here
            if(cnt < 0) {
                // delete the right one
                for (int j = lastRemove; j <= i; j++) {
                    // get the jth characater and started to scan
                    char c = s.charAt(j);
                    if (c == pattern[1] && (j == lastRemove || c != s.charAt(j-1))) {
                        // delete in here
                        dfs(res, s.substring(0, j) + s.substring(j + 1), pattern, i, j);
                    }
                    //  if i > 0 and A[i] == A[i - 1]: continue
                }
                // exit
                return;
            }
        }
        // mistakes here
        s = new StringBuilder(s).reverse().toString();
        // whether the right parethesis is smaller than the left parethesis;
        if (pattern == patterns[0]) {
            dfs(res, s, patterns[1], 0, 0);
        }
        else {
            res.add(s);
        }
    }
