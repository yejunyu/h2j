package numberAndString;

import java.util.Arrays;

/**
 * @author yejunyu
 * @data 2017/12/14
 */
public class str1 {
    public static void test1(){
        String str = "let there  be  light";
        String[] strArr = str.split("\\s+");
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = strArr[i].substring(0,1).toUpperCase()+strArr[i].substring(1);
        }
        StringBuffer str1 = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            str1.append(strArr[i]).append(" ");
        }
        System.out.println(str1.toString().trim());
    }
    public static void test2(){
        String str = "peter piper picked a peck of pickled peppers";
        int n = 0;
        String[] strArr = str.split("\\s+");
        for (int i = 0; i < strArr.length; i++) {
            Character f = strArr[i].charAt(0);
            if (f.equals('p')||f.equals('P')){
                n++;
            }
        }
        System.out.println(n);
    }
    public static void test3(){
        String str = "lengendary";
        String[] strArr = str.split("");
        int n = 0;
        while (n<str.length()){
            strArr[n] = strArr[n].toUpperCase();
            n += 2;
        }
        StringBuffer str3 = new StringBuffer();
        for (int i = 0; i < strArr.length; i++) {
            str3.append(strArr[i]);
        }
        System.out.println(str3.toString());
    }
    public static void test4(){
        String str = "lengendary";
        char[] strArr = str.toCharArray();
        strArr[strArr.length-1] = Character.toUpperCase(strArr[strArr.length-1]);
        System.out.println(new String(strArr));
    }
    public static void test5(){
        String str = "Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak";
        char[] cs = str.toCharArray();
        int index = str.lastIndexOf("two");
        cs[index] = Character.toUpperCase(cs[index]);
        System.out.println(new String(cs));
    }
    public static void main(String[] args) {
        /**
         * 给出一句英文句子： "let there be light"
         得到一个新的字符串，每个单词的首字母都转换为大写
         */
        test1();
        /**
         * 英文绕口令
         peter piper picked a peck of pickled peppers
         统计这段绕口令有多少个以p开头的单词
         */
        test2();
        /**
         * 把 lengendary 改成间隔大写小写模式，即 LeNgEnDaRy
         */
        test3();
        /**
         * 把 lengendary 最后一个字母变大写
         */
        test4();
        /**
         * Nature has given us that two ears, two eyes, and but one tongue, to the end that we should hear and see more than we speak
         把最后一个two单词首字母大写
         */
        test5();
    }
}
