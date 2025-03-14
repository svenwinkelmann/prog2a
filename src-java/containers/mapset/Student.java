package containers.mapset;

import java.util.Objects;

public class Student {

    public String name;
    public int matrNumber;

    public Student(String name, int matrNumber)
    {
        this.name = name;
        this.matrNumber = matrNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (getClass() == obj.getClass()) {
            Student student = (Student) obj;
            return student.matrNumber == this.matrNumber;
        }
        else
            return false;
    }

    @Override
    public int hashCode() {
        return name.length();
    }

}
