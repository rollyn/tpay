package com.tangerpay.model.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDto {

    @NotBlank(message = "Name is required")
    @Schema(defaultValue = "Tony Stark")
    private String name;

    @NotBlank(message = "Phone is required")
    @Pattern(regexp="(^$|[0-9]{8,10})", message = "Invalid Phone Number (ex. 0999999999)")
    @Schema(defaultValue = "0999999999")
    private String phone;
}
