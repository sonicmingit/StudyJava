package factory;

/**
 * 测试类
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-8-27 19:15
 **/
public class StrategyMain {


    public static void main(String[] args) {
        //根据模式创建
        Strategy strategy = StrategyFactory.getInstance().get(StrategyEnum.THREE.getType());

        System.out.println(strategy.getType());
    }
}