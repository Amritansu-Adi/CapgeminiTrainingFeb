class Student {
    int rollNo;
    String name;
    int marks;

    Student(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + marks);
    }
}


public class BubbleSortObjects {

    public static void bubbleSort(Student[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j].marks > arr[j + 1].marks) {
                    
                    Student temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Student[] students = {
            new Student(1, "Amit", 85),
            new Student(2, "Riya", 72),
            new Student(3, "John", 90),
            new Student(4, "Neha", 78)
        };

        bubbleSort(students);

        for (Student s : students) {
            s.display();
        }
    }
}