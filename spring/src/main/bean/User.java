package main.bean;

import lombok.Data;

import java.util.List;
import java.util.Map;

/**
 * 用户
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-12-24 13:45
 **/
@Data
public class User {

    String name;

    Integer age;

    User other;

    List<User> children;

    List<String> cars;

    Map<String,Integer> house;

    Map<User,User>  childrenMap;


    //无参构造
    public User() {
    }

    //有参构造
    public User(String name) {
        this.name = name;
    }

    //bean初始化方法
    public void init(){
        System.out.println("User Bean初始化......");
    }
    //bean销毁时调用的方法
    public void destroy(){
        System.out.println("User Bean销毁......");
    }


    /*Get/Set*/

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public Map<String, Integer> getHouse() {
        return house;
    }

    public void setHouse(Map<String, Integer> house) {
        this.house = house;
    }

    public Map<User, User> getChildrenMap() {
        return childrenMap;
    }

    public void setChildrenMap(Map<User, User> childrenMap) {
        this.childrenMap = childrenMap;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User getOther() {
        return other;
    }

    public void setOther(User other) {
        this.other = other;
    }

    public List<User> getChildren() {
        return children;
    }

    public void setChildren(List<User> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", other=" + other +
                ", children=" + children +
                ", cars=" + cars +
                ", house=" + house +
                ", childrenMap=" + childrenMap +
                '}';
    }
}