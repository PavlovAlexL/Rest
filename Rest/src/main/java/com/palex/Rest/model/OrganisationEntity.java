package com.palex.Rest.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Сущность Organisation.
 */
@Entity
@Table(name = "Organisation")
public class OrganisationEntity {

    /**
     * UUID
     */
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * служебное поле Hibernate/
     */
    @Getter
    @Version
    @Column(name = "version")
    private Long version;

    /**
     * Наименование
     */
    @Getter
    @Setter
    @Column(name = "name")
    private String name;

    /**
     * Полное наименование.
     */
    @Getter
    @Setter
    @Column(name = "full_name")
    private String fullName;

    /**
     * ИНН.
     */
    @Getter
    @Setter
    @Column(name = "inn")
    private String inn;

    /**
     * КПП.
     */
    @Getter
    @Setter
    @Column(name = "kpp")
    private String kpp;

    /**
     * Адрес.
     */
    @Getter
    @Setter
    @Column(name = "address")
    private String address;

    /**
     * Телефон.
     */
    @Getter
    @Setter
    @Column(name = "phone")
    private String phone;

    /**
     * Статус.
     */
    @Getter
    @Setter
    @Column(name = "is_Active")
    private Boolean isActive;


}
