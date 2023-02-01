package com.furkankaya.dto.request;

public class CustomerCreateUpdateDto {
    private String name;
    private int age;


    public CustomerCreateUpdateDto() {
    }

    public CustomerCreateUpdateDto(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
