package hashCodeTest;

import java.util.LinkedList;

/**
 * @author yejunyu
 * @date 17-12-28.
 */
public class MyHashMap {
    int cap = 2000;
    LinkedList<Object>[] maplist;

    public MyHashMap() {
        maplist = new LinkedList[cap];
    }

    /**
     * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
     如果该位置没有数据，则把字符串和对象组合成键值对Entry，再创建一个LinkedList，把键值对，放进LinkedList中，最后把LinkedList 保存在这个位置。
     如果该位置有数据，一定是一个LinkedList,则把字符串和对象组合成键值对Entry，插入到LinkedList后面。
     * @param str
     * @param obj
     */
    public void put(Object str, Object obj){
        String string = String.valueOf(str);
        int hashcode = hashcode(string);
        if (null == maplist[hashcode]){
            LinkedList<Object> linkedList = new LinkedList<>();
            linkedList.offer(obj);
            maplist[hashcode] = linkedList;
            return;
        }
        maplist[hashcode].offer(obj);
    }

    /**
     * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
     如果这个位置没有数据，则返回空
     如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空
     * @param str
     * @return
     */
    public Object get(Object str){
        String string = String.valueOf(str);
        int hashcode = hashcode(string);
        if (null == maplist[hashcode]){
            return null;
        } else {
            if (1 == maplist[hashcode].size()){
                return maplist[hashcode].get(0);
            }else {

                return null;
            }
        }
    }

    /**
     * 首先通过上一个自定义字符串的hashcode练习获取到该字符串的hashcode,然后把这个hashcode作为下标，定位到数组的指定位置。
     如果这个位置没有数据，则返回空
     如果这个位置有数据，则挨个比较其中键值对的键-字符串，是否equals，找到匹配的，把键值对的值，返回出去。找不到匹配的，就返回空
     * @param str
     * @return
     */
    public int hashcode(String str){
        int code = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            code += ((int)(chars[i])) * 23;
        }
        if (code > 1999){
            code = code % 2000;
        }
        if (code < 0){
            code = Math.abs(code);
        }
        return code;
    }

    public static void main(String[] args) {
    }
}
