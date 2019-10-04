package com.palex.Rest.view.Office;

import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление Office.
 */

public class OfficeUpdateFilterView {

    /**
     * UUID
     */
    @Getter
    @NotNull
    @Min(1)
    public Long id;

    /**
     * Наименование
     */
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    public String name;

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
