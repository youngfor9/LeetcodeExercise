package part0.hot;

import org.junit.Test;


/**
 * @Description: 长整数计算（https://leetcode.com/problems/add-strings/）
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * @Author: young
 * @Date: 2020/8/21 10:49
 **/
public class AddStrings {
    @Test
    public void init() {
        String s = addStrings("23232323", "232123232");
        System.out.println(s);
    }
    //答案借鉴：https://leetcode.com/problems/add-strings/discuss/90436/Straightforward-Java-8-main-lines-25ms
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

}
