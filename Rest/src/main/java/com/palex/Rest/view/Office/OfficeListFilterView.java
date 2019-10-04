package com.palex.Rest.view.Office;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Представление для валлидации списка Office.
 */

public class OfficeListFilterView {

    /**
     * Принадлежность к организации.
     */
    @Setter
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    public String orgId;

    /**
     * Наименование
    */
    @Getter
    @Size(min = 2, max = 20)
    public String name;

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

}
