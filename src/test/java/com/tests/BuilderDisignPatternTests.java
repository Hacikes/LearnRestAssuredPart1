package com.tests;

import com.pojo.Student;
import com.pojo.StudentBuilder;
import org.testng.annotations.Test;

public class BuilderDisignPatternTests { // Неизменяемость
    @Test
    public void buiderTest(){
        // Чем меньше параметров, тем читабельнее

                // В данном случае в классе Employee.java используется второй конструктор
                // Но это сложно поддерживать и создавать другие варианты
                // Создавать много конструкторов, тоже не есть хорошо


        // Способы шаблона проектирования Builder
        // 1) External Builder
        Student studentBuilder = new StudentBuilder()
                .builder()
                .and()
                .setId(566)
                .and()
                .setEmail("sdfdsf@gmail.com")
                .with()
                .setName("Josh")
                .build()
                .perform();


        Student student1 = Student.builder().email("fgfgf").name("ghgh").Text("dfdfdfdfd").getStudent();
        System.out.println(student1);
        // 2) Static Inner Class


    }

}
