package com.pojo;

public class Runner {



    public static void main(String[] args){
        // Создаём из конструктора в Employee.java человека
        Employee employee = new Employee(14, "British", "Josh", "Josh1972@gmail.com");
        System.out.println(employee.id);
        System.out.println(employee.name);
        // Изменяем имя
        employee.name="Josh Kern";
        System.out.println(employee.name);







    }

}
