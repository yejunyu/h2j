package date;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author yejunyu
 * @date 2017/12/18.
 */
public class MyCalendar {
    public static void main(String[] args) {
        /**
         * 找出下个月的倒数第3天是哪天
         */
        Calendar c = Calendar.getInstance();
        Date now = c.getTime();
        System.out.println();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        System.out.println("今天是"+df.format(now));
        c.setTime(now);
        c.add(Calendar.MONTH,2);
        c.set(Calendar.DATE,-3);
        Date nextTime = c.getTime();
        System.out.println("下月倒数第三天是:"+df.format(nextTime));
    }
}
