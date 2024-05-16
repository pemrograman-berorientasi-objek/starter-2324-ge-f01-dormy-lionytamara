package pbo.f01.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity
@Table(name = "Dorms")
public class Dorm {
    @Id
    @Column(name = "name")
    private String name;

    @Column(name = "capacity")
    private int capacity;

    @Column(name = "gender")
    private String gender;

    @OneToMany(mappedBy = "dorm", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Student> students;

    public Dorm() {
        // Konstruktor tanpa argumen diperlukan oleh JPA
        this.students = new ArrayList<>();
    }

    public Dorm(String name, int capacity, String gender) {
        this.name = name;
        this.capacity = capacity;
        this.gender = gender;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getGender() {
        return gender;
    }

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student student) {
        if (students.size() < capacity && student.getGender().equals(gender)) {
            students.add(student);
            student.setDorm(this);  // Set the dorm for the student
            return true;
        }
        return false;
    }
}
