package edu.hackeru;

/**
 * Created by hackeru on 02/04/2017.
 */
public class Person {

    private String name;
    private String email;
    private String address;
    private String phone;
    private int age;

    private Person(Builder builder) {
        name = builder.name;
        email = builder.email;
        address = builder.address;
        phone = builder.phone;
        age = builder.age;
    }

    public static class Builder {
        private String name;
        private String email;
        private String address;
        private String phone;
        private int age;

        public Builder(String name, String email){
            this.name = name;
            this.email = email;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Person build(){
            return new Person(this);
        }
    }
}
