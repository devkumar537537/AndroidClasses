package com.batch12pm.basicadvancecomponent;

import java.io.Serializable;

public class TestModel implements Serializable {
    private String name;
    private String age;
private SecondModel secondModel;

    public TestModel(String name, String age, SecondModel secondModel) {
        this.name = name;
        this.age = age;
        this.secondModel = secondModel;
    }

    public TestModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public SecondModel getSecondModel() {
        return secondModel;
    }

    public void setSecondModel(SecondModel secondModel) {
        this.secondModel = secondModel;
    }
}
