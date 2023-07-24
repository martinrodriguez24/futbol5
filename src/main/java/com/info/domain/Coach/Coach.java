package com.info.domain.Coach;

import com.info.domain.Person;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coach extends Person {
    private int age;

    public Coach (String name, int age) {
        this.name = name;
        this.age = age;
    }
}
