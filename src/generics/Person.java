package generics;

public class Person {
    String name;
    String email;
    int age;

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    public String toString() {
        return "" + this.name + ": " + this.email + " (" + this.age + " years old)";
    }
}
