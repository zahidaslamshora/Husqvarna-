package com.Husqvarna.assignment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class AssignmentWelcomeControllerTests {

	 @Autowired
	    private MockMvc mockMvc;

	    @BeforeEach
	    void setUp() {
	    }

	    @Test
	    void testWelcomePage() throws Exception {
	        mockMvc.perform(MockMvcRequestBuilders.get("/welcome"))
	               .andExpect(MockMvcResultMatchers.status().isOk());
	    }
}
