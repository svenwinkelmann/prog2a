package containers.lists;

public class Student
{
    public String name;
    public int matrNumber;

    // used for linked list implementation
    public Student next;

    public Student() {};

    public Student(String name, int matrNumber)
    {
        this.name = name;
        this.matrNumber = matrNumber;
    }
}
