package factory;

/**
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-8-27 18:48
 **/
public interface Strategy {

    /**
    默认方法
     */
    String handle();


    /**
     * 对应类型
     */
    String getType();
}