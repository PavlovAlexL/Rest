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

    /**
     * UUID.
     */
    @Getter
    @NotNull
    @Min(1)
    public Long id;

    /**
     * Наименование.
     */
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    public String name;

    /**
     * Полное наименование.
     */
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    public String fullName;

    /**
     * ИНН.
     */
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 10, max = 10)
    public String inn;

    /**
     * КПП.
     */
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 9, max = 9)
    public String kpp;

    /**
     * Адрес.
     */
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 50)
    public String address;

    /**
     * Телефон.
     */
    @Getter
    @Size(max = 20)
    public String phone;

    /**
     * Статус.
     */
    @Getter
    @Size(max = 5)
    public String isActive;

}
