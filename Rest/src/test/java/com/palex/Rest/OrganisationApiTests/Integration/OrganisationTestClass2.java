package com.palex.Rest.OrganisationApiTests.Integration;

import com.palex.Rest.RestApplication;
import com.palex.Rest.controller.OrganisationController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestApplication.class)
@AutoConfigureMockMvc
public class OrganisationTestClass2 {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext wac;
    @InjectMocks
    private OrganisationController controller;

    /**
     * При отправке корректного запроса, получаем код 200 и представление с данными.
     * @throws Exception
     */
    @Test
    public void whenValidDataInputWithSpecifyParametrListDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));
        jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"2222222222\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"name\":\"Test\",\"inn\":\"1111111111\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").isNotEmpty())
                .andExpect(jsonPath("$.data[0].name").isNotEmpty())
                .andExpect(jsonPath("$.data[0].isActive").isNotEmpty());
    }

    /**
     * При отправке не корректного запроса, получаем код 400, представление с ошибкой и данные не изменились.
     * @throws Exception
     */
    @Test
    public void whenUpdateInvalidRequiresDataInput_thenReturn400andErrorAndDataNotUpdated() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"id\":\"1\",\"name\":\"NewtestOrganisation\",\"fullName\":\"NewOOO TestOrganisation\",\"inn\":\"2222222222777\",\"kpp\":\"333333333\",\"address\":\"NewTestOrganisationAddress\"}";
        this.mockMvc.perform(post("/api/organisation/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("wrong input"));

        this.mockMvc.perform(get("/api/organisation/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.name").value("Test"))
                .andExpect(jsonPath("$.data.fullName").value("OOO TestOrganisation"))
                .andExpect(jsonPath("$.data.inn").value("1111111111"))
                .andExpect(jsonPath("$.data.kpp").value("999999999"))
                .andExpect(jsonPath("$.data.address").value("TestOrganisationAddress"))
                .andExpect(jsonPath("$.data.isActive").value("true"));
    }

    /**
     * При отправке не корректного запроса, получаем код 400, представление с ошибкой и данные не изменились.
     * @throws Exception
     */
    @Test
    public void whenUpdateInvalidNotRequiresDataInput_thenReturn400andErrorAndDataNotUpdated() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"id\":\"1\",\"name\":\"NewtestOrganisation\",\"fullName\":\"NewOOO TestOrganisation\",\"inn\":\"2222222222\",\"kpp\":\"333333333\",\"address\":\"NewTestOrganisationAddress\",\"phone\":\"+7985000000000000000000\",\"isActive\":\"false\"}";
        this.mockMvc.perform(post("/api/organisation/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("wrong input"));

        this.mockMvc.perform(get("/api/organisation/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.name").value("Test"))
                .andExpect(jsonPath("$.data.fullName").value("OOO TestOrganisation"))
                .andExpect(jsonPath("$.data.inn").value("1111111111"))
                .andExpect(jsonPath("$.data.kpp").value("999999999"))
                .andExpect(jsonPath("$.data.address").value("TestOrganisationAddress"))
                .andExpect(jsonPath("$.data.isActive").value("true"));
    }

    /**
     * При отправке корректного запроса на множественные данные, получаем код 200, представление с данными.
     * @throws Exception
     */
    @Test
    public void whenValidMultipleListRequiredDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));
        jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"2222222222\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"name\":\"Test\",\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[0].id").value("1"))
                .andExpect(jsonPath("$.data[0].name").value("Test"))
                .andExpect(jsonPath("$.data[0].isActive").value("true"))
                .andExpect(jsonPath("$.data[1].id").value("2"))
                .andExpect(jsonPath("$.data[1].name").value("Test"))
                .andExpect(jsonPath("$.data[1].isActive").value("true"));
    }

    /**
     * При отправке корректного запроса, получаем код 200, представление с успешной операцией, данные изменились.
     * @throws Exception
     */
    @Test
    public void whenUpdateValidAllDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"id\":\"1\",\"name\":\"NewtestOrganisation\",\"fullName\":\"NewOOO TestOrganisation\",\"inn\":\"2222222222\",\"kpp\":\"333333333\",\"address\":\"NewTestOrganisationAddress\",\"phone\":\"+79850000000\",\"isActive\":\"false\"}";
        this.mockMvc.perform(post("/api/organisation/update").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result").value("success"));

        this.mockMvc.perform(get("/api/organisation/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").value("1"))
                .andExpect(jsonPath("$.data.name").value("NewtestOrganisation"))
                .andExpect(jsonPath("$.data.fullName").value("NewOOO TestOrganisation"))
                .andExpect(jsonPath("$.data.inn").value("2222222222"))
                .andExpect(jsonPath("$.data.kpp").value("333333333"))
                .andExpect(jsonPath("$.data.address").value("NewTestOrganisationAddress"))
                .andExpect(jsonPath("$.data.isActive").value("false"));
    }




}
