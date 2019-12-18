package com.palex.Rest.OrganisationApiTests.Integration;

import com.palex.Rest.RestApplication;
import com.palex.Rest.controller.OrganisationController;
import com.palex.Rest.view.Organisation.OrganisationSaveFilterView;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
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
public class OrganisationTestClass {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    WebApplicationContext wac;
    @InjectMocks
    private OrganisationController controller;

    /**
     * При отправке пустоко тела запроса, получаем ошибку.
     * @throws Exception
     */
    @Test
    public void whenSaveNoBodyDataInput_thenReturn400AndError() throws Exception {
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Required request body is missing"));
    }

    /**
     * При отправке корректных данных на сохранение, получаем статус 200 и представление успешной операции.
     * @throws Exception
     */
    @Test
    public void whenSaveValidAllDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result").value("success"));
    }

    /**
     * При отправке не корректных не обязательных данных, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenSaveInvalidNotRequiresData_Phone_Input_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"123\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("JSON parse error"));
    }


    /**
     * При отправке не корректных не обязательных данных, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenSaveInvalidNotRequiresData_IsActive_Input_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79857777777\",\"isActive\":\"123\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("JSON parse error"));
    }


    /**
     * При отправке корректных обязательных данных, получаем код 2000 и представление успеха.
     * @throws Exception
     */
    @Test
    public void whenSaveOnlyValidRequiresDataInput_thenReturn200andResultSuccess() throws Exception {

        String jsonString = "{\"name\":\"testOrganisation\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.result").value("success"));
    }


    /**
     * При отправке не корректных обязательных данных, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenSaveInvalidRequiesDataInput_name_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("wrong input"));
    }

    /**
     * При отправке не корректных обязательных данных, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenSaveInvalidRequiesDataInput_fullName_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"Test\",\"fullName\":\"\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("wrong input"));
    }


    /**
     * При отправке не корректных обязательных данных, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenSaveInvalidRequiesDataInput_inn_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"111111111100000000000000000\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("wrong input"));
    }


    /**
     * При отправке не корректных обязательных данных, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenSaveInvalidRequiesDataInput_kpp_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"99999999900000\",\"address\":\"TestOrganisationAddress\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("wrong input"));
    }


    /**
     * При отправке не корректных обязательных данных, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenSaveInvalidRequiesDataInput_address_thenReturn400andError() throws Exception {

        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"99999999900000\",\"address\":\"2\",\"phone\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("wrong input"));
    }


    /**
     * При отправке корректного запроса, получаем код 200 и представление с данными.
     * @throws Exception
     */
    @Test
    public void whenGetIdValidInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        this.mockMvc.perform(get("/api/organisation/1").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data.id").isNotEmpty())
                .andExpect(jsonPath("$.data.name").isNotEmpty())
                .andExpect(jsonPath("$.data.fullName").isNotEmpty())
                .andExpect(jsonPath("$.data.inn").isNotEmpty())
                .andExpect(jsonPath("$.data.kpp").isNotEmpty())
                .andExpect(jsonPath("$.data.address").isNotEmpty())
                .andExpect(jsonPath("$.data.isActive").isNotEmpty());
    }

    /**
     * При отправке корректного запроса, получаем код 200 и представление с отсутсьвущими данными.
     * @throws Exception
     */
    @Test
    public void whenGetNotExistingDataInput_thenReturn200andResultNull() throws Exception {
        this.mockMvc.perform(get("/api/organisation/100").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data").isEmpty());
    }

    /**
     * При отправке не корректного запроса, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenListNoBodyDataInput_thenReturn400AndError() throws Exception {
        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Required request body is missing"));
    }


    /**
     * При отправке корректного запроса, получаем код 200 и представление с данными.
     * @throws Exception
     */
    @Test
    public void whenValidListRequiredDataInput_thenReturn200andResultSuccess() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        jsonString = "{\"name\":\"Test\",\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data[*].id").isNotEmpty())
                .andExpect(jsonPath("$.data[*].name").isNotEmpty())
                .andExpect(jsonPath("$.data[*].isActive").isNotEmpty());
    }


    /**
     * При отправке корректного запроса, получаем код 200 и представление с отсутствующими данными.
     * @throws Exception
     */
    @Test
    public void whenValidNotExistingListDataInput_thenReturn200andResultSuccessAndEmptyData() throws Exception {

        String jsonString = "{\"name\":\"HPE\",\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.data").isEmpty());
    }


    /**
     * При отправке корректного запроса, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenInvalidListRequiredDataInput_thenReturn400andError() throws Exception {
        String jsonString = "{\"name\":\"\",\"inn\":\"\",\"isActive\":\"\"}";

        this.mockMvc.perform(post("/api/organisation/list").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonString))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("wrong input"));
    }

    /**
     * При отправке корректного запроса, получаем код 400 и представление с ошибкой.
     * @throws Exception
     */
    @Test
    public void whenUpdateNoBodyDataInput_thenReturn400AndError() throws Exception {
        String jsonString = "{\"name\":\"Test\",\"fullName\":\"OOO TestOrganisation\",\"inn\":\"1111111111\",\"kpp\":\"999999999\",\"address\":\"TestOrganisationAddress\",\"phone\":\"+79852053969\",\"isActive\":\"true\"}";
        this.mockMvc.perform(post("/api/organisation/save").contentType(MediaType.APPLICATION_JSON_UTF8).content(jsonString));

        this.mockMvc.perform(post("/api/organisation/update").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().is4xxClientError())
                .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$.error").value("Required request body is missing"));
    }

}
