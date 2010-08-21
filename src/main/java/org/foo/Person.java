package org.foo;
import org.apache.commons.lang.builder.ToStringBuilder;

final class Person{
    private final String firstName,lastName;
    private final int age;
    private final double salary;

    Person(final String firstName, final String lastName, final int age, final double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
    }
    public String firstName() {return firstName;}
    public String lastName() {return lastName;}
    public int age() {return age;}
    public double salary() {return salary;}

    @Override
    public String toString() { return ToStringBuilder.reflectionToString(this);}
}