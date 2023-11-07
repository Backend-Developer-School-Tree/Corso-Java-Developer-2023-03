import com.opinno.springconfiguration.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class HighSchoolStudent implements Student {

    private int id;
    private String schoolCity;
    private int averageGrades;

    @Override
    public void printGradesExams() {
        System.out.println("College Student: " + id + " - " + averageGrades);
    }

    public void customHighSchoolMethod() {
        System.out.println("Custom Method");
    }
}
