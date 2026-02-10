class StudentS {
    int rollNo;
    String name;
    int[] subjects;

    StudentS(int rollNo, String name, int[] subjects) {
        this.rollNo = rollNo;
        this.name = name;
        this.subjects = subjects;
    }

    void display() {
        System.out.println(
            rollNo + " " + name +
            " | " + subjects[0] +
            " " + subjects[1] +
            " " + subjects[2]
        );
    }
}

public class SelectionSortComparatorLoop {

    static void selectionSort(StudentS[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (compare(arr[j], arr[minIdx]) < 0) {
                    minIdx = j;
                }
            }
            StudentS temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    static int compare(StudentS s1, StudentS s2) {
        for (int i = 0; i < s1.subjects.length; i++) {
            if (s1.subjects[i] > s2.subjects[i]) return 1;
            if (s1.subjects[i] < s2.subjects[i]) return -1;
        }
        return 0;
    }

    public static void main(String[] args) {
        StudentS[] students = {
            new StudentS(1, "Amit",  new int[]{80, 70, 60}),
            new StudentS(2, "Riya",  new int[]{80, 70, 55}),
            new StudentS(3, "Neha",  new int[]{75, 90, 85}),
            new StudentS(4, "Rahul", new int[]{80, 70, 90}),
            new StudentS(5, "John",  new int[]{75, 60, 70})
        };

        selectionSort(students);

        for (StudentS s : students) {
            s.display();
        }
    }
}
