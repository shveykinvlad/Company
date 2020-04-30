package com.epam.training.company.resource.api;

import com.epam.training.company.dto.ExampleDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.Valid;

public interface ExampleResourceApi {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ExampleDto save(@RequestBody @Valid ExampleDto exampleDto);
}
