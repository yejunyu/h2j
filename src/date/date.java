package date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.SimpleFormatter;

/**
 * @author yejunyu
 * @date 2017/12/14
 */
public class date {
    public static void main(String[] args) {
        /**
         * 借助随机数，创建一个从1995.1.1 00:00:00 到 1995.12.31 23:59:59 之间的随机日期
         */
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Random r = new Random();
        try {
            Long s = df.parse("1995.1.1 00:00:00 ").getTime();
            Long e = df.parse("1995.12.31 23:59:59").getTime();
            double t = Math.random()*(e-s)+s;
            System.out.println(df.format(t));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
