package vntg.api.user.msa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import vntg.api.user.msa.model.User;
import vntg.api.user.msa.repository.UserRepository;

@EnableDiscoveryClient
@SpringBootApplication
public class MsaUserApiApplication {

	@Autowired
	private UserRepository userRepo;

	@Bean
	public ResourceServerConfigurerAdapter resourceServerConfigurerAdapter() {
		return new ResourceServerConfigurerAdapter() {
			@Override
			public void configure(HttpSecurity http) throws Exception {
				http.headers().frameOptions().disable();
				http.authorizeRequests()
						.antMatchers("/").access("#oauth2.hasScope('read')")
						.anyRequest().authenticated();
			}
		};
	}
	@Bean
	public ApplicationRunner applicationRunner() {
		return args ->  {
			userRepo.save(new User(1, "Lee", "bh.lee@gmail.com"));
			userRepo.save(new User(2, "Park", "park@naver.com"));
			userRepo.save(new User(3, "Kim", "kim@daum.net"));
		};
	}
	public static void main(String[] args) {
		SpringApplication.run(MsaUserApiApplication.class, args);
	}
	
}
