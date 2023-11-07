import com.opinno.autowiring.persistance.StudentManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class MyAppplicationListener implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    StudentManager studentManager;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        studentManager.printAllStudent();
    }
}
