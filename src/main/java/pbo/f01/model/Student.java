package pbo.f01.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "entrance_year")
    private int entranceYear;

    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "dorm_name")
    private Dorm dorm;

    // Konstruktor tanpa argumen diperlukan oleh JPA
    public Student() {
    }

    public Student(String id, String name, int entranceYear, String gender) {
        this.id = id;
        this.name = name;
        this.entranceYear = entranceYear;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getEntranceYear() {
        return entranceYear;
    }

    public String getGender() {
        return gender;
    }

    public Dorm getDorm() {
        return dorm;
    }

    public void setDorm(Dorm dorm) {
        this.dorm = dorm;
    }
}
