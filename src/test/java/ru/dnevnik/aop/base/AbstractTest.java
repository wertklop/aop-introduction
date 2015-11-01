package ru.dnevnik.aop.base;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import ru.dnevnik.aop.configuration.WebConfig;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public abstract class AbstractTest {

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
    public void allGetTest() throws Exception {
        mockMvc.perform(get("/find").param("id", "5"))
                .andExpect(status().isOk());

        mockMvc.perform(get("/find").param("id", "55"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void anonymousPost() throws Exception {
        mockMvc.perform(post("/put").param("id", "51").param("name", "My Piter"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void anonymousDelete() throws Exception {
        mockMvc.perform(delete("/get").param("id", "50"))
                .andExpect(status().isForbidden());
    }

    @Test
    public void authenticatedPost() throws Exception {
        mockMvc.perform(post("/put").param("id", "51").param("name", "My Piter").param("user", "TestUser"))
                .andExpect(status().isOk());
    }

    @Test
    public void authenticatedDelete() throws Exception {
        mockMvc.perform(delete("/get").param("id", "50").param("user", "TestUser"))
                .andExpect(status().isOk());
    }
}
