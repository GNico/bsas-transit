package com.gnico.transit.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.gnico.transit.presenter.FindItineraryViewModel;
import com.gnico.transit.presenter.ItineraryPresenter;
import com.gnico.transit.usecases.FindItinerary;
import com.gnico.transit.usecases.FindItineraryResponse;

@WebMvcTest(ItineraryController.class)
class ItineraryControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FindItinerary itineraryFinderUsecase;
	
	@MockBean
	private ItineraryPresenter itineraryPresenter;

	
	@ParameterizedTest
	@ValueSource(strings = {
			"", 
			"?startLat=0.34",
			"?startLat=string1&startLon=0.34&endLat=0.582&endLon=0.345&distance=100"})
	void test_incorrectParameters(String input) throws Exception {
		this.mockMvc.perform(get("/itinerary" + input)).andExpect(status().isBadRequest());
	}
	
	@Test
	void test_service_gets_called() throws Exception {
		when(itineraryFinderUsecase.findItinerary(any())).thenReturn(new FindItineraryResponse());		
		when(itineraryPresenter.formatResponse(any())).thenReturn(new FindItineraryViewModel());
		this.mockMvc.perform(get("/itinerary?startLat=0.581&startLon=0.34&endLat=0.582&endLon=0.345&distance=100"))
				.andExpect(status().isOk()).andExpect(jsonPath("$.itineraries").isEmpty());		
		verify(itineraryFinderUsecase).findItinerary(any());
	}

}
