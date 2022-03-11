package org.pedrograciabernal.serverless.simple.function;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureJsonTesters
public class CityFunctionTest {

	@Autowired
	private MockMvc mockMvc;

	private JacksonTester<CityDataRequest> json;

	@Rule
	public EnvironmentVariables environmentVariables = new EnvironmentVariables();

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
		environmentVariables.set("RESOURCE_URL", "https://weatherdbi.herokuapp.com/");
		environmentVariables.set("RESOURCE_CONTEXT", "data/weather/");
	}

	@Test
	public void weatherCityTest() throws Exception {
		CityDataRequest city = new CityDataRequest();
		city.setCityName("zaragoza");

		MvcResult result = mockMvc.perform(post("/city")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json.write(city).getJson())
		).andReturn();

		String content = result.getResponse().getContentAsString();

		mockMvc.perform(asyncDispatch(result))
				.andExpect(status().isOk());
	}
}
