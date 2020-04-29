package com.epam.training.company.data;

import com.epam.training.company.dto.ExampleDto;
import com.epam.training.company.model.Example;

/**
 * Data for testing.
 */
public class TestData {

    public static final Long LONG_ID = 1L;

    public Example getExample() {
        return new Example()
                .setText("example");
    }

    public ExampleDto getExampleDto() {
        return new ExampleDto()
                .setText("example");
    }
}
