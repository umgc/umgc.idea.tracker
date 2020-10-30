






import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ProjectTrackerTest;
import com.example.projecttracker.controller.ProjectController;
import com.example.projecttracker.model.Project;

public class CreateFaqTest extends ProjectTrackerTest{
	
	
	@Autowired
	private WebApplicationContext   webApplicationContext;
	
	private MockMvc  mockMvc;
	
	
	@Before
	public void setup() {
		
		 mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		
	}
	

	

	@Test
	@Rollback(false)
	public void testProject() throws Exception {
		
		mockMvc.perform(get("/faq")).andExpect(status().isOk())
		.andExpect(content().contentType("application/json"))
		.andExpect(jsonPath("$.id").value(1)).andExpect(jsonPath("$.faqQuestion").value("Good")).andExpect(jsonPath("$.faqAnswer").value("Yes"))
		
		
		;
	
		
	}
}