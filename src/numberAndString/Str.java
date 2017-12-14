package numberAndString;

import java.util.Arrays;
import java.util.Random;

/**
 * @author yejunyu
 * @date 2017/12/13
 */
public class Str {
    /**
     * python怎么写
     * str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789"
     * def randomStr(length):
          str1 = ''
          for i in range(length):
              str1 += random.choice(str)
          return str1
     */
    public static String randomStr(int length){
        char[] cs = new char[length];
        short start = '0';
        short end = 'z'+1;
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            while (true){
                char c = (char) (r.nextInt(end-start) + start);
                if (Character.isLetter(c) || Character.isDigit(c)){
                    cs[i] = c;
                    break;
                }
            }
        }
        String result = new String(cs);
        return result;
    }
    public static void strSort(){
        String[] str = new String[8];
        for (int i = 0; i < 8; i++) {
            str[i] = randomStr(5);
        }
        System.out.println(Arrays.toString(str));
        // 冒泡排序法
        for (int i = 0; i < str.length; i++) {
            for (int j = i; j < str.length-1; j++) {
                String a = str[i].toLowerCase();
                String b = str[i+1].toLowerCase();
                short a1 = (short) a.charAt(0);
                short b1 = (short) b.charAt(0);
                if (a1>b1) {
                    String tmp = str[i];
                    str[i] = str[i+1];
                    str[i+1] = tmp;
                }
            }
        }
        System.out.println(Arrays.toString(str));
    }
    public static String randomStr1(int length){
        String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
        Random random = new Random();
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < length; i++) {
            buffer.append(str.charAt(random.nextInt(str.length())));
        }
        return  buffer.toString();
    }
    // 循环穷举
    public static void test1(String password){
        String str = "aAbBcCdDeEfFgGhHiIjJkKlLmMnNoOpPqQrRsStTuUvVwWxXyYzZ0123456789";
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < str.length(); k++) {
                    StringBuffer tryPassword = new StringBuffer();
                    n++;
                    tryPassword.append(str.charAt(i)).append(str.charAt(j)).append(str.charAt(k));
                    if (tryPassword.toString().equals(password)){
                        System.out.printf("试了%d次%n",n);
                    }
                }
            }
        }
    }
    // 递归穷举
    static int n = 0;
    public static void test2(String password){

    }
    public static void main(String[] args) {
        // 创建随机字符串(大小写字母和数字组成)
        System.out.println(randomStr(8));
        /**
         * 创建一个长度是8的字符串数组
         使用8个长度是5的随机字符串初始化这个数组
         对这个数组进行排序，按照每个字符串的首字母排序(无视大小写)
         */
        strSort();
        /**
         * 1. 生成一个长度是3的随机字符串，把这个字符串作为当做密码

         2. 使用穷举法生成长度是3个字符串，匹配上述生成的密码

         要求： 分别使用多层for循环 和 递归解决上述问题
         */
        String strPassword = randomStr1(3);
        test1(strPassword);
        test2(strPassword);
    }
}
