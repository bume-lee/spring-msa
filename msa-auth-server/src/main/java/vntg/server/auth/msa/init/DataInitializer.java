package vntg.server.auth.msa.init;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import vntg.server.auth.msa.security.User;

import javax.annotation.Resource;
import java.util.Date;

/**
 * H2 초기계정 세팅
 */
@Component
public class DataInitializer implements ApplicationRunner {

    @Resource(name = "UserDao")
    private vntg.server.auth.msa.security.UserDao UserDao;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        User newUser = new User();
        PasswordEncoder passwordEncoder;
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        newUser.setUsername("tiger");
        newUser.setPassword(passwordEncoder.encode("1234"));
        newUser.setUserType(0);
        newUser.setDate(new Date());
        UserDao.save(newUser);
    }

}
