import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean
    public List<String> students() {
        List<String> studentList = new ArrayList<>();

        studentList.add("Davide");
        studentList.add("Anna");

        return studentList;
    }

    @Bean
    public List<String> students2() {
        List<String> studentList = new ArrayList<>();

        studentList.add("Davide 2");
        studentList.add("Anna 2");

        return studentList;
    }
}
