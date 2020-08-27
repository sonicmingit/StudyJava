package factory;

/**
 * @program: StudyJavaSE
 * @description: 类型
 * @author: hao.yiming
 * @create: 2020-8-27 18:50
 **/
public enum StrategyEnum {

    ONE("1"),
    TWO("2"),
    THREE("3");


    private String type;

    StrategyEnum(String s) {
        this.type =s;
    }

    public String getType() {
        return type;
    }
}
