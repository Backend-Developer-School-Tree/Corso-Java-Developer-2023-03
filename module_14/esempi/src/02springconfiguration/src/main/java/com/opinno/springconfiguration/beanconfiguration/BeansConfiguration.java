import Student;
import CollegeStudent;
import com.opinno.springconfiguration.entity.impl.HIghSchoolStudent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/* Annotazione di classe per indicare che è una conf Spring. In questa classe definisco i bean
* che saranno gestiti dal contesto dell'applicazione */
@Configuration
public class BeansConfiguration {

    @Bean
    public Student collegeStudentNY(){
        return new CollegeStudent(0, "New York", 7);
    }

    @Bean
    public Student highSchoolStudentNY(){
        return new HIghSchoolStudent(42, "New York", 8);
    }
}