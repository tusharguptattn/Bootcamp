package org.example.builderPattern;

public class User {
    private final String name;
    private final int age ;
    private final String email;


    private User(Builder builder){
        name = builder.name;
        age = builder.age;
        email=builder.email;
    }


    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public static class Builder {
        private String name;
        private int age ;
        private String email;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build(){
            return new User(this);
        }
    }


}
