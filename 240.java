class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // check egde cases where matrix is null
        // or the first element in the matrix is null
        // check matrix null and the length

        if (matrix == null || matrix.length == 0) {
            return false;
        }

        if (matrix[0] == null || matrix[0].length == 0) {
            return false;
        }

        int rowNum = matrix.length;
        int colNum = matrix[0].length;
        if (rowNum == 0) {
            return false;
        }
        // initiate two temp variables to keep track of the
        // row index and column index
        // and this is the method which is from the bottom left
        // to the right top

        int x = rowNum - 1;
        int y = 0;
       // int count = 0;

        while(x >= 0 && y < colNum) {

            // first case
            // if the element is smaller than target
            if (matrix[x][y] < target) {
                y++;
            } else if (matrix[x][y] > target) {
                x--;
            } else {
                return true;
            }


        }


      return false;
    }
}
