package com.ll.exam.app10;

import com.ll.exam.app10.app.home.controller.HomeController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@Transactional
@AutoConfigureMockMvc
class App10ApplicationTests {

	@Autowired
	private MockMvc mvc;
	@Test
	@DisplayName("메인화면에서 안녕 출력")
	void t1() throws Exception {
		ResultActions resultActions = mvc.perform(get("/"))
				.andDo(print());

		resultActions
				.andExpect(status().is2xxSuccessful())
				.andExpect(handler().handlerType(HomeController.class))
				.andExpect(handler().methodName("main"))
				.andExpect(content().string(containsString("안녕")));
	}

}
