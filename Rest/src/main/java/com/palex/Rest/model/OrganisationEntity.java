package com.palex.Rest.model;

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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * служебное поле Hibernate/
     */
    @Version
    @Column(name = "version")
    private Long version;

    /**
     * Наименование
     */
    @Column(name = "name")
    private String name;

    /**
     * Полное наименование.
     */
    @Column(name = "full_name")
    private String fullName;

    /**
     * ИНН.
     */
    @Column(name = "inn")
    private String inn;

    /**
     * КПП.
     */
    @Column(name = "kpp")
    private String kpp;

    /**
     * Адрес.
     */
    @Column(name = "address")
    private String address;

    /**
     * Телефон.
     */
    @Column(name = "phone")
    private String phone;

    /**
     * Статус.
     */
    @Column(name = "is_Active")
    private Boolean isActive;

    public Long getId() {
        return id;
    }

    public Long getVersion() {
        return version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean active) {
        isActive = active;
    }

    @Override
    public String toString() {
        return "OrganisationEntity{" +
                "id=" + id +
                ", version=" + version +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
