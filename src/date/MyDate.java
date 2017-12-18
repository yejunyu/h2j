package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Random;

/**
 * @author yejunyu
 * @date 2017/12/14
 */
public class MyDate {

    public static String[] randomDate(int length, String startDate, String endDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Random r = new Random();
        String[] myDates = new String[length];
        try {
            Long s = df.parse(startDate).getTime();
            Long e = df.parse(endDate).getTime();
            for (int i = 0; i < length; i++) {
                double t = Math.random() * (e - s) + s;
                myDates[i] = df.format(t);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return myDates;
    }

    public static void main(String[] args) {
        /**
         * 借助随机数，创建一个从1995.1.1 00:00:00 到 1995.12.31 23:59:59 之间的随机日期
         */
        String[] a = randomDate(1,"1995.1.1 00:00:00", "1995.12.31 23:59:59");
        System.out.println(Arrays.toString(a));
        /**
         * 准备一个长度是9的日期数组
         使用1970年-2000年之间的随机日期初始化该数组
         按照这些日期的时间进行升序排序
         比如 1988-1-21 12:33:22 就会排在 1978-4-21 19:07:23 前面，因为它的时间更小，虽然日期更大
         */
        int length = 9;
        String[] b = randomDate(length, "1970.1.1 00:00:00", "2000.12.31 23:59:59");
        System.out.println(Arrays.toString(b));
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Long e,d;
        String temp;
        try {
            for (int i = 0; i < length-1; i++) {
                for (int j = 0; j < length-1-i; j++) {
                    e = df.parse(b[j].substring(11)).getTime();
                    d = df.parse(b[j+1].substring(11)).getTime();
                    if (e > d){
                        temp = b[j];
                        b[j] = b[j+1];
                        b[j+1] = temp;
                    }
                }

            }
        }catch (ParseException e1){
            System.out.println(e1.getMessage());
        }
        System.out.println(Arrays.toString(b));
    }
}
