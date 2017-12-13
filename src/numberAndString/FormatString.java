package numberAndString;

import java.util.Locale;

/**
 * @author yejunyu
 * @date 2017/12/13
 */
public class FormatString {
    public static void main(String[] args) {
        // 格式化字符串练习
        int year = 2020;
        //总长度，左对齐，补0，千位分隔符，小数点位数，本地化表达
        //直接打印数字
        System.out.printf("%d%n",year);
        //总长度是8,默认右对齐
        System.out.printf("%8d%n",year);
        //总长度是8,左对齐
        System.out.printf("%-8d%n",year);
        //总长度是8,不够补0
        System.out.printf("%08d%n",year);
        //千位分隔符
        System.out.printf("%,8d%n",year*1000);
        //小数点位数
        System.out.printf("%.3f%n",Math.PI);
        //不同国家的千位分隔符
        System.out.printf(Locale.UK,"%,.3f%n",Math.PI*1000);
        System.out.printf(Locale.CHINA,"%,.3f%n",Math.PI*1000);
        System.out.printf(Locale.FRANCE,"%,.3f%n",Math.PI*1000);
    }
}
