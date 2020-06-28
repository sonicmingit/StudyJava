package sonic.pojo;

import lombok.Data;

import java.util.List;

/**
 * ok
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-5-29 11:10
 **/
@Data
public class Ok {
    String okStr;
    Integer okInt;
    Double okDouble;
    OkSub1 ok1;
    List<OkSub2> ok2;
}