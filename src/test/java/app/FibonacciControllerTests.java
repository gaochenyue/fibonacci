package app;
/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FibonacciControllerTests {

	@Autowired
	private MockMvc mockMvc;
	// test get Fibonacci Sequence of 3
	@Test
	public void testGetFibonacciSequence() throws Exception {

		this.mockMvc.perform(get("/fibonacci/sequence/3")).andExpect(status().isOk())
				.andExpect(jsonPath("$.fibonacciSequence[0].position").value(0))
				.andExpect(jsonPath("$.fibonacciSequence[0].value").value(0))
				.andExpect(jsonPath("$.fibonacciSequence[1].position").value(1))
				.andExpect(jsonPath("$.fibonacciSequence[1].value").value(1))
				.andExpect(jsonPath("$.fibonacciSequence[2].position").value(2))
				.andExpect(jsonPath("$.fibonacciSequence[2].value").value(1));
	}
	
	// test get Fibonacci Sequence with negative input
	@Test
	public void testGetFibonacciSequenceWithNegativeInput() throws Exception {

		this.mockMvc.perform(get("/fibonacci/sequence/-2")).andExpect(status().isOk())
				.andExpect(jsonPath("$.input").value(-2))
				.andExpect(jsonPath("$.errorMessage").value(FibonacciConstants.ERROR_NEGATIVE_INPUT));
	}

	// test get Fibonacci Sequence with Non-integer input
	@Test
	public void testGetFibonacciSequenceWithNonIntegerInput() throws Exception {

		this.mockMvc.perform(get("/fibonacci/sequence/ab")).andExpect(status().isOk())
				.andExpect(jsonPath("$.input").value("ab"))
				.andExpect(jsonPath("$.errorMessage").value(FibonacciConstants.ERROR_NON_INTEGER_INPUT));
	}

	// test get Fibonacci Number of 6	
	@Test
	public void testGetFibonacciNumber() throws Exception {

		this.mockMvc.perform(get("/fibonacci/number/6")).andExpect(status().isOk())
				.andExpect(jsonPath("$.position").value(6)).andExpect(jsonPath("$.value").value(8));

	}

	// test get Fibonacci Number with negative input
	@Test
	public void testGetFibonacciNumberWithNegativeInput() throws Exception {

		this.mockMvc.perform(get("/fibonacci/number/-2")).andExpect(status().isOk())
				.andExpect(jsonPath("$.input").value(-2))
				.andExpect(jsonPath("$.errorMessage").value(FibonacciConstants.ERROR_NEGATIVE_INPUT));
	}

	// test get Fibonacci Number with Non-integer input
	@Test
	public void testGetFibonacciNumberWithNonIntegerInput() throws Exception {

		this.mockMvc.perform(get("/fibonacci/number/ab")).andExpect(status().isOk())
				.andExpect(jsonPath("$.input").value("ab"))
				.andExpect(jsonPath("$.errorMessage").value(FibonacciConstants.ERROR_NON_INTEGER_INPUT));
	}

}
