package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class DemoApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Test
	public void patchEndpointTest() throws Exception {
		this.mvc.perform(patch("/").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("PUT to index route"));
	}

	@Test
	public void deleteEndpointTest() throws Exception {
		this.mvc.perform(delete("/").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("DELETE to index route"));
	}

	@Test
	public void queryStringGamesTest() throws Exception {
		this.mvc.perform(get("/games?genre=action").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Genre is : action"));

	}

	@Test
	public void queryStringCarsTest() throws Exception {
		this.mvc.perform(get("/cars?type=suv&make=subaru&model=forester").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Results : suv subaru forester"));
	}

	@Test
	public void queryStringRecordsTest() throws Exception {
		this.mvc.perform(get("/records?bpm=132&genre=house&artist=avicii").accept(MediaType.TEXT_PLAIN))
				.andExpect(status().isOk())
				.andExpect(content().string("Genre is house. BPM is 132. Artist is avicii"));
	}

	@Test
	public void getHackByIdTest() throws Exception {
		int hackerId = 32;

		this.mvc.perform(get(String.format("/hacker/%d", hackerId)))
				.andExpect(status().isOk())
				.andExpect(content().string("Hacker 32 is Leroy Jenkins"));
	}

	@Test
	public void getCommentForMissionTest() throws Exception {
		String title = "phoenixdown";
		int commentId = 2;

		this.mvc.perform(get(String.format("/mission/%s/comments/%d", title, commentId)))
				.andExpect(status().isOk())
				.andExpect(content().string("Results : phoenixdown 2"));
	}

	@Test
	public void getCommentForMovieTest() throws Exception {
		String title = "battleship";
		int commentId = 2;

		this.mvc.perform(get(String.format("/movie/%s/comments/%d", title, commentId)))
				.andExpect(status().isOk())
				.andExpect(content().string("The troll, Leeroy Jenkins, has posted comment 2" +
						" on battleship"));

	}

}
