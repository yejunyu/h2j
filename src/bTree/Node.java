package bTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author yejunyu
 * @date 17-12-27.
 */
public class Node {

    public Node leftNode;

    public Node rightNode;

    public Object value;

    public void add(Object v) {
        if (null == value) {
            value = v;
        } else {
            if ((Integer) v <= (Integer) value) {
                if (null == leftNode) {
                    leftNode = new Node();
                }
                leftNode.add(v);
            } else {
                if (null == rightNode) {
                    rightNode = new Node();
                }
                rightNode.add(v);
            }
        }
    }

    public List<Object> values() {
        List<Object> values = new ArrayList<Object>();
        // 左节点遍历
        if (!(null == leftNode)) {
            values.addAll(leftNode.values());
        }
        values.add(value);
        // 右节点遍历
        if (null != rightNode) {
            values.addAll(rightNode.values());
        }
        return values;
    }

    public static void main(String[] args) {
        Random r = new Random();
        int[] values = new int[10];
        for (int i = 0; i < values.length; i++) {
            values[i] = r.nextInt(100);
        }
        System.out.println(Arrays.toString(values));
        Node root = new Node();
        for (int i : values) {
            root.add(i);
        }
        System.out.println(root.values());
    }

}
