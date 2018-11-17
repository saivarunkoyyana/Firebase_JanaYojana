package com.example.kvssaivarun.firebaset1;

import java.io.Serializable;

class Worker implements Serializable {
    String id;
    String name;
    String skill;
    String phone;
    public Worker(){

    }

    public Worker(String id, String w_name, String w_skill, String w_phone) {
        this.id=id;
        this.name=w_name;
        this.skill=w_skill;
        this.phone=w_phone;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
