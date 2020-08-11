package com.wtf.codewarehouse.serialization;

import java.io.Serializable;

/**
 * @author wangtengfei
 * @since 2020/8/4 13:55
 */
public class Person implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private Person spouse;
    private Gender gender;


    private void writeObject(java.io.ObjectOutputStream stream)
            throws java.io.IOException
    {
        // "Encrypt"/obscure the sensitive data
        age = age << 2;
        stream.defaultWriteObject();
    }

    private void readObject(java.io.ObjectInputStream stream)
            throws java.io.IOException, ClassNotFoundException
    {
        stream.defaultReadObject();

        // "Decrypt"/de-obscure the sensitive data
        age = age << 2;
    }

    public Person(String firstName, String lastName, int age,Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender=gender;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", spouse=" + spouse +
                ", gender=" + gender +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person getSpouse() {
        return spouse;
    }

    public void setSpouse(Person spouse) {
        this.spouse = spouse;
    }
}
