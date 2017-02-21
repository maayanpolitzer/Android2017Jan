package edu.tomer;

/**
 * Created by hackeru on 19/02/2017.
 */
public abstract class Employee extends Person {

    private String phone;

    public Employee(String name, String address, String phone) {
        super(name, address);
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

}
