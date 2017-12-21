package numberAndString.MyStringBuffer;

import myException.IndexIsNegativeException;
import myException.IndexIsOutofRangeException;

public interface IStringBuffer {
    void append(String str) throws IndexIsNegativeException, IndexIsOutofRangeException; //追加字符串
    void append(char c) throws IndexIsNegativeException, IndexIsOutofRangeException;  //追加字符
    void insert(int pos,char b) throws IndexIsNegativeException, IndexIsOutofRangeException; //指定位置插入字符
    void insert(int pos,String b) throws IndexIsNegativeException, IndexIsOutofRangeException; //指定位置插入字符串
    void delete(int start); //从开始位置删除剩下的
    void delete(int start,int end); //从开始位置删除结束位置-1
    void reverse(); //反转
    int length(); //返回长度
}
