package MODULETWO.ONE.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeConfig {

    @Bean
    public ModelMapper modelmapper(){
        return new ModelMapper();
    }
}
