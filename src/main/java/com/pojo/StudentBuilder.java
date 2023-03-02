package com.pojo;

import lombok.Setter;

public class StudentBuilder {

    private int id;
    private String Text;
    private String email;
    private String name;

    // Метод Студента строителя
    public StudentBuilder builder(){
        return this;
    }

    public StudentBuilder setId(int id) {
        this.id = id;
        return this;
    }

    public StudentBuilder setText(String text) {
        Text = text;
        return this;
    }

    public StudentBuilder setEmail(String email) {
        this.email = email;
        return this;
    }

    public StudentBuilder setName(String name) {
        this.name = name;
        return this;
    }

    // Методы build, and, with созданы, для примера, они ничего не делают
    public StudentBuilder build(){
        return this;
    }

    public StudentBuilder and(){
        return this;
    }

    public StudentBuilder with(){
        return this;
    }

    // Метод студента, для того, чтобы его построить
    public Student perform(){
        return new Student(this.id, this.Text, this.email, this.name);
    }


}
