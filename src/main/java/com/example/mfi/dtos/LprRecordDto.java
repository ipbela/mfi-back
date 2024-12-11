package com.example.mfi.dtos;

import jakarta.validation.constraints.NotBlank;

public record LprRecordDto(@NotBlank String produto, @NotBlank String norma, @NotBlank String molde) {
}
