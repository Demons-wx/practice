package online.wangxuan.guide;

/**
 * 命名规则
 * Created by wangxuan on 2017/5/26.
 */
public class NameGuide {

    /****** 不能以下划线或美元符号开始，也不能以下划线或美元符号结束 ******/
    // 反例：
    String _name, $name, name_, name$;

    /****** 严禁使用拼音和英文混合的方式，避免使用纯拼音 ******/
    // 正例：
    String alibaba;
    // 反例：
    String dazhePromotion;

    /****** 类名使用UpperCamelCase *******/
    // 正例：MarcoPolo 反例：macroPolo

    /****** 方法名、参数名、成员变量、局部变量统一使用lowerCamelCase ******/
    // 正例：
    Integer inputUserId;

    /****** 常量命名全部大写，单词间以下划线隔开，力求语义表达完整清楚，不要嫌长。 ******/
    public static int MAX_COUNT = 10;

    /****** 抽象类命名使用Abstract或Base开头，异常类命名使用Exception结尾，测试类命名以它要测试的类名开始以Test结尾 ******/

    /****** POJO类中的布尔类型的变量，都不要加is，否则部分框架解析会引起序列化错误。 ******/
    // 反例：
    Boolean isDeleted;

    /****** 接口类中的方法和属性不要加任何修饰符(public也不要加)，加上有效的javadoc注释。******/

    /**
     * [参考]各层命名规约：
     * A) Service/DAO层方法命名规约：
     * 1. 获取单个对象的方法用get做前缀。
     * 2. 获取多个对象的方法用list做前缀。
     * 3. 获取统计值的方法用count做前缀。
     * 4. 插入的方法用save或insert做前缀。
     * 5. 删除的方法用remove或delete做前缀。
     * 5. 修改方法用update做前缀。
     *
     * B) 领域模型命名规约：
     * 1. 数据对象：xxxDo, xxx即为数据表名。
     * 2. 数据传输对象：xxxDTO, xxx为业务领域相关的名称。
     * 3. 展示对象：xxxVO, xxx一般为网页名称。
     * 4. POJO是DO/DTO/BO/VO的统称，禁止命名成xxxPOJO。
     */
}

