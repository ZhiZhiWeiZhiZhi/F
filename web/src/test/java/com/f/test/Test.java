package com.f.test;

/**
 * Created by zhi on 2017/11/23.
 */
public class Test {
    public static void main(String... args) {

        Integer i=128;
        Integer j=128;
        if(i==j){
            System.out.println(true);
        }else {
            System.out.println(false);
        }

//        // Java 8之后：
//        List features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
//        features.forEach(n -> System.out.println(n));
//
//// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
//// 看起来像C++的作用域解析运算符
//        features.forEach(System.out::println);
    }

}
