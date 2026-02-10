class StudentCompS {
    int rollNo;
    String name;
    int subject1;
    int subject2;
    int subject3;

    StudentCompS(int rollNo, String name, int subject1, int subject2, int subject3) {
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

public class SelectionSortObjectsWithComparator {

    static void selectionSort(StudentCompS[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (shouldSwap(arr[minIdx], arr[j])) {
                    minIdx = j;
                }
            }
            StudentCompS tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }

    static boolean shouldSwap(StudentCompS s1, StudentCompS s2) {
        if (s1.subject1 > s2.subject1) return true;
        if (s1.subject1 < s2.subject1) return false;

        if (s1.subject2 > s2.subject2) return true;
        if (s1.subject2 < s2.subject2) return false;

        return s1.subject3 > s2.subject3;
    }

    public static void main(String[] args) {
        StudentCompS[] students = {
            new StudentCompS(1, "Amit", 80, 70, 60),
            new StudentCompS(2, "Riya", 80, 70, 55),
            new StudentCompS(3, "Neha", 75, 90, 85),
            new StudentCompS(4, "Rahul", 80, 70, 90),
            new StudentCompS(5, "John", 75, 60, 70)
        };

        selectionSort(students);

        for (StudentCompS s : students) s.display();
    }
}
