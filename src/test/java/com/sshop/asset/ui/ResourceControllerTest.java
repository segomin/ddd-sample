package com.sshop.asset.ui;

//import com.google.gson.Gson;

import com.google.gson.Gson;
import com.sshop.asset.command.application.resource.CreateDatabaseRequest;
import com.sshop.asset.command.application.SimpleRequest;
import com.sshop.asset.command.domain.resource.SomeData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest (ResourceController.class)
class ResourceControllerTest {
	@Autowired
	MockMvc mvc;


	@Test
	void createDatabase() throws Exception {
		CreateDatabaseRequest request = new CreateDatabaseRequest("C1", "me", "MySQL", List.of("1", "2", "3"), new SomeData(10, "value"));
		Gson gson = new Gson();
		String content = gson.toJson(request);

		var rep = mvc.perform(post("/api/cmp/v1/work/resources/db")
							 .contentType(MediaType.APPLICATION_JSON)
							 .content(content))
					 .andExpect(status().isOk())
					 .andExpect(jsonPath("$.id").value("id"))
					 .andExpect(jsonPath("$.name").value("me"))
					 .andExpect(jsonPath("$.data.imageName").value("MySQL"))
//					 .andExpect(jsonPath("$.data.someList").value(List.of("1", "2", "3")))
					 .andReturn();

		Assertions.assertEquals(rep.getResponse().getContentAsString(), content);
	}

	@Test
	void createDatabaseUsingParent() throws Exception {
		CreateDatabaseRequest request = new CreateDatabaseRequest("C1", "me", "MySQL", List.of("1", "2", "3"), new SomeData(10, "value"));
		Gson gson = new Gson();
		String content = gson.toJson(request);

		System.out.println(content);


		var rep = mvc.perform(post("/api/cmp/v1/work/resources")
							 .contentType(MediaType.APPLICATION_JSON)
							 .content(content))
//					 .andExpect(status().isOk())
//					 .andExpect(jsonPath("$.id").value("id"))
//					 .andExpect(jsonPath("$.name").value("me"))
//					 .andExpect(jsonPath("$.data.imageName").value("MySQL"))
//					 .andExpect(jsonPath("$.data.someList").value(List.of("1", "2", "3")))
					 .andReturn();

		System.out.println(rep.getResponse().getContentAsString());

		Assertions.assertEquals(content, rep.getResponse().getContentAsString());
	}

	@Test
	void createSimple() throws Exception {
		SimpleRequest request = new SimpleRequest("id", "me", "MySQL");
		Gson gson = new Gson();
		String content = gson.toJson(request);

		var rep = mvc.perform(post("/api/cmp/v1/work/resources/simple")
							 .contentType(MediaType.APPLICATION_JSON)
							 .content(content)
					 )
					 .andExpect(status().isOk());


		System.out.println(rep);

//		verify(memberService).insert(member);

	}
}