package com.ttt.utils;

import com.github.javafaker.Faker;

public final class  RandomUtil {
    private static Faker faker;
    private RandomUtil(){
        faker = new Faker();
    }

    public static String getRandomFirstName(){
        return faker.name().firstName();
    }

    public static String getRandomLastName(){
        return faker.name().lastName();
    }

    public static int getRandomIntegerWithRange(int min,int max){
        return faker.number().numberBetween(min,max);
    }

    public static int getRandomDigitNotZero(){
        return faker.number().randomDigitNotZero();
    }

}
