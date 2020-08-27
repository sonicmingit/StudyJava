package factory;

/**
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-8-27 19:11
 **/
public class StrategyTwo implements Strategy {
    /**
     * 默认方法
     */
    @Override
    public String handle() {
        return "第二个方法";
    }

    /**
     * 对应类型
     */
    @Override
    public String getType() {
        return StrategyEnum.TWO.getType();
    }
}