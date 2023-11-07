import com.opinno.springconfiguration.beanconfiguration.BeansConfiguration;
import Student;
import HighSchoolStudent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
* Questa classe è l'entry point del progetto come applicazione Spring Boot
* @SpringBootApplication --> Combina diverse annotation in un punto solo
* Questa annotazione ci avvia l'applicazione e configura automaticamente diversi aspetti dell'applicazione
* (Gestione dei bean, auto configurazione, scan dei componenti)
* */
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);

		/*
		* AnnotationConfigApplicationContext è una classe fornita da SPring e viene utilizzata per creare
		* un contesto di applicazione basato su annotazioni a partire da una o più classi di configurazione
		* annotate con @Configuration (E @Bean per i bean)
		* */
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(BeansConfiguration.class);
		HighSchoolStudent hsNY = (HighSchoolStudent) ctx.getBean("highSchoolStudentNY"); //nome del bean
		hsNY.printGradesExams();
		//hsNY.customHighSchoolMethod(); ricorda non posso farlo perchè è metodo non in Student


		Student hsNY_student = (Student) ctx.getBean("highSchoolStudentNY"); //nome del bean
		hsNY_student.printGradesExams();
		//hsNY_student.customHighSchoolMethod(); ricorda non posso farlo perchè è metodo non in Student



	}

}
