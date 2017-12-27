package numberAndString.MyStringBuffer;

import myException.IndexIsNegativeException;
import myException.IndexIsOutofRangeException;

import java.util.Arrays;


public class MyStringBuffer implements IStringBuffer{
    int capacity = 16;
    int length = 0;
    char[] value;

    public MyStringBuffer(){
        value = new char[capacity];
    }

    //有参构造方法
    public MyStringBuffer(String str){
        if(null!=str){
            value =str.toCharArray();
        }
        length = value.length;
        if(capacity<value.length) {
            capacity = value.length * 2;
        }
        char[] newValue = new char[capacity];
        System.arraycopy(value,0,newValue,0,length);
        value = newValue;
    }

    @Override
    public String toString() {
        char[] newValue = new char[length];
        System.arraycopy(value, 0, newValue, 0, length);
        value = newValue;
        return Arrays.toString(value);
    }

    @Override
    public void append(String str) throws IndexIsNegativeException, IndexIsOutofRangeException {
        insert(length, str);
    }

    @Override
    public void append(char c) throws IndexIsNegativeException, IndexIsOutofRangeException {
        insert(length, c);
    }

    @Override
    public void insert(int pos, char b) throws IndexIsNegativeException, IndexIsOutofRangeException {
        insert(pos, String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) throws IndexIsNegativeException, IndexIsOutofRangeException {
        if (pos<0){
            throw new IndexIsNegativeException("插入位置不能为负!");
        }
        if (pos > length){
            throw new IndexIsOutofRangeException("插入位置超出范围");
        }
        if(b==null){
            return;
        }
        char[] insertB = b.toCharArray();
        int newLength = b.length();
        if (length+newLength>capacity){
            capacity = capacity * 2;
        }
        char[] newValue = new char[capacity];
        // 1. 元素后移
        // value pos 之后的元素全都后移 String b 长度的位置
        System.arraycopy(value,pos,newValue,pos + newLength,length-pos);
        // 2. 插入元素
        // pos 位置插入 String b 的长度
        System.arraycopy(insertB,0,newValue,pos,newLength);
        // pos 之前的不变
        System.arraycopy(value,0,newValue,0,pos);
        value = newValue;
        length = length + newLength;
    }

    @Override
    public void delete(int start) {
        if (start >= length || start < 0){
            return;
        }
        char[] newValue = new char[start];
        System.arraycopy(value,0,newValue,0,start);
        value = newValue;
        length = start;
    }

    @Override
    public void delete(int start, int end) {
        if (start >= length || start < 0){
            return;
        }
        if (end >= length || start < 0){
            return;
        }
        if (end < start){
            return;
        }
        int newLength = length-(end-start);
        char[] newValue = new char[newLength];
        System.arraycopy(value,0,newValue,0,start);
        System.arraycopy(value,end,newValue,start,length-end);
        value = newValue;
        length = newLength;
    }

    @Override
    public void reverse() {
        for (int i = 0; i < length/2; i++) {
            char temp = value[i];
            value[i] = value[length-i-1];
            value[length-i-1] = temp;
        }
    }

    @Override
    public int length() {
        return length;
    }
}
