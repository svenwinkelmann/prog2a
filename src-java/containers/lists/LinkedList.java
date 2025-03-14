package containers.lists;

public class LinkedList
{
    public void printList(Student start)
    {
        while (start != null)
        {
            System.out.println(start.name + ": " + start.matrNumber);
            start = start.next;
        }
        System.out.print("\n");
    }

    public static void main(String[] args)
    {
        LinkedList myClass = new LinkedList();

        Student start = null;

        for (int i=5; i > 0; i--) {
            Student newOne = new Student("Name" + i, 111+i);
            newOne.next = start;
            start = newOne;
        }

        System.out.println("LinkedList of Students:");
        myClass.printList(start);

        // We add a new student at position 1
        Student newOne = new Student("Peter", 5344);
        newOne.next = start.next;
        start.next = newOne;

        System.out.println("LinkedList with added Student:");
        myClass.printList(start);
    }
}

