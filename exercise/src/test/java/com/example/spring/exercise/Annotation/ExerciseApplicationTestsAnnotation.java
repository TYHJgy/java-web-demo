package com.example.spring.exercise.Annotation;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.validation.constraints.Min;
import java.lang.annotation.*;

/**
 * Java 注解（Annotation）又称 Java 标注，是 JDK5.0 引入的一种注释机制。
 * Java 语言中的类、方法、变量、参数和包等都可以被标注。
 * 和 Javadoc 不同，Java 标注可以通过反射获取标注内容。
 *
 * Java 定义了一套注解，共有 7 个，3 个在 java.lang 中，剩下 4 个在 java.lang.annotation 中。
 */

@SpringBootTest
class ExerciseApplicationTestsAnnotation {
    @Test
    void contextLoads() {

        //System.out.println(ExerciseApplicationTestsAnnotation.class+"----"+"123");
        test(5);

    }
    private void test(@Min(10) int a){
        System.out.println(a);
    }

}


/**
 * 自定义的Annotation。
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
//@Inherited
@interface Inheritable
{

}

@Inheritable
class InheritableFather
{
    public InheritableFather() {
        // InheritableBase是否具有 Inheritable Annotation
        System.out.println("InheritableFather:"+InheritableFather.class.isAnnotationPresent(Inheritable.class));
    }
}

/**
 * InheritableSon 类只是继承于 InheritableFather，
 */
class InheritableSon extends InheritableFather
{
    public InheritableSon() {
        super();    // 调用父类的构造函数
        // InheritableSon类是否具有 Inheritable Annotation
        System.out.println("InheritableSon:"+InheritableSon.class.isAnnotationPresent(Inheritable.class));
    }

    public static void main(String[] args)
    {
        InheritableSon is = new InheritableSon();
        System.out.println(InheritableSon.class);
        System.out.println(InheritableSon.class.getClass());
        System.out.println(Object.class);
        System.out.println(Object.class.getClass());
        System.out.println(Class.class);
        System.out.println(Class.class.getClass());

        Class c = Class.class;
        System.out.println(c.toString());
    }
}