package me.connan.springbootdeveloper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@Autowired
	private WebApplicationContext context;

	@Autowired
	private ObjectMapper objectMapper;

	@BeforeEach
	void mockMvcSetUp() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}

	@DisplayName("quiz(): GET /quiz?code=1 이면 응답코드는 201, 응답 본문은 Created!를 리턴한다.")
	@Test
	void getQuiz1() throws Exception {

	}

	@DisplayName("quiz(): GET /quiz?code=2 이면 응답코드는 400, 응답 본문은 Bad Request!를 리턴한다.")
	@Test
	void getQuiz2() throws Exception {

	}
}
