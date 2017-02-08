package co.nontster;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Test
	public void customEncoder() {
		 
	     CustomPasswordEncoder customPasswordEncoder = new CustomPasswordEncoder();
	     String encoded = customPasswordEncoder.encode("custom_pass");
	 
	     logger.info("Custom encoded "+encoded);
	 }

}
