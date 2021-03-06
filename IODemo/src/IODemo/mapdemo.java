package IODemo;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 需求：随便输入一串字符串，需要找到其中出现的每个字符的个数
 *
 * 思路：1.先将字符串转换为字符数组
 * 2.定义一个map集合，并且需要定义一个Treemap，因为里面元素有顺序
 * 3.遍历字符数组，将每一个字符作为键去查map集合，如果不存在这个键则添加这个键，并给他赋值，如果存在的话就拿出这个键，将他的值加1并存回去
 * 4.将map变成指定的字符串返回，可以先通过entryset拿出所有的键值关系，再通过StringBuilder容器一个一个往里加实现特定形式的字符串。
 */
public class mapdemo {
    public static void main(String[] args) {
        String abc="daafasfwerfqqqwdeqw";
        String s = selectNum(abc);
        System.out.println(s);
    }

    public static String selectNum(String tr){
        char[] chars = tr.toCharArray();
        TreeMap<Character,Integer> treeMap=new TreeMap<>();
        int count=0;
        for (int i = 0; i < chars.length; i++) {
            Integer integer = treeMap.get(chars[i]);
            if(integer!=null)
                count=integer;
            count++;
            treeMap.put(chars[i],count);
            count=0;
        }
        System.out.println(treeMap);
        //遍历map元素
        StringBuffer stringBuffer = new StringBuffer();
        Set<Map.Entry<Character, Integer>> entries = treeMap.entrySet();
        Iterator<Map.Entry<Character, Integer>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            stringBuffer.append(key+","+value+" ");
        }
        return stringBuffer.toString();
    }
}
