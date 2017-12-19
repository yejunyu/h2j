package numberAndString.MyStringBuffer;

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
    }

    @Override
    public String toString() {
        return Arrays.toString(value);
    }

    @Override
    public void append(String str) {
        if(str!=null){
            char[] a = str.toCharArray();
            int aLength = str.length();
            if((length+aLength)>capacity){
                capacity = capacity * 2;
            }
            for (int i = 0; i < aLength; i++) {

            }
        }
    }

    @Override
    public void append(char c) {

    }

    @Override
    public void insert(int pos, char b) {

    }

    @Override
    public void insert(int pos, String b) {

    }

    @Override
    public void delete(int start) {

    }

    @Override
    public void delete(int start, int end) {

    }

    @Override
    public void reverse() {
        for (int i = 0; i < length / 2; i++) {
            char temp = value[i];
            value[i] = value[length-1];
            value[length-1] = temp;
        }
    }

    @Override
    public int length() {
        return 0;
    }
}
