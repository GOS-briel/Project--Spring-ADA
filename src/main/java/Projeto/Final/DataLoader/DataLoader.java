package Projeto.Final.DataLoader;

import Projeto.Final.Model.FilmeModel;
import Projeto.Final.Repository.FilmeRepository;
import org.aspectj.apache.bcel.util.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class DataLoader   {

    @Autowired
    private FilmeRepository filmeRepository;

    public DataLoader(FilmeRepository filmeRepository) {
        this.filmeRepository = filmeRepository;
    }

    @Bean
  public CommandLineRunner loadData(FilmeRepository REPOSITORY) {
        return args -> {
            if (REPOSITORY.count() == 0) {
                REPOSITORY.save(new FilmeModel(1L,"O Senhor dos Anéis: A Sociedade do Anel","Mark" , "2001", "Fantasia"));
            }

};
    }


}
