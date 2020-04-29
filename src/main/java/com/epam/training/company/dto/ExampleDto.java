package com.epam.training.company.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@Accessors(chain = true)
public class ExampleDto {

    private Long id;

    private String text;

    private LocalDateTime creationTimestamp;
}
