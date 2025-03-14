package containers.lists;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Collection
{
    public void printStudents(List<Student> list)
    {
        for(Student s: list)
            System.out.println(s.name + ": " + s.matrNumber);
        System.out.print("\n");
    }

    public static void main(String[] args)
    {
        Collection myClass = new Collection();

        List<Student> studentAL = new ArrayList<Student>();
        List<Student> studentLL = new LinkedList<Student>();

        for (int i = 0; i < 5; i++)
        {
            Student newOne = new Student("Name" + i, 111+i);
            studentAL.add(newOne);
            studentLL.add(newOne);
        }

        myClass.printStudents(studentAL);
        myClass.printStudents(studentLL);

        System.out.println("studAL position1: " + studentAL.get(1).name);
        System.out.println("studLL position1: " + studentLL.get(1).name);
    }
}
