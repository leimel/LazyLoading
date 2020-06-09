package co.com.magudel.jpa.config;


import co.com.magudel.jpa.repository.TraceabilityAdapter;
import co.com.magudel.jpa.repository.TraceabilityRepositoryJpa;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Date;

@Configuration
@ComponentScan(basePackages ="co.com.magudel.jpa.repository")
@EnableJpaRepositories(basePackages = "co.com.magudel.jpa.repository")
@EntityScan(basePackages = "co.com.magudel.jpa.entity")
public class JpaRepositoryConfiguration {

    public JpaRepositoryConfiguration() {
        //log.info("TaskJpaRepositoryConfiguration INIT....");
    }



    @Bean
    public TraceabilityAdapter traceabilityAdapter(final TraceabilityRepositoryJpa traceabilityRepositoryJpa, final ModelMapper modelMapper){
        return new TraceabilityAdapter(traceabilityRepositoryJpa, modelMapper);
    }

    @Bean
    public ModelMapper modelMapper() {
        final ModelMapper modelMapper = new ModelMapper();
        modelMapper.addConverter(this.dateToLong());
        modelMapper.addConverter(this.longToDate());
        return modelMapper;
    }

    private Converter<Date, Long> dateToLong() {
        return context -> context.getSource().getTime();
    }

    private Converter<Long, Date> longToDate() {
        return context -> new Date(context.getSource());
    }


}
