package global.coda.hospitalmanagement;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 * @author Vishal
 *
 */
@SpringBootApplication
@MapperScan("global.coda.hospitalmanagement.mapper")
public class HospitalManagementApplication {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(HospitalManagementApplication.class, args);
	}

}
