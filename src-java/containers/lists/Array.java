package containers.lists;

public class Array
{
    public void printArray(Student[] array)
    {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i].name + ": " + array[i].matrNumber);
        }
        System.out.print("\n");
    }

    public static void main(String[] args)
    {
        Array myClass = new Array();

        Student[] arrayOfStudents = new Student[3];

        for (int i = 0; i < 3; i++)
            arrayOfStudents[i] = new Student();

        System.out.println("Array of instantiated students:");
        myClass.printArray(arrayOfStudents);

        arrayOfStudents[0].name = "Hans";
        arrayOfStudents[0].matrNumber = 1234;

        arrayOfStudents[1].name = "Paula";
        arrayOfStudents[1].matrNumber = 4532;

        arrayOfStudents[2].name = "Ina";
        arrayOfStudents[2].matrNumber = 3421;

        System.out.println("arrayOfStudents:");
        myClass.printArray(arrayOfStudents);

        // We add a new student at position 1. As the size of arrays
        // cannot be changed dynamically in Java, we need to create an
        // array with size of n+1 and copy the values.
        Student newStudent = new Student("Peter", 5344);

        Student[] newArrayOfStudents = new Student[arrayOfStudents.length+1];
        newArrayOfStudents[0] = arrayOfStudents[0];
        newArrayOfStudents[1] = newStudent;
        newArrayOfStudents[2] = arrayOfStudents[1];
        newArrayOfStudents[3] = arrayOfStudents[2];

        System.out.println("newArrayOfStudents:");
        myClass.printArray(newArrayOfStudents);

        // Delete student, garbage collection is called automatically
        for (int i = arrayOfStudents.length - 1; i >= 0; i--)
            arrayOfStudents[i] = null;
    }
}