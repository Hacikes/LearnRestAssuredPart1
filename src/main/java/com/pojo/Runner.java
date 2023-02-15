package com.pojo;

public class Runner {



    public static void main(String[] args){
        // Создаём из конструктора в Employee.java человека
        Employee employee = new Employee(14, "British", "Josh", "Josh1972@gmail.com");
        System.out.println(employee.getId());
        System.out.println(employee.getName());
        // сл
        employee.setName(null);//name="Josh Kern";
        System.out.println(employee.getName());







    }

}
