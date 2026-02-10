class StudentObjS {
    int rollNo;
    String name;
    int marks;

    StudentObjS(int rollNo, String name, int marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }

    void display() {
        System.out.println(rollNo + " " + name + " " + marks);
    }
}

public class SelectionSortObjects {

    public static void selectionSort(StudentObjS[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j].marks < arr[minIdx].marks) {
                    minIdx = j;
                }
            }
            StudentObjS tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }

    public static void main(String[] args) {
        StudentObjS[] students = {
            new StudentObjS(1, "Amit", 85),
            new StudentObjS(2, "Riya", 72),
            new StudentObjS(3, "John", 90),
            new StudentObjS(4, "Neha", 78)
        };

        selectionSort(students);

        for (StudentObjS s : students) {
            s.display();
        }
    }
}
