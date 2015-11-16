package ru.dnevnik.aop.spring;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.dnevnik.aop.configuration.WebConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
public class TestsSpring {

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void indexTest() throws Exception {
        mockMvc.perform(get("/")).andExpect(status().isOk());
    }

    @Test
    public void anonymousPost() throws Exception {
        mockMvc.perform(post("/put").param("id", "51").param("name", "This is Piter, babe"))
                .andExpect(status().isOk());
    }

    @Test
    public void anonymousDelete() throws Exception {
        mockMvc.perform(delete("/get").param("id", "50"))
                .andExpect(status().isNoContent());
    }
}
