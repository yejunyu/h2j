package CollectionsTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yejunyu
 * @date 17-12-28.
 */
public class Test1 {
    public static void main(String[] args) {
        /**
         * 首先初始化一个List,长度是10，值是0-9。
         然后不断的shuffle，直到前3位出现
         3 1 4
         shuffle 1000,000 次，统计出现的概率
         */
        List<Integer> list = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        int n = 0;
        for (int i = 0; i < 1000000; i++) {
            Collections.shuffle(list);
            if (list.get(0) == 3 && list.get(1) == 1 && list.get(2) == 4){
                n++;
            }
        }
        System.out.println(n);
    }
}
