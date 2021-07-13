package com.example.spring.exercise.abstract_test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
/*
* 抽象类除了不能实例化对象之外，类的其它功能依然存在，成员变量、成员方法和构造方法的访问方式和普通类一样。
* 抽象类不能实例化对象，所以抽象类必须被继承，才能被使用。
* 抽象类表示的是一种继承关系，一个类只能继承一个抽象类，而一个类却可以实现多个接口。
* 如果一个类包含抽象方法，那么该类必须是抽象类。
* 任何子类必须重写父类的抽象方法，或者声明自身为抽象类。
* */
@SpringBootTest
class ExerciseApplicationTestAbstract {
    @Test
    void contextLoads() {
        Salary s = new Salary("Mohd Mohtashim", "Ambehta, UP", 3, 3600.00);
        Employee e = new Salary("John Adams", "Boston, MA", 2, 2400.00);

        System.out.println("Call mailCheck using Salary reference --");
        s.mailCheck();
        s.mailCheck2();


        System.out.println("\nCall mailCheck using Employee reference--");
        e.mailCheck();
        e.mailCheck2();
    }

}
class Salary extends Employee
{
    private double salary; //Annual salary
    public Salary(String name, String address, int number, double
            salary)
    {
        super(name, address, number);
        setSalary(salary);
    }

    public double getSalary()
    {
        return salary;
    }
    public void mailCheck()
    {
        System.out.println("Within mailCheck of Salary class ");
        System.out.println("Mailing check to " + getName() +" with salary " + salary);
    }

    @Override
    public double mailCheck2() {
        System.out.println("this override mailCheck2");
        return 0;
    }

    public void setSalary(double newSalary)
    {
        if(newSalary >= 0.0)
        {
            salary = newSalary;
        }
    }
    public double computePay()
    {
        System.out.println("Computing salary pay for " + getName());
        return salary/52;
    }
}
/* 文件名 : Employee.java */
abstract class Employee
{
    private String name;
    private String address;
    private int number;
    public Employee(String name, String address, int number)
    {
        System.out.println("Constructing an Employee");
        this.name = name;
        this.address = address;
        this.number = number;
    }
    public double computePay()
    {
        System.out.println("Inside Employee computePay");
        return 0.0;
    }
    public void mailCheck()
    {
        System.out.println("2Mailing a check to " + this.name + " " + this.address);
    }
    public abstract double mailCheck2();
    public String toString()
    {
        return name + " " + address + " " + number;
    }
    public String getName()
    {
        return name;
    }
    public String getAddress()
    {
        return address;
    }
    public void setAddress(String newAddress)
    {
        address = newAddress;
    }
    public int getNumber()
    {
        return number;
    }
}