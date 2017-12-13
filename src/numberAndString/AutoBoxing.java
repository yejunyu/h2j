package numberAndString;

/**
 * 1. 对byte,short,float,double进行自动拆箱和自动装箱

 2. byte和Integer之间能否进行自动拆箱和自动装箱

 3. 通过Byte获取byte的最大值
 */

/**
 * @author yejunyu
 * @date 2017/12/12
 */
public class AutoBoxing {
    public static void main(String[] args) {
        // 1
        byte b1 = 1;
        Byte B1 = b1;
        Byte B2 = 1;
        byte b2 = B2;
        short s1 = 1;
        Short S1 = s1;
        Short S2 = 1;
        short s2 = S2;
        float f1 = 1F;
        Float F1 = f1;
        Float F2 = 1F;
        float f2 = F2;
        double d1 = 1D;
        Double D1 = d1;
        Double D2 = 1D;
        double d2 = D2;
        // 2
        // 试过了,报错
        // 3
        System.out.println(Byte.MAX_VALUE);
    }
}
