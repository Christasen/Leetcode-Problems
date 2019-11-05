// input int array -> [1, 2, 3, 4]
// an int = largest cut element
// identify the largest piece you can cut for wood



class Solution {
// for this question, we know that we want to find the largest element
// within a list, my intuition would be use binary search

// step: come to a initial guess -> give a cut length and to see whether
// it is valid for all elements with this cut, save this num and to do another
// search
// O(logn) binary search
// O(1) space

  public int WoodCut(int[] Woods, int k) {
    // edge cases
    if (Woods == null || Woods.length == 0 || k == 0) return 0;
    int left = 1;
    int right = Integer.MAX_VALUE;
    int res = 0;
    if (!isValidCut(Woods, left, k)) {
      return 0;
    }

    // binary search
    while(left < right) {
      int mid = left + (right - left)/2;
      boolean valid = isValid(Woods, mid, k);
      if (valid == true) {
        // update the result and right bound
        res = mid;
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return res;

  }
  // hepler function to see whether it is a valid cut or not
  // condition: available cuts more or equal to k
  private boolean isValidCut(int[] Woods, int cutLen, int k) {
    int count = 0;
    for(ints c: Woods) {
      count += c / cutLen;
    }
    return count >= k;
  }


}
