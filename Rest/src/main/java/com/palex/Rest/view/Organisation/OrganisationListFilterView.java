package com.palex.Rest.view.Organisation;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * RequestView для Organisation/list
 */

public class OrganisationListFilterView {

    @Setter
    @Getter
    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    public String name;

    @Getter
    @Size(max = 10)
    public String inn;

    @Getter
    @Size(max = 5)
    public String isActive;

    public void setInn(String inn) {
        if(inn != null || inn.length() == 0){
            this.inn = null;
        } else  if (!inn.matches("[0-9]{10}")){
            throw new RuntimeException("Not valid isActive string");
        } else this.inn = inn;
    }

    public void setIsActive(String isActive) {
        if(isActive == null || isActive.length() == 0){
            this.isActive = null;
        } else if(!isActive.matches("(true|false)")){
            throw new RuntimeException("Not valid isActive string");
        } else this.isActive = isActive;
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
