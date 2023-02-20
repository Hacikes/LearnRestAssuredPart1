package com.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Runner {
    public static void main(String[] args){
        Student student = new Student("dfdsf", "dfdfdf");
        System.out.println(student.getName());
    }
    public Runner()
    {
        super();
    }
}
