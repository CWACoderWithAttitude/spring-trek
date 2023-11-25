package io.github.cwacoderwithattitude.crud;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.tomcat.util.buf.CharsetUtil;
import org.apache.tomcat.util.digester.DocumentProperties.Charset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.yaml.snakeyaml.reader.StreamReader;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Autowired
	StudentRepository shipRepo;
	@Autowired
	ShipRepository shipRepository;

	// https://stackoverflow.com/questions/58703834/how-to-read-json-file-from-resources-in-spring-boot
	@Value("classpath:ships_defiant.json")
	Resource shipsFile;

	@EventListener(ApplicationReadyEvent.class)
	public void runAfterStartup() {

		initStudents();
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
		shipRepo.save(new Student("Sarah", "1"));
		shipRepo.save(new Student("Andrea", "2"));
		shipRepo.save(new Student("Brigitte", "2"));
		shipRepo.save(new Student("Volker", "2"));
		shipRepo.save(new Student("Johanna", "2"));
		shipRepo.save(new Student("Klaus", "2"));
		shipRepo.save(new Student("Larissa", "2"));
		shipRepo.save(new Student("Charly", "2"));
		shipRepo.save(new Student("Rega", "2"));
		shipRepo.save(new Student("Kerstin", "2"));
		shipRepo.save(new Student("Juli", "2"));
		shipRepo.save(new Student("Eni", "2"));
		// shipRepo.save(new Ship("USS Cerritos", sign: "2", "California"));
		// shipRepo.save(new Ship("USS Enterprise", sign: "3", "Constitution"));
		// shipRepo.save(new Ship("USS T`Kumbra", "4", "Nebula"));
		for (Student student : shipRepo.findAll()) {
			System.out.print(student);
		}
	}
}
