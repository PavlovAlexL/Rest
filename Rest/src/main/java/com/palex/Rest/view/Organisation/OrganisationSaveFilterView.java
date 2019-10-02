package com.palex.Rest.view.Organisation;

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

    @Size(max = 20)
    public String phone;

    public String isActive;

}
