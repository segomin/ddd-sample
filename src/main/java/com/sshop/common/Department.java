package com.sshop.common;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Department {
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public Department() {
    }

    public Department(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
