package edu.tomer;

public class Main {

    public static void main(String[] args) {

        School s1 = new School();

        s1.addPerson(new Teacher("Shula", "Tel aviv", "052-12345678"));
        s1.addPerson(new Student("Liz", "Lod", "pkida"));
        s1.addPerson(new Nurse("Shirly", "Ramat gan", "12343453245"));
        s1.addPerson(new Employee("Yossi", "Holon", "100"));
        s1.addPerson(new Teacher("Tova", "Hetzeliya", "02453245"));
        s1.addPerson(new Person("Moshe", "Bat-yam"));


        s1.staffMeeting();
        s1.teachersMeeting();
        s1.displayNames();

    }
}
