package io.pavan.comparing;

public class Student implements Comparable<Student>{
    private float marks;
    private int rollNo;

    public Student(float marks, int rollNo) {
        this.marks = marks;
        this.rollNo = rollNo;
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int)(this.marks- o.marks);
        // if diff == 0: means both are equal
        // if diff < 0: means o is bigger else o is smaller
        return diff;
    }
}
