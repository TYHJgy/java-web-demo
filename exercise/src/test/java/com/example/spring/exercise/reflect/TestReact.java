package com.example.spring.exercise.reflect;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 反射.
 */
@SpringBootTest
class ReflectClass {
    private static final Logger log = LoggerFactory.getLogger(ReflectClass.class);

    //三种方法获取类名
    @Test
    public void getClz() {
        try {
            // 方法一，使用 Class.forName 静态方法
            Class<?> classBook = Class.forName("com.example.spring.exercise.reflect.Book");
            // 方法二：直接通过 类名.class 的方式得到
            Class clz = Book.class;
            // 方法三：使用类对象的 getClass() 方法。
            Book book1 = new Book();
            Class<? extends Book> book1Class = book1.getClass();
            System.out.println(classBook);
            System.out.println(classBook == clz);
            System.out.println(classBook == book1Class);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 创建对象
    @Test
    public void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.example.spring.exercise.reflect.Book");

            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("Java高级特性-反射-创建对象");
            book.setAuthor("JourWon");
            log.info(book.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有的构造方法
    @Test
    public void reflectPrivateConstructor() {
        try {
            Class<?> classBook = Class.forName("com.example.spring.exercise.reflect.Book");
            Constructor<?> declaredConstructorBook = classBook.getDeclaredConstructor(String.class, String.class);
            // 暴力反射
            declaredConstructorBook.setAccessible(true);
            Object objectBook = declaredConstructorBook.newInstance("Java高级特性-反射-反射私有的构造方法", "JourWon");
            Book book = (Book) objectBook;
            log.info(book.toString());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // 反射私有属性
    @Test
    public void reflectPrivateField() {
        try {
            Class<?> classBook = Class.forName("com.example.spring.exercise.reflect.Book");
            Object objectBook = classBook.newInstance();
            Field fieldTag = classBook.getDeclaredField("TAG");
            fieldTag.setAccessible(true);
            String tag = (String) fieldTag.get(objectBook);
            log.info(tag);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    // 反射私有方法
    @Test
    public void reflectPrivateMethod() {
        try {
            Class<?> classBook = Class.forName("com.example.spring.exercise.reflect.Book");
            Method methodBook = classBook.getDeclaredMethod("declaredMethod", int.class);
            methodBook.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String string = (String) methodBook.invoke(objectBook, 0);
            ReflectClass.log.info(string);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

class Book{
    private final static String TAG = "BookTag";

    private String name;
    private String author;

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

    public Book() {
    }

    private Book(String name, String author) {
        this.name = name;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    private String declaredMethod(int index) {
        String string = null;
        switch (index) {
            case 0:
                string = "I am declaredMethod 0 !";
                break;
            case 1:
                string = "I am declaredMethod 1 !";
                break;
            default:
                string = "I am declaredMethod -1 !";
        }

        return string;
    }
}
