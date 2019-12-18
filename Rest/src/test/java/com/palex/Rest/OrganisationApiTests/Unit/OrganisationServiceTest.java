package com.palex.Rest.OrganisationApiTests.Unit;

import com.palex.Rest.dao.OrganisationDao;
import com.palex.Rest.model.OrganisationEntity;
import com.palex.Rest.service.OrganisationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrganisationServiceTest {

    @MockBean
    private OrganisationDao organisationDao;
    @Autowired
    private OrganisationService organisationService;

    @Test
    public void testGetById(){
        //given(this.organisationDao.getById(any())).willReturn(new OrganisationEntity("testName", "testFullName", "TestInn", "testKpp", "testAddress", "testPhone", true));



    }

}
