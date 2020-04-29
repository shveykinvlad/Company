package com.epam.training.company.service;

import static org.mockito.Mockito.when;

import com.epam.training.company.data.TestData;
import com.epam.training.company.dto.ExampleDto;
import com.epam.training.company.model.Example;
import com.epam.training.company.repository.ExampleRepository;
import ma.glasnost.orika.MapperFacade;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * Unit test for {@link ExampleService}.
 */
@ExtendWith(MockitoExtension.class)
class ExampleServiceTest {

    private final TestData data = new TestData();

    @InjectMocks
    private ExampleService exampleService;
    @Mock
    private MapperFacade mapperFacade;
    @Mock
    private ExampleRepository exampleRepository;

    @Test
    void save() {
        ExampleDto expected = data.getExampleDto()
                .setId(TestData.LONG_ID);
        Example exampleWithId = data.getExample()
                .setId(TestData.LONG_ID);

        when(mapperFacade.map(data.getExampleDto(), Example.class)).thenReturn(data.getExample());
        when(exampleRepository.save(data.getExample())).thenReturn(exampleWithId);
        when(mapperFacade.map(exampleWithId, ExampleDto.class)).thenReturn(expected);
        ExampleDto actual = exampleService.save(data.getExampleDto());

        Assertions.assertEquals(actual, expected);
    }
}