package com.palex.Rest.view.Office;

import com.palex.Rest.model.OrganisationEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Представление Office.
 */

public class OfficeView {

    /**
     * UUID
     */
    public Long id;

    /**
     * Наименование
     */
    public String name;

    /**
     * Адрес.
     */
    public String address;

    /**
     * Телефон.
     */
    public String phone;

    /**
     * Статус.
     */
    public Boolean isActive;

}
