package hello2.hellospring2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication
public class HelloSpring2Application {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpring2Application.class, args);
	}

}
