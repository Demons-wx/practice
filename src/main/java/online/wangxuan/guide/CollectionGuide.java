package online.wangxuan.guide;

import java.util.*;

/**
 * 集合处理
 * Created by wangxuan on 2017/5/25.
 */
public class CollectionGuide {

    /**
     * 1. 集合转数组
     *
     * 使用集合转数组的方法，必须使用集合的 toArray(T[] array)，传入的是类型完全一样的数组，大小就是list.size()。
     *
     * 注意：直接使用toArray无参方法存在问题，此方法返回值只能是Object[]类，若强转其他类型数组将出现ClassCastException错误。
     */
    public static void listToArray() {
       List<String> list = new ArrayList<String>();
       list.add("wx");
       list.add("wrong");

       String[] array = new String[list.size()];
       array = list.toArray(array);
       for (String s : array)
           System.out.println(s);
    }

    /**
     * 2. 数组转集合
     *
     * 使用工具类Arrays.asList()把数组转换成集合时，不能使用其修改集合相关方法，它的add/remove/clear方法会
     * 抛出UnsupportedOperationException异常。
     *
     * 说明：asList的返回对象是一个Arrays的内部类，并没有实现集合的修改方法。Arrays.asList体现的是适配器模式
     * 只是转换接口，后台的数据仍是数组。
     */
    public static void arrayToList() {
        String[] str = new String[] {"a", "b"};
        List<String> list = Arrays.asList(str);

        str[0] = "wx";
        System.out.println(list.get(0)); // 输出：wx
        // 抛出异常：UnsupportedOperationException
        list.add("c");
    }

    /**
     * 3. foreach中禁止删除
     *
     * 不要在foreach循环里进行元素的remove/add操作。remove元素请使用Iterator方式，如果并发操作，需要对Iterator对象加锁。
     *
     * 注意：在使用foreach循环删除元素时，除了倒数第二个元素，其他都会抛出异常：ConcurrentModificationException。
     */
    public static void foreach() {

        List<String> a = new ArrayList<String>();
        a.add("1");
        a.add("2");
        a.add("3");

        // 反例：
        for (String temp : a) {
            if ("3".equals(temp))
                a.remove(temp);
        }

        // 正例：
        Iterator<String> it = a.iterator();
        while (it.hasNext()) {
            String temp = it.next();
            if ("1".equals(temp))
                a.remove(temp);
        }
    }

    /**
     * 4. Comparator
     * 在JDK7版本及以上，Comparator要满足如下三个条件，不然Arrays.sort，Collections.sort
     * 会报IllegalArgumentException异常.
     * 1. x,y的比较结果和y,x的比较结果相反.
     * 2. x>y, y>z, 则x>z.
     * 3. x=y, 则x,z比较结果和y,z比较结果相同.
     */
    public static void compare() {
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(24, "hy"));
        students.add(new Student(25, "wx"));
        Collections.sort(students, new WrongComparator());
        System.out.printf("sorted list %s\n", students);
        Collections.sort(students, new RightComparator());
        System.out.printf("sorted list %s\n", students);
    }
    private static class Student {
        int age;
        String name;
        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }
        public int getAge() {
            return age;
        }
        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return name + ": " + age;
        }
    }
    // 反例：下例中没有处理相等的情况，实际使用中可能会出现异常
    private static class WrongComparator implements Comparator<Student> {
        public int compare(Student o1, Student o2) {
            return o1.getAge() > o2.getAge() ? 1 : -1;
        }
    }
    // 正例：
    private static class RightComparator implements Comparator<Student> {
        public int compare(Student o1, Student o2) {
            return o1.getAge() == o2.getAge() ? 0 : (o1.getAge() > o2.getAge() ? 1 : -1);
        }
    }

    /**
     * 5. 集合初始化时,指定集合初始值大小。
     */
    public static void collectionInit() {

        /**
         * 正例：
         * initialCapacity=(需要存储的元素个数/负载因子)+1. 负载因子默认为0.75, 如果暂时无法确定
         * 初始值大小, 请设置为16
         *
         * 备注：16为默认初始化大小
         */
        Map<String, Student> studentMap = new HashMap<String, Student>(16);

        /**
         * 反例：
         * 假设students需要防止1024个元素, 由于没有设置容量初始大小,随着元素不断增加,容量7次被迫扩大,
         * resize需要重建hash表, 严重影响性能.
         */
        List<Student> students = new ArrayList<Student>();
    }

    /**
     * 6. HashMap可以置key为null, 由于HashMap的干扰, 很多人认为ConcurrentHashMap是可以置入null值,
     * 而事实上存储null值时会抛出NPE异常.
     */

    /**
     * 7. sort: 有序性, 是指遍历的结果是按某种比较规则依次排列的.
     *    order: 稳定性, 是指集合每次遍历的元素次序是一定的.
     *
     * 例如: ArrayList是order/unsort;
     *      HashMap是unorder/unsort;
     *      TreeSet是order/sort.
     */



    public static void main(String[] args) {
    //    listToArray();
    //    arrayToList();
    //    foreach();
        compare();
    }
}
