package com.driver;
import lombok.Getter;
import lombok.Setter;



@Getter
@Setter

public class Teacher {

    private String name;

    private int numberOfStudents;

    private int age;

    public Teacher(){
        this.name= name;
        this.numberOfStudents= numberOfStudents;
        this.age=age;
    }

}