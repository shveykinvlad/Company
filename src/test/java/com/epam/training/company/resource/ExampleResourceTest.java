package com.epam.training.company.resource;

import com.epam.training.company.IntegrationTest;
import com.epam.training.company.data.TestData;
import com.epam.training.company.dto.ExampleDto;
import com.epam.training.company.repository.ExampleRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

/**
 * Integration test for {@link ExampleResource}.
 */
@IntegrationTest
class ExampleResourceTest {

    private final TestData data = new TestData();
    @LocalServerPort
    private int port;
    @Autowired
    private TestRestTemplate restTemplate;
    @Autowired
    private ExampleRepository exampleRepository;

    private String getBasePath() {
        return "http://localhost:" + port + "/example/";
    }

    @AfterEach
    void tearDown() {
        exampleRepository.deleteAll();
    }

    @Test
    void save() {
        HttpHeaders httpHeaders = new HttpHeaders();
        HttpEntity<ExampleDto> httpEntity = new HttpEntity<>(data.getExampleDto(), httpHeaders);

        ResponseEntity<ExampleDto> response = restTemplate.postForEntity(getBasePath(), httpEntity, ExampleDto.class);
        Optional<Long> exampleId = Optional.of(response)
                .map(HttpEntity::getBody)
                .map(ExampleDto::getId);

        Assertions.assertTrue(exampleId.isPresent());
    }
}