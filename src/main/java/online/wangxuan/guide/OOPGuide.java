package online.wangxuan.guide;

import java.util.Objects;

/**
 * Created by wangxuan on 2017/5/27.
 */
public class OOPGuide {

    public static void main(String[] args) {
        // 1. 避免通过一个类的对象引用访问此类的静态变量或静态方法，无谓增加编译器解析成本，直接用类名来访问即可。

        // 2. 所有覆写的方法，必须加@Override注解。

        // 3. 相同的参数类型，相同业务含义，才可以使用Java的可变参数，避免使用Object。
        // 可变参数必须放置在参数列表的最后。(提倡尽量不用可变参数编程)
        // public User getUsers(String type, Integer... ids) {}

        // 4. Object的equals方法容易抛空指针异常，应使用常量或确定有值的对象来调用equals.
        // 正例："test".equals(object);
        // 反例：object.equals("test");
        // 推荐：使用java.util.Objects#equals (JDK7引入的工具类)
        boolean result = Objects.equals("test", "test");
        boolean result2 = "test".equals("test");
        System.out.println(result);
        System.out.println(result2);

        // 5. 所有相同类型的包装类对象之间值得比较，全部使用equals方法比较。

        /**
         * 说明：
         *  A) 对于字符串：
         *      ==     比较的是地址;
         *      equals 比较的是内容;
         *  B) 对于对象：
         *      == 和 equals 比较的都是地址
         *  C) 对于基本类型：
         *      只能使用 ==
         *  D) 对于包装类：
         *      ==     比较的是地址 (-128到127除外);
         *      equals 比较的是内容;
         */

        /**
         * 对于Integer在-128到127之间的赋值，Integer对象是在IntegerCache.cache产生，会复用已有对象。
         * 但是在这个区间外的所有数据，会在堆上产生，并不会复用对象，这是一个大坑。所以推荐使用equals。
         */
        Integer var1 = 100;
        Integer var2 = 100;
        System.out.println(var1 == var2); // true
        Integer var3 = 1000;
        Integer var4 = 1000;
        System.out.println(var3 == var4); // false

        /**
         * 6. 关于基本数据类型于包装数据类型的使用标准如下：
         *
         */

    }
}
