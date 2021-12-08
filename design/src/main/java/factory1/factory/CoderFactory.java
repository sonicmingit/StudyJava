package factory1.factory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: SpringBootDemo
 * @description: 程序员工厂
 * @author: hao.yiming
 * @create: 2020-1-16 13:48
 **/
public class CoderFactory {
   private Map<String,Coder> factory;

    public CoderFactory(){
        List<Coder> coderList = new ArrayList<>();
        coderList.add(new JavaCoder());
        coderList.add(new JavaScriptCoder());
        coderList.add(new VueCoder());
        coderList.add(new PythonCoder());
        factory = coderList.stream().collect(Collectors.toMap(Coder::getName,coder -> coder));
    }

    public Coder get(String name){
        return factory.get(name);
    }





}
