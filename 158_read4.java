/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf);
 */
// O(n)
// O(1)
// 要保证从上一次读到的位置往下继续读
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    private int temp_index = 0;
    private int len = 0;
    private char[] temp = new char[4];

    public int read(char[] buf, int n) {
        int buf_index = 0;
        while (buf_index < n) {
            // get the length of the temp size
            // 上次留下的已经读完了
            if (temp_index == 0) {
                 len = read4(temp);
            }
            // if there is nothing to read, stop
            if(len == 0) break;
            // if there are something to read
            // 将tmp_buf里面的东西放进buf
            while (buf_index < n && temp_index < len) {
                buf[buf_index] = temp[temp_index];
                buf_index++;
                temp_index++;
            }
            // 所读数量超过4， 将temp set 为0
            if (temp_index >= len) temp_index = 0;
        }
        return buf_index;
    }
}
