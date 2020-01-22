package br.com.jefferson.notebook;

import br.com.jefferson.notebook.domain.repository.ContactRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ContactControllerTest {

    @LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();
    HttpHeaders headers = new HttpHeaders();

    @Test
    public void testGetAllContact() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/v1/contact"), HttpMethod.GET, entity, String.class);
        String expected = "[{\"id\":\"5e2665d39493b721806f6d18\",\"name\":\"Jefferson\",\"description\":\"God guy\",\"fone\":\"975632335\",\"favorite\":1}]";
        Assertions.assertEquals(expected, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetContactByIdSucess() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/v1/contact/5e2665d39493b721806f6d18"), HttpMethod.GET, entity, String.class);
        String expected = "{\"id\":\"5e2665d39493b721806f6d18\",\"name\":\"Jefferson\",\"description\":\"God guy\",\"fone\":\"975632335\",\"favorite\":1}";
        Assertions.assertEquals(expected, response.getBody());
        Assertions.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetContactByIdFail() throws Exception {
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/api/v1/contact/5e2665d39493b721806f6d182"), HttpMethod.GET, entity, String.class);
        Assertions.assertEquals(null, response.getBody());
        Assertions.assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:8080" + uri;
    }
}
