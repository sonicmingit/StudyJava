package factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 工厂
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-8-27 18:47
 **/
public class StrategyFactory {

    private Map<String, Strategy> map;

    public StrategyFactory() {
        List<Strategy> strategies = new ArrayList<>();
        // 添加处理方法
        strategies.add(new StrategyOne());
        strategies.add(new StrategyTwo());
        strategies.add(new StrategyThree());
        // 封装Map
        map = strategies.stream().collect(Collectors.toMap(Strategy::getType, strategy -> strategy));
    }

    public static class Handler {
        public static StrategyFactory instance = new StrategyFactory();
    }

    public static StrategyFactory getInstance() {
        return Handler.instance;
    }

    public Strategy get(String type) {
        return map.get(type);
    }
}