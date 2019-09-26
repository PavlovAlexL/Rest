package com.palex.Rest.view.Organisation;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * View для валидации ввода на обновление Organisation.
 */

public class OrganisationUpdateFilterView {

    @NotNull
    @Min(1)
    public Long id;

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
    @Size(min = 10, max = 10)
    public String inn;

    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    public String kpp;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    public String address;

    @Size(max = 20)
    public String phone;

    //@Pattern(regexp = "(true|false)?")
    public Boolean isActive;

    public String getName() {
        return name;
    }

    public String getFullName() {
        return fullName;
    }

    public String getInn() {
        return inn;
    }

    public String getKpp() {
        return kpp;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public Long getId() {
        return id;
    }
}
