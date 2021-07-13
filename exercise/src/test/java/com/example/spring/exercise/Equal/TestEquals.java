package com.example.spring.exercise.Equal;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TestEquals {
    final int I = 0;
    @Test
    void contextLoads() {
        System.out.println(TestEquals.class+"----"+"123");

        String x = "string";
        String y = "string";
        String z = new String("string");
        System.out.println(x==y); // true
        System.out.println(x==z); // false
        System.out.println(x.equals(y)); // true
        System.out.println(x.equals(z)); // true


    }
    @Test
    void testEqualsAndHashCode(){
        String str1 = "通话";
        String str2 = "重地";
        String str3 = new String("重地");
        System.out.println(String.format("str1：%d | str2：%d | str3：%d",  str1.hashCode(),str2.hashCode(),str3.hashCode()));
        System.out.println(str1.equals(str2));
        System.out.println(str3.equals(str2));
    }

}

