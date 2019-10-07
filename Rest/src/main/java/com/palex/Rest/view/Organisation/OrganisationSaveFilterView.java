package com.palex.Rest.view.Organisation;

import lombok.Getter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * RequestView для валидации ввода на сохранение Organisation.
 */

public class OrganisationSaveFilterView {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    public String name;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    public String fullName;

    @NotNull
    @NotBlank
    @Pattern(regexp = "([0-9]{10})?")
    public String inn;

    @NotNull
    @NotBlank
    @Pattern(regexp = "([0-9]{9})?")
    public String kpp;

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

    public void setPhone(String phone) {
        if (phone != null & phone.length() == 0) {
            this.phone = null;
        } else if (phone.matches("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$")) {
            this.phone = phone;
        } else throw new RuntimeException("Not valid phone string");
    }

    public void setIsActive(String isActive) {
        if(isActive == null || isActive.length() == 0){
            this.isActive = null;
        } else if(!isActive.matches("(true|false)")){
            throw new RuntimeException("Not valid isActive string");
        } else this.isActive = isActive;
    }

    public OrganisationSaveFilterView() {
    }

    public OrganisationSaveFilterView(@NotNull @NotBlank @Size(min = 2, max = 20) String name, @NotNull @NotBlank @Size(min = 2, max = 50) String fullName, @NotNull @NotBlank @Pattern(regexp = "([0-9]{10})?") String inn, @NotNull @NotBlank @Pattern(regexp = "([0-9]{9})?") String kpp, @NotNull @NotBlank @Size(min = 2, max = 50) String address, @Size(max = 20) String phone, @Size(max = 5) String isActive) {
        this.name = name;
        this.fullName = fullName;
        this.inn = inn;
        this.kpp = kpp;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }

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
