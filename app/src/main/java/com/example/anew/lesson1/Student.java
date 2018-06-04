package com.example.anew.lesson1;

public class Student {

    public String name, surname, grade, info;
    public Integer birthdayYear;
    public Long id;

    Student(String a, String b, String c, String d ){
        name = a;
        surname = b;
        grade = c;
        birthdayYear = Integer.valueOf(d);
        id = System.currentTimeMillis();
    }

    String info () {
        info = "id: " + id + "  " +
                "Имя: " + name + "  " +
                "Фамилия: " + surname + "  " +
                "Класс: " + grade + "  " +
                "Дата рождения: " + birthdayYear + "\n";
        return info;
    }


}
