package containers.mapset;

import javax.xml.crypto.dsig.keyinfo.KeyValue;
import java.util.HashMap;
import java.util.Map;

public class MyHashMap {
    public static void main (String[] args) {
        Map<String, Student> myHashMap = new HashMap<>();

        Student s1 = new Student("Paul", 34425);
        Student s2 = new Student("Pauline", 34484);
        Student s3 = new Student("Tina", 34424);
        Student s4 = new Student("Sven", 34424);

        myHashMap.put(s1.name, s1);
        myHashMap.put(s2.name, s2);
        myHashMap.put("Hallo Welt", s3);

        System.out.println("Pauls matrNumber: " + myHashMap.get("Paul").matrNumber);

        System.out.println(myHashMap.containsKey("Pauline"));

        Student halloStudent = myHashMap.get("Hallo Welt");
        System.out.println("Name: " + halloStudent.name + " (" + halloStudent.matrNumber + ")");
    }
}
