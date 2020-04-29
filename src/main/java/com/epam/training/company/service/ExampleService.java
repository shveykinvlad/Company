package com.epam.training.company.service;

import com.epam.training.company.dto.ExampleDto;
import com.epam.training.company.model.Example;
import com.epam.training.company.repository.ExampleRepository;
import lombok.RequiredArgsConstructor;
import ma.glasnost.orika.MapperFacade;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExampleService {

    private final ExampleRepository exampleRepository;
    private final MapperFacade mapperFacade;

    public ExampleDto save(ExampleDto exampleDto) {
        Example example = mapperFacade.map(exampleDto, Example.class);
        example = exampleRepository.save(example);

        return mapperFacade.map(example, ExampleDto.class);
    }
}
