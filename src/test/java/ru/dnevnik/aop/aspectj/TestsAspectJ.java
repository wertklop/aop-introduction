package ru.dnevnik.aop.aspectj;

import com.eclipsesource.restfuse.*;
import com.eclipsesource.restfuse.annotation.Context;
import com.eclipsesource.restfuse.annotation.HttpTest;
import org.junit.Rule;
import org.junit.runner.RunWith;

import static com.eclipsesource.restfuse.Assert.assertNoContent;
import static com.eclipsesource.restfuse.Assert.assertOk;

/**
 * @author Kurbatov Gennadii
 * @since 01.11.15
 */
@RunWith(HttpJUnitRunner.class)
public class TestsAspectJ {

    @Rule
    public Destination destination = new Destination(this, "http://localhost:8080");

    @Context
    private Response response; // will be injected after every request

    @HttpTest(method = Method.GET, path = "/", type = MediaType.APPLICATION_JSON)
    public void indexTest() {
        assertOk(response);
    }

    @HttpTest(method = Method.GET, path = "/find?id=5", type = MediaType.APPLICATION_JSON)
    public void allGetTest() {
        assertOk(response);
    }

    @HttpTest(method = Method.GET, path = "/find?id=55", type = MediaType.APPLICATION_JSON)
    public void allGetTestNotFound() {
        assertNoContent(response);
    }
}
