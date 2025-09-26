package com.milan.RestAPIs.config;

import org.mapstruct.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapConfig {
    @Bean
    public ModelMapper modelmapper(){
        return new ModelMapper();
    }
}
