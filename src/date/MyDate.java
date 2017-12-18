package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.logging.SimpleFormatter;

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
        String[] b = randomDate(9, "1970.1.1 00:00:00", "2000.12.31 23:59:59");
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Long e;
        Long[] es = new Long[9];
        for (int i = 0; i < 9; i++) {
            try {
                e = df.parse(b[i].substring(9)).getTime();
                es[i] = e;
            } catch (ParseException e1) {
                e1.printStackTrace();
            }
        }
    }
}
