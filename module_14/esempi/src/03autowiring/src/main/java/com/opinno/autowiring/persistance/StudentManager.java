import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class StudentManager {

    @Autowired
    private List<String> students2;

    public void printAllStudent(){
        System.out.println(students2);
    }
}
