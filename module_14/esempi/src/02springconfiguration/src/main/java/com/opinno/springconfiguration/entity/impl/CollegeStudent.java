import com.opinno.springconfiguration.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CollegeStudent implements Student {

    private int id;
    private String collegeCity;
    private int averageGrades;

    @Override
    public void printGradesExams() {
        System.out.println("College Student: " + id + " - " + averageGrades);
    }
}
