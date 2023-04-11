package containers.mapset;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MySet {

    public static void main(String[] args) {

        Student s1 = new Student("Paul", 34425);
        Student s2 = new Student("Pauline", 34484);
        Student s3 = new Student("Tina", 34424);
        Student s4 = new Student("Sven", 34424);

        System.out.println("Comparing " + s4.name + " and " + s3.name + ": " + s4.equals(s3));

        Set<Student> mySet = new HashSet<Student>();

        mySet.add(s1);
        mySet.add(s2);
        mySet.add(s3);
        mySet.add(s1);

        for(Student s: mySet)
            System.out.println(s.name);

        System.out.println("----");

        mySet.add(s4);

        for(Student s: mySet)
            System.out.println(s.name);
    }
}