package com.palex.Rest.view.Organisation;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * RequestView для Organisation/list
 */

public class OrganisationListFilterView {

    @NotNull
    @NotBlank
    @Size(min = 2, max = 20)
    public String name;

    @Size(max = 10)
    public String inn;

    public String isActive;

    public String getName() {
        return name;
    }

    public String getInn() {
        return inn;
    }

    public String getIsActive() {
        return isActive;
    }
}
