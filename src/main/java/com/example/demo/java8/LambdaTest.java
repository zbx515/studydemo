package com.example.demo.java8;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class LambdaTest {
    public static void main(String[] args) {
        ArrayList<Person> peoples = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person person = new Person("皮皮虾",i);
            peoples.add(person);
        }
        Optional<Integer> reduce = peoples.stream()
                .filter(user -> user.getAge() > 10)//按条件过滤
                .sorted((user1, user2) -> user1.getAge() - user2.getAge())
                .limit(60)//取前60个
                .skip(10)//跳过前10个
                .map(Person::getAge)//获取所有的年龄并放入stream中
                //.collect(Collectors.toList())
                //.forEach(System.out::println);
                .reduce(Integer::sum);
        System.out.println(reduce.get());


    }
    @Test
    public void testApi(){
        String obj = supplierTest(() -> "供给型接口");
        System.out.println(obj);

        coumserTest(1000d,(t)-> System.out.println("吃饭花："+t));

        boolean testfunction = predicateTest(100, (t) -> t > 80);
        System.out.println(testfunction);

        Integer integer = functionTest(100, (t) -> t + 500);
        System.out.println(integer);

        Supplier su = Person::new;
        System.out.println(su.get());
    }
    //供给型接口
    public  String supplierTest(Supplier<String> supplier){
        return supplier.get();
    }
    //consumer消费型接口
    public  void coumserTest(Double money,Consumer<Double> consumer){
        consumer.accept(money);
    }
    //比较型接口
    public boolean predicateTest(Integer t,  Predicate<Integer> predicate){
        return predicate.test(t);
    }
    //函数式接口
    public Integer functionTest(Integer t, Function<Integer,Integer> function){
        return function.apply(t);
    }

}
