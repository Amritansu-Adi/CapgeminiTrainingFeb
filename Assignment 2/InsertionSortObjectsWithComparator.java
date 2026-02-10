class StudentComp {
    int rollNo;
    String name;
    int subject1;
    int subject2;
    int subject3;

    StudentComp(int rollNo, String name, int subject1, int subject2, int subject3) {
        this.rollNo = rollNo;
        this.name = name;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
    }

    void display() {
        System.out.println(
            rollNo + " " + name +
            " | Sub1: " + subject1 +
            " Sub2: " + subject2 +
            " Sub3: " + subject3
        );
    }
}

public class InsertionSortObjectsWithComparator {

    static void insertionSort(StudentComp[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            StudentComp key = arr[i];
            int j = i - 1;

            while (j >= 0 && shouldSwap(arr[j], key)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    static boolean shouldSwap(StudentComp s1, StudentComp s2) {
        if (s1.subject1 > s2.subject1) return true;
        if (s1.subject1 < s2.subject1) return false;

        if (s1.subject2 > s2.subject2) return true;
        if (s1.subject2 < s2.subject2) return false;

        return s1.subject3 > s2.subject3;
    }

    public static void main(String[] args) {
        StudentComp[] students = {
            new StudentComp(1, "Amit", 80, 70, 60),
            new StudentComp(2, "Riya", 80, 70, 55),
            new StudentComp(3, "Neha", 75, 90, 85),
            new StudentComp(4, "Rahul", 80, 70, 90),
            new StudentComp(5, "John", 75, 60, 70)
        };

        insertionSort(students);

        for (StudentComp s : students) s.display();
    }
}
