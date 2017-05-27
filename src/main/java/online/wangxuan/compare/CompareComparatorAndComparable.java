package online.wangxuan.compare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wangxuan on 2017/5/26.
 */
public class CompareComparatorAndComparable {

    /**
     * Person类实现了Comparable接口，这意味着Person本身支持排序
     */
    private static class Person implements Comparable<Person> {

        int age;
        String name;

        public Person(int age, String name) {
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
            return name + "-" + age;
        }

        /**
         * 比较两个Person是否相等，若它们的name和age都相等，则认为他们相等
         * @param o
         * @return
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person)) return false;

            Person person = (Person) o;

            if (age != person.age) return false;
            return name == person.name;
        }

        @Override
        public int hashCode() {
            int result = age;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            return result;
        }

        /**
         * 通过Person的name字段进行比较
         * @param o
         * @return
         */
        public int compareTo(Person o) {
            return name.compareTo(o.name);
        }
    }

    /**
     * Person的age升序比较器
     */
    private static class AscAgeComparator implements Comparator<Person> {
        public int compare(Person o1, Person o2) {
            return o1.getAge() - o2.getAge();
        }
    }

    /**
     * Person的age降序比较器
     */
    private static class DescAgeComparator implements Comparator<Person> {
        public int compare(Person o1, Person o2) {
            return o2.getAge() - o1.getAge();
        }
    }

    public static void main(String[] args) {
        ArrayList<Person> list = new ArrayList<Person>();
        list.add(new Person(20, "ccc"));
        list.add(new Person(30, "AAA"));
        list.add(new Person(10, "bbb"));
        list.add(new Person(40, "ddd"));

        System.out.printf("Orifinal     sort, list:%s\n", list);

        /**************** 对list进行排序 *****************/
        // 1. 使用Person实现的Comparable<Person>接口进行排序，即根据name进行排序
        Collections.sort(list);
        System.out.printf("Name       sort, list:%s\n", list);
        // 2. 通过比较器AscAgeComparator接口进行排序，即根据age升序进行排序
        Collections.sort(list, new AscAgeComparator());
        System.out.printf("Asc(age)   sort, list:%s\n", list);
        // 3. 通过比较器DescAgeComparator接口进行排序，即根据age降序进行排序
        Collections.sort(list, new DescAgeComparator());
        System.out.printf("Desc(age) sort, list:%s\n", list);

        /**************** 比较两个Person ****************/
        testEquals();
    }

    private static void testEquals() {
        Person p1 = new Person(25, "wx");
        Person p2 = new Person(25, "wx");

        if (p1.equals(p2))
            System.out.printf("%s Equals %s\n", p1, p2);
        else
            System.out.printf("%s Not Equals %s\n", p1, p2);

    }
}
