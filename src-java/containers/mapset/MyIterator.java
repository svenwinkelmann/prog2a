package containers.mapset;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MyIterator {

    public static void main(String[] args) {
        Student s1 = new Student("Paul", 2345);
        Student s2 = new Student("Lisa", 4252);
        Student s3 = new Student("Stephen", 2343);

        List<Student> list = new LinkedList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);

        // we can use a for loop to iterate:
        for (int i = 0; i < list.size(); i++) {
            Student s = list.get(i);
            System.out.println(s.name + ": " + s.matrNumber);
        }

        // more elegant to use a for-each loop:
        for (Student s: list)
            System.out.println(s.name + ": " + s.matrNumber);

        // to use the for-each loop the class needs to have an iterator:
        Iterator<Student> iterator = list.listIterator();
        while (iterator.hasNext()) {
            Student s = iterator.next();
            System.out.println(s.name + ": " + s.matrNumber);
        }
    }
}
