package br.com.rita.cloudparking.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ParkingDtoRequest {

    @NotBlank
    private String license;
    @NotBlank
    private String state;
    @NotBlank
    private String model;
    @NotBlank
    private String color;

}
