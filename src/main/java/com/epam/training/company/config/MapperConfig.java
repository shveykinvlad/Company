package com.epam.training.company.config;

import com.epam.training.company.dto.ExampleDto;
import com.epam.training.company.model.Example;
import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;
import net.rakugakibox.spring.boot.orika.OrikaMapperFactoryConfigurer;
import org.springframework.context.annotation.Configuration;

/**
 * Mapper configuration from Entity to Dto.
 */
@Configuration
public class MapperConfig implements OrikaMapperFactoryConfigurer {

    @Override
    public void configure(MapperFactory mapperFactory) {
        mapperFactory.classMap(Example.class, ExampleDto.class)
                // Mapping without logic
                .field("", "")
                .customize(new CustomMapper<Example, ExampleDto>() {
                    @Override
                    public void mapAtoB(Example example, ExampleDto exampleDto, MappingContext context) {
                        // Mapping with logic
                        super.mapAtoB(example, exampleDto, context);
                    }
                })
                .byDefault()
                .register();
    }
}
