package com.spring.hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Hellolombok {
    
    private String name;
    private int age;

    public static void main(String[] args) {
        Hellolombok hellolombok = new Hellolombok();
        hellolombok.setName("name");
        
        String name = hellolombok.getName();
        System.out.println("name = " + name);;
        System.out.println("hellolombok = " + hellolombok);;
    }
}
