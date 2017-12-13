package numberAndString;

/**
 * @author yejunyu
 * @date 2017/12/13
 */
public class PrimeNumber {
    public static void main(String[] args) {
        // 求1000000以内的质数
        int n = 0;
        for (int i = 2; i < 1000*1000; i++) {
            int flag = 0;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0){
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                n++;
                System.out.print(i+"是质数!\n");
            }
        }
        System.out.println("n 有"+n+"个!");
    }
}
