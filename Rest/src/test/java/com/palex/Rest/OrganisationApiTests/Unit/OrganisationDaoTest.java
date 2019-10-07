package com.palex.Rest.OrganisationApiTests.Unit;

import com.palex.Rest.dao.OrganisationDao;
import com.palex.Rest.dao.OrganisationDaoImpl;
import com.palex.Rest.model.OrganisationEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

//@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class OrganisationDaoTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private OrganisationDao organisationDao;

    @Test
    public void whenGetById(){
        OrganisationEntity organisationEntity = new OrganisationEntity("testName1", "testFullName1", "TestInn", "testKpp", "testAddress", "testPhone", true);
        em.persist(organisationEntity);
        em.flush();

        OrganisationEntity testOrganisationEntity = organisationDao.getById(organisationEntity.getId());

        assertEquals(organisationEntity.getFullName(), testOrganisationEntity.getFullName());



    }

}
