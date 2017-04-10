package cargument.dantomdev.com.cargument.model;

import com.orm.dsl.Table;

@Table
public class User {
    private Long id = null;
    private String name;
    private String regNumber;

    public User(){

    }

    public User(Long id, String name, String regNumber) {
        this.id = id;
        this.name = name;
        this.regNumber = regNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }
}
