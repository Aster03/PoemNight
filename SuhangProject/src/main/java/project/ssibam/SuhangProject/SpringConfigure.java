package project.ssibam.SuhangProject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import project.ssibam.SuhangProject.repository.JPAPoemRepository;
import project.ssibam.SuhangProject.repository.PoemRepository;
import project.ssibam.SuhangProject.service.PoemService;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfigure {
    private EntityManager em;


    public SpringConfigure( EntityManager em) {
        this.em = em;
    }

    @Bean
    public PoemService poemService() { return new PoemService(poemRepository()); }

    @Bean
    public PoemRepository poemRepository() { return new JPAPoemRepository(em); }
}
