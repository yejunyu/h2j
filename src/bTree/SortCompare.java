package bTree;

import java.util.Arrays;
import java.util.List;

/**
 * @author yejunyu
 * @date 17-12-28.
 */
public class SortCompare {
    public static void main(String[] args) {
        /**
         * 创建4万个随机数，然后用分别用冒泡法，选择法，二叉树3种排序算法进行排序，比较哪种更快
         */
        int total = 10000;
        System.out.println("初始化一个长度为"+total+"的随机数组");
        int[] originalNumbers = new int[total];
        for (int i = 0; i < total; i++) {
            originalNumbers[i] = (int)(Math.random()*total);
        }
        System.out.println("初始化完毕");
        System.out.println(Arrays.toString(originalNumbers));
        // 复制原有数组
        int[] use4sort;

        use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersBySelection = performance(new SelectionSort(use4sort), "简单排序法");

        use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByBubbling = performance(new BubblingSort(use4sort), "冒泡排序法");

        use4sort = Arrays.copyOf(originalNumbers, originalNumbers.length);
        int[] sortedNumbersByTree = performance(new TreeSort(use4sort), "二叉树排序法");

        System.out.println(Arrays.toString(sortedNumbersByTree));

        System.out.println(Arrays.equals(sortedNumbersByBubbling, sortedNumbersBySelection));

        System.out.println(Arrays.equals(sortedNumbersByBubbling, sortedNumbersByTree));
    }

    interface sort{
        void sort();
        int[] values();
    }

    static class SelectionSort implements sort{
        int[] num;

        public SelectionSort(int[] num) {
            this.num = num;
        }

        @Override
        public void sort() {
            for (int i = 0; i < num.length - 1; i++) {
                for (int j = i+1; j < num.length; j++) {
                    if (num[i] > num[j]) {
                        int temp = num[i];
                        num[i] = num[j];
                        num[j] = temp;
                    }
                }
            }
        }

        @Override
        public int[] values() {
            return num;
        }
    }

    static class BubblingSort implements sort{
        int[] num;

        public BubblingSort(int[] num) {
            this.num = num;
        }

        @Override
        public void sort() {
            for (int i = 0; i < num.length; i++) {
                for (int j = 0; j < num.length -i -1; j++) {
                    if (num[j] > num[j+1]) {
                        int temp = num[j];
                        num[j] = num[j+1];
                        num[j+1] = temp;
                    }
                }
            }
        }

        @Override
        public int[] values() {
            return num;
        }
    }

    static class TreeSort implements sort{
        Node root;

        int[] num;

        public TreeSort(int[] num) {
            root = new Node();
            this.num = num;
        }

        @Override
        public void sort() {
            for (int i : num) {
                root.add(i);
            }
        }

//        @Override
//        public int[] values() {
//        	int[] values = new int[root.values().size()];
//        	for (int i = 0; i < values.length; i++) {
//        		values[i] = Integer.valueOf(root.values().get(i).toString());
//			}
//            return values;
//        }

        @Override
        public int[] values() {
            List<Object> list = root.values();
            int sortedNumbers[] = new int[list.size()];
            for (int i = 0; i < sortedNumbers.length; i++) {
                sortedNumbers[i] = Integer.parseInt(list.get(i).toString());
            }
            return sortedNumbers;
        }
    }

    private static int[] performance(sort algorithm, String type){
        long start = System.currentTimeMillis();
        algorithm.sort();
        long end1 = System.currentTimeMillis();
        System.out.printf("%s排序,排序耗时 %d %n", type, end1-start);
        int[] sortedNumbers = algorithm.values();
        long end = System.currentTimeMillis();
        System.out.printf("%s,查询遍历耗时 %d %n", type, end-end1);
        return sortedNumbers;
    }
}
