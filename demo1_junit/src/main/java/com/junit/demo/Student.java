package com.junit.demo;

public class Student {

    private int studentId;
    private String name;
    private int mark1;
    private int mark2;
    private int mark3;

    public Student(int studentId, String name, int mark1, int mark2, int mark3) {
        this.studentId = studentId;
        this.name = name;
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public int getMark1() {
        return mark1;
    }

    public int getMark2() {
        return mark2;
    }

    public int getMark3() {
        return mark3;
    }
}

