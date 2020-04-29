package com.epam.training.company.resource;

import com.epam.training.company.dto.ExampleDto;
import com.epam.training.company.resource.api.ExampleResourceApi;
import com.epam.training.company.service.ExampleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "/example/")
@RequiredArgsConstructor
public class ExampleResource implements ExampleResourceApi {

    private final ExampleService exampleService;

    @Override
    public ExampleDto save(@Valid ExampleDto exampleDto) {
        return exampleService.save(exampleDto);
    }
}
