package sonic.java8.lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * lamda排序Demo
 *
 * @author: yiming.hym(郝一鸣)
 * @date: 2020-3-16 17:08
 **/
public class LamdaSort {

    /*练习一-Employee类中先按年龄比，年龄相同按照姓名比-都是升序*/

    class Employee {


        String name;
        Integer age;
        Double salary;


        Employee(String name, Integer age, Double salary) {
            this.name = name;
            this.age = age;
            this.salary = salary;
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

        public Double getSalary() {
            return salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

    }

    //创建一个集合对象
    public List<Employee> createEmp() {
        List<Employee> employees = Arrays.asList(
                new Employee("田七", 27, 7777.77),
                new Employee("王五", 24, 5555.55),
                new Employee("张三", 23, 3333.33),
                new Employee("李四", 24, 4444.44),
                new Employee("赵六", 26, 6666.66)
        );

        return employees;
    }

    public static void main(String[] args) {
        LamdaSort lamda = new LamdaSort();
        //1.按年龄排序并输出
        List<Employee> employees = lamda.createEmp();
        Collections.sort(employees,(x , y)->x.getAge()-y.getAge());
        employees.forEach(i-> System.out.println(i.getAge()));
    }
}