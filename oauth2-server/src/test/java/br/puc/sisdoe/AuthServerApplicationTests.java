package br.puc.sisdoe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ComponentScan
@EnableAutoConfiguration
//@EnableEurekaClient
@RunWith(SpringJUnit4ClassRunner.class)
public class AuthServerApplicationTests {

	@Test
	public void contextLoads() {
	}

}
