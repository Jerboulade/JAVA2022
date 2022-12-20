package be.technifutur.decouverte.testRecord;

import be.technifutur.decouverte.collection.data.Personne;
import be.technifutur.decouverte.testEnum.JourSemaine;

import java.util.Objects;

public class Lesson {
    private final JourSemaine j;
    private final String label;
    private final Personne teacher;

    public Lesson(JourSemaine j, String label, Personne teacher) {
        this.j = j;
        this.label = label;
        this.teacher = teacher;
    }

    public JourSemaine getJ() {
        return j;
    }

    public String getLabel() {
        return label;
    }

    public Personne getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "testRecord{" +
                "j=" + j +
                ", label='" + label + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lesson that = (Lesson) o;
        return j == that.j && Objects.equals(label, that.label) && Objects.equals(teacher, that.teacher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(j, label, teacher);
    }
}
