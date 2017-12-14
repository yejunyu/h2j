package numberAndString;

import java.util.Arrays;

/**
 * @author yejunyu
 * @data 2017/12/14
 */
public class str2 {
    public static void test1(String[] strArr){
        for (int i = 0; i < strArr.length-1; i++) {
            for (int j = i+1; j < strArr.length; j++) {
                if (strArr[i].equalsIgnoreCase(strArr[j])){
                    System.out.println(strArr[j]);
                }
            }
        }
    }
    public static void main(String[] args) {
        /**
         * 创建一个长度是100的字符串数组
         使用长度是2的随机字符填充该字符串数组
         统计这个字符串数组里重复的字符串有多少种
         */
        String[] strArr = new String[100];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = Str.randomStr1(2);
        }
//        String[] strArr = {"ab","Ab","aB","ss","SS","qq","QQ","eq","qe","1a"};
        System.out.println(Arrays.toString(strArr));
        test1(strArr);
    }
}
