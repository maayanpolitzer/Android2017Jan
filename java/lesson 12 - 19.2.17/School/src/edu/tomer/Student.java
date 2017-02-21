package edu.tomer;

/**
 * Created by hackeru on 19/02/2017.
 */
public class Student extends Person {

    private String subject;

    public Student(String name, String address, String subject){
        super(name, address);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

}
