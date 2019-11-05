// // first, for this problem, we can think it this way
// given 123, 456, 789 -> we can actually separate this num into three groups
// every time, we only need handle three numbers
// by having this structure, we can 将大的计数单位分开，比如thousands， millions， billions
// 然后在每一个小组里，我们要判断当前的数字如何分开
// 小组情况： 有百位，有特殊数字（0 - 19）-> 以及有整数十位
// 所以我们会构建几个特殊的string 【】 去存一些数字对应的string
// o(1)
// o(1)
class Solution {
    // forgot some of the nums in here
    private final String[] SPECIAL = {"", "One", "Two", "Three", "Four", "Five","Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
     "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    // mistake here forgot to get ten
    private final String[] TENS = {"", "Ten","Twenty", "Thirty", "Forty", "Fifty",
    "Sixty", "Seventy", "Eighty", "Ninety"};
    // mistake here
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        // edge cases
        if (num == 0) {
            return "Zero";
        }
        String result = "";
        int i = 0;
        while(num > 0) {
            if(num % 1000 != 0) {
                // helpler function here
                // mistake here
                // mistake here, forgot to plus string
                result = helper(num % 1000) + THOUSANDS[i] + " " + result;
            }
            i++;
            num = num / 1000;
        }
        return result.trim();
    }

    private String helper(int n) {
        if(n == 0) {
            return "";
        }
        // n < 20
        else if (n < 20) {
            return SPECIAL[n] + " ";
        } else if (n < 100) {
            return TENS[n / 10] + " " + helper(n % 10);
        } else {
            // made a mistake here
            return SPECIAL[n / 100] + " " + "Hundred " + helper(n % 100);
        }
        // 20 < n < 100
        // 100 < n
    }
}
