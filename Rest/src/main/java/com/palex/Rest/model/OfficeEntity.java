package com.palex.Rest.model;

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
 * Сущность Office.
 */
@Entity
@Table(name = "Office")
public class OfficeEntity {

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

    @Getter
    @Setter
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn (name = "org_id", nullable = false)
    private OrganisationEntity orgId;

    /**
     * Наименование
     */
    @Getter
    @Setter
    @Column(name = "name")
    private String name;

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

    public OfficeEntity() {
    }
}
