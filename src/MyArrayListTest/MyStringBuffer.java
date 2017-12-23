package MyArrayListTest;

import myException.IndexIsNegativeException;
import myException.IndexIsOutofRangeException;
import numberAndString.MyStringBuffer.IStringBuffer;
import numberAndString.Str;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author yejunyu
 * @date 2017/12/22.
 */
public class MyStringBuffer implements IStringBuffer{
    ArrayList<Character> value;

    public MyStringBuffer() {
        value = new ArrayList<>(16);
    }

    public MyStringBuffer(String str) {
        this();
        if (null == str){
            return;
        }
        char[] a = str.toCharArray();
        for (int i = 0; i < a.length; i++) {
            value.add(a[i]);
        }
    }

    @Override
    public void append(String str) throws IndexIsNegativeException, IndexIsOutofRangeException {
        insert(value.size(), str);
    }

    @Override
    public void append(char c) throws IndexIsNegativeException, IndexIsOutofRangeException {
        insert(value.size(), c);
    }

    @Override
    public void insert(int pos, char b) throws IndexIsNegativeException, IndexIsOutofRangeException {
        insert(pos, String.valueOf(b));
    }

    @Override
    public void insert(int pos, String b) throws IndexIsNegativeException, IndexIsOutofRangeException {
        if (pos < 0){
            throw new IndexIsNegativeException("插入位置不能为负");
        }
        if (pos > value.size()){
            throw new IndexIsOutofRangeException("插入超出范围");
        }
        if (null == b){
            return;
        }
        char[] a = b.toCharArray();
        for (int i = 0; i < a.length; i++) {
            value.add(pos + i, a[i]);
        }
        System.out.println(value);
    }

    @Override
    public void delete(int start) throws IndexIsNegativeException, IndexIsOutofRangeException {
        delete(start, value.size());
    }

    @Override
    public void delete(int start, int end) throws IndexIsNegativeException, IndexIsOutofRangeException {
        if (start < 0){
            throw new IndexIsNegativeException("插入位置不能为负");
        }
        if (start > value.size()){
            throw new IndexIsOutofRangeException("插入超出范围");
        }
        for (int i = start; i < end; i++) {
            value.remove(start);
        }
        System.out.println(value);
    }

    @Override
    public void reverse() {
        char temp;
        for (int i = 0; i < value.size()/2; i++) {
            temp = value.get(i);
            value.set(i, value.get(value.size()-1-i));
            value.set(value.size()-1-i,temp);
        }
        System.out.println(value);
    }

    @Override
    public int length() {
        System.out.println(value.size());
        return value.size();
    }

    public static void main(String[] args) {
        MyStringBuffer a = new MyStringBuffer();
        try {
            a.insert(0,"a");
            a.insert(1, 'b');
            a.append('c');
            a.append("abcdefg");
            a.delete(1,2);
            a.delete(4);
            a.reverse();
            a.length();
        } catch (IndexIsNegativeException e) {
            e.printStackTrace();
        } catch (IndexIsOutofRangeException e) {
            e.printStackTrace();
        }
    }
}
