package com.example.spring.exercise.collection;


import com.example.spring.exercise.log.logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import sun.misc.DoubleConsts;

/**
 * JAVA中有许多的集合，常用的有List(ArrayList/LinkedList)，Set(HashSet/TreeSet)，Queue，Map(HashMap/TreeMap)
 * java集合的由来： 在Java2之前，java是没有完整的集合框架的，它只有一些简单的可以自扩展的容器类，比如Vector，Stack，Hashtable等。
 */

/*
1.ArrayList是实现了基于动态数组的数据结构，LinkedList基于链表的数据结构。
2.对于随机访问get和set，ArrayList优于LinkedList，因为ArrayList可以随机定位，而LinkedList要移动指针一步一步的移动到节点处。（参考数组与链表来思考）
3.对于新增和删除操作add和remove，LinedList比较占优势，只需要对指针进行修改即可，而ArrayList要移动数据来填补被删除的对象的空间。
*/
@SpringBootTest
class TestCollection {
  private <E> void LOGGER(E e) {
    System.out.println(e);
  }

  /**
   * ArrayList 存不同类型数据.
   */
  @Test
  void testArrayList() {
    List<Serializable> list = new ArrayList<>();
    list.add("aaa");
    list.add(2);
    byte b = 8;
    list.add(b);

    LOGGER(list.size());
    LOGGER(list.get(0));
    LOGGER(list.get(1));

  }

  /**
   * ArrayList 存同类型数据.
   */
  @Test
  void testArrayList2() {
    ArrayList<String> list = new ArrayList<>();
    list.add("aaa");
    list.add("111");
    LOGGER(list.size());
    LOGGER(list.get(0));
    LOGGER(list.get(1));
  }

  /**
   * LinkedList 存不同类型数据.
   */
  @Test
  void testLinkedList() {
    List<java.io.Serializable> list = new LinkedList<>();
    list.add("aaa");
    list.add(2);
    LOGGER(list.size());
    LOGGER(list.get(0));
    LOGGER(list.get(1));
  }

  /**
   * LinkedList 存同类型数据.
   */
  @Test
  void testLinkedList2() {
    List<Integer> list = new LinkedList<>();
    list.add(0);
    list.add(2);
    list.add(4);
    list.add(6);
//    LOGGER(list.size());
//    LOGGER(list.get(0));
//    LOGGER(list.get(1));
    list.forEach(
        i -> {
          LOGGER(i);
        }
    );
  }

  /**
   * HashMap 是一个散列表，它存储的内容是键值对(key-value)映射.
   *
   * HashMap 实现了 Map 接口，根据键的 HashCode 值存储数据，具有很快的访问速度，最多允许一条记录的键为 null，不支持线程同步。
   * HashMap 是无序的，即不会记录插入的顺序。
   * HashMap 继承于AbstractMap，实现了 Map、Cloneable、java.io.Serializable 接口。
   */
  @Test
  void testHashMap() {
    Map<Integer, String> Sites = new HashMap<>();
    Sites.put(1, "Google");
    Sites.put(2, "Runoob");
    Sites.put(3, "Taobao");
    Sites.put(4, "Zhihu");
    System.out.println("集合元素：" + Sites);
    System.out.println("集合大小：" + Sites.size());
    System.out.println("集合key=3元素：" + Sites.get(3));
    Sites.remove(3);
    System.out.println("删除key=3后集合元素：" + Sites);
    System.out.println("删除key=3后集合大小：" + Sites.size());
    // 输出 key 和 value
    System.out.println("遍历所有key，根据key输出value：");
    for (Integer i : Sites.keySet()) {
      System.out.println("key: " + i + " value: " + Sites.get(i));
    }
    // 返回所有 value 值
    System.out.print("遍历所有value：");
    for (String value : Sites.values()) {
      // 输出每一个value
      System.out.print(value + " ");
    }
    System.out.println();
    Sites.clear();
    System.out.println("清除集合后元素：" + Sites);
    System.out.println("清除集合后大小：" + Sites.size());
  }

  /**
   * HashSet 基于 HashMap 来实现的，是一个不允许有重复元素的集合。
   */
  @Test
  void testHashSet() {
    HashSet<String> sites = new HashSet<>();
    sites.add("Google");
    sites.add("Runoob");
    sites.add("Taobao");
    sites.add("Zhihu");
    //sites.add("Runoob"); // 重复的元素不会被添加
    System.out.println("删除前:" + sites);
    System.out.println("Taobao是否存在:" + sites.contains("Taobao")); // 使用 contains() 方法来判断元素是否存在于集合当中
    sites.remove("Taobao"); // 删除元素，删除成功返回 true，否则为 false
    System.out.println("删除后:" + sites);
    System.out.println("集合大小:" + sites.size()); // 计算大小
  }




  /**
   * 两个对象的 hashCode()相同，则equals()也一定相同吗.
   */
  @Test
  void testHashCode(){
    String str1 = "通话";
    String str2 = "重地";
    System.out.println(String.format("str1：%d | str2：%d",  str1.hashCode(),str2.hashCode()));
    System.out.println(String.format("str1.length：%d | str2.length：%d",  str1.length(),str2.length()));
    long round = myround(-1.5);
    logger.info(round);
  }

  private long myround(double a) {
    long longBits = Double.doubleToRawLongBits(a);

    logger.info(longBits);
    long biasedExp = (longBits & DoubleConsts.EXP_BIT_MASK)
        >> (DoubleConsts.SIGNIFICAND_WIDTH - 1);
    long shift = (DoubleConsts.SIGNIFICAND_WIDTH - 2
        + DoubleConsts.EXP_BIAS) - biasedExp;
    if ((shift & -64) == 0) { // shift >= 0 && shift < 64
      // a is a finite number such that pow(2,-64) <= ulp(a) < 1
      long r = ((longBits & DoubleConsts.SIGNIF_BIT_MASK)
          | (DoubleConsts.SIGNIF_BIT_MASK + 1));
      if (longBits < 0) {
        r = -r;
      }
      // In the comments below each Java expression evaluates to the value
      // the corresponding mathematical expression:
      // (r) evaluates to a / ulp(a)
      // (r >> shift) evaluates to floor(a * 2)
      // ((r >> shift) + 1) evaluates to floor((a + 1/2) * 2)
      // (((r >> shift) + 1) >> 1) evaluates to floor(a + 1/2)
      return ((r >> shift) + 1) >> 1;
    } else {
      // a is either
      // - a finite number with abs(a) < exp(2,DoubleConsts.SIGNIFICAND_WIDTH-64) < 1/2
      // - a finite number with ulp(a) >= 1 and hence a is a mathematical integer
      // - an infinity or NaN
      return (long) a;
    }
  }
}
