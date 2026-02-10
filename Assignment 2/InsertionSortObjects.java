class StudentObj {
    int rollNo;
    String name;
    int marks;

    StudentObj(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + marks);
    }
}

public class InsertionSortObjects {

    public static void insertionSort(StudentObj[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            StudentObj key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j].marks > key.marks) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        StudentObj[] students = {
            new StudentObj(1, "Amit", 85),
            new StudentObj(2, "Riya", 72),
            new StudentObj(3, "John", 90),
            new StudentObj(4, "Neha", 78)
        };

        insertionSort(students);

        for (StudentObj s : students) {
            s.display();
        }
    }
}
