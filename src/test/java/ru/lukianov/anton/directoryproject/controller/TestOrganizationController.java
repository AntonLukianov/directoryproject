package ru.lukianov.anton.directoryproject.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import ru.lukianov.anton.directoryproject.Application;
import ru.lukianov.anton.directoryproject.view.OrganizationView;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
public class TestOrganizationController {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testOrganization1() throws Exception {
        mockMvc.perform(get("/organization/1")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.name").value("ПАО Сбербанк(МСК)"))
                .andExpect(jsonPath("$.fullName").value("Московский банк ПАО Сбербанк"))
                .andExpect(jsonPath("$.inn").value("7707083893"))
                .andExpect(jsonPath("$.kpp").value("773643001"))
                .andExpect(jsonPath("$.phone").value("+74955005550"))
                .andExpect(jsonPath("$.address").value("г. Москва, ул. Вавилова, д.19"));
    }



    @Test
    public void testOrganization2() throws Exception {
        mockMvc.perform(get("/organization/aa")).andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andExpect(jsonPath("$.message").value("Not found organization with id is aa"));
    }

    @Test
    public void testOfficeById() {
        RestTemplate restTemplate = new RestTemplate(new MockMvcClientHttpRequestFactory(mockMvc));
        OrganizationView organizationView1 = restTemplate.getForObject("/organization/1", OrganizationView.class);
        OrganizationView organizationView2 = new OrganizationView(1,"ПАО Сбербанк(МСК)", "Московский банк ПАО Сбербанк","7707083893","773643001", "+74955005550","г. Москва, ул. Вавилова, д.19", null);
        assertEquals(organizationView1, organizationView2);
        HttpHeaders headers = restTemplate.headForHeaders("/organization/1");
        assertTrue(headers.getContentType().includes(MediaType.APPLICATION_JSON));
    }



}
