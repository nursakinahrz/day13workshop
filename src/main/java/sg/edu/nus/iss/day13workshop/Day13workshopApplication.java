package sg.edu.nus.iss.day13workshop;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sg.edu.nus.iss.day13workshop.services.DatabaseService;

@SpringBootApplication
public class Day13workshopApplication implements ApplicationRunner {

	//autowired auto instanstiate 
	@Autowired
	DatabaseService dbSvc;

	public static void main(String[] args) {
		SpringApplication.run(Day13workshopApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		if (args.containsOption("dataDir")) {
			final String dataDir = args.getOptionValues("dataDir").get(0);
			dbSvc.setDataDir(new File(dataDir));

			if(!dbSvc.isDataDirValid()) {
				System.err.printf("%s does not exist, is not a directory or not writable.", dataDir);
				//if theres error you just exit the program.
				System.exit(-1);
			}

			System.out.printf("Using %s as data directory\n", dataDir);

		} else { 
			dbSvc.setDataDir(new File("./data"));

		}

	}

	

}
