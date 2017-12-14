package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author yejunyu
 * @date 2017/12/14
 */
public class MyLocalDate {
    public static void main(String[] args) {
        // 2017-10-24T10:51:44.511
        LocalDateTime now = LocalDateTime.now();
        //如果不想显示毫秒
        LocalTime nowTime = LocalTime.now().withNano(0); //14:43:14
        // 获取年月日时分秒
        int year = now.getYear();
        int month = now.getMonthValue();
        int day = now.getDayOfMonth();
        int hour = now.getHour();
        int minute = now.getMinute();
        int second = now.getSecond();
        // 2017-10-24T10:51:44.511
        LocalDateTime today = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        // 2017-10-24T11:09:02
        LocalDateTime specifiDate = LocalDateTime.of(year, month, day, hour, minute, second);
    }
}
