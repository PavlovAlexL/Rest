package com.palex.Rest.view.Organisation;

import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * RequestView для валидации ввода на обновление Organisation.
 */

public class OrganisationUpdateFilterView {

    @Getter
    @NotNull
    @Min(1)
    public String id;

    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    public String name;

    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    public String fullName;

    @Getter
    @NotNull
    @NotBlank
    @Size(min = 10, max = 10)
    public String inn;

    @Getter
    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    public String kpp;

    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    public String address;

    @Getter
    @Size(max = 20)
    public String phone;

    @Getter
    @Size(max = 5)
    public String isActive;

    @Override
    public String toString() {
        try {
            return new com.fasterxml.jackson.databind.ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
        } catch (com.fasterxml.jackson.core.JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
