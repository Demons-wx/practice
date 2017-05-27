package online.wangxuan.guide;

/**
 * 常量定义
 * Created by wangxuan on 2017/5/27.
 */
public class ConstantGuide {

    /****** 1. 不允许任何魔法值(即未经定义的常量)直接出现在代码中。******/
    // 反例：
    // String key = "Id#taobao_" + tradeId;
    // cache.put(key, value);

    /****** 2. 如果变量值仅在一个范围内变化，且带有名称之外的延伸属性，定义为枚举类型， ******/
    // 下面正例中的数字就是延伸信息，表示星期几：
    private enum Days {
        MONDAY(1),
        TUESDAY(2),
        WEDNESDAY(3),
        THURSDAY(4),
        FRIDAY(5),
        SATURDAY(6),
        SUNDAY(7);

        private Integer num;

        private Days(Integer num) {
            this.num = num;
        }

        public Integer getNum() {
            return num;
        }

        public static void main(String[] args) {
            System.out.print(Days.FRIDAY.getNum());
        }
    }
}
