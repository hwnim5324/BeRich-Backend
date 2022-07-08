package berich.service;

import berich.repository.JPAUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {
    private final JPAUserRepository jpauserrepository;

    @Autowired
    public SpringConfig(JPAUserRepository jpauserrepository){
        this.jpauserrepository = jpauserrepository;
    }

    @Bean
    public UserService userservice(){
        return new UserService(jpauserrepository);
    }

}
