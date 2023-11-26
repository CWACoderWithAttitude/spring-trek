package io.github.cwacoderwithattitude.crud;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.Resource;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Autowired
	StudentRepository studentRepo;
	@Autowired
	ShipRepository shipRepository;

	// https://stackoverflow.com/questions/58703834/how-to-read-json-file-from-resources-in-spring-boot
	@Value("classpath:ships_defiant.json")
	Resource shipsFile;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {

		// initStudents();
		initShips();
	}

	private void initShips() {
		shipRepository.save(new Ship("USS Cerritos", "2", "California"));
		shipRepository.save(new Ship("USS Enterprise", "NCC-1701C", "Ambassador"));
		shipRepository.save(new Ship("USS Enterprise", "NCC-1701D", "Galaxy"));
		shipRepository.save(new Ship("USS Enterprise", "NCC-1701C", "Ambassador"));
		shipRepository.save(new Ship("USS Rhode Island", "3", "Nova"));
		shipRepository.save(new Ship("USS Defiant", "NX-74205", "Defiant"));
		shipRepository.save(new Ship("USS Discovery", "NCC-1031", "Crossfield"));
		shipRepository.save(new Ship("USS Excelsior", "NCC-2000", "Excelsior"));
		shipRepository.save(new Ship("USS Zheng He", "NCC-86505", "Inquiry"));
	}

	private void initStudents() {
		studentRepo.save(new Student("Sarah", "1"));
		studentRepo.save(new Student("Andrea", "2"));
		studentRepo.save(new Student("Brigitte", "3"));
		studentRepo.save(new Student("Volker", "4"));
		studentRepo.save(new Student("Johanna", "5"));
		studentRepo.save(new Student("Klaus", "6"));
		studentRepo.save(new Student("Larissa", "7"));
		studentRepo.save(new Student("Charly", "8"));
		studentRepo.save(new Student("Rega", "9"));
		studentRepo.save(new Student("Kerstin", "10"));
		studentRepo.save(new Student("Juli", "11"));

		for (Student student : studentRepo.findAll()) {
			System.out.print(student);
		}
	}
}
