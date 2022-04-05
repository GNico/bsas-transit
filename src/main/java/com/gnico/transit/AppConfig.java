package com.gnico.transit;

import org.n52.jackson.datatype.jts.JtsModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gnico.transit.domain.ItineraryStrategy;
import com.gnico.transit.domain.RouteFinder;
import com.gnico.transit.domain.SingleMeanItineraryStrategy;

@Configuration
public class AppConfig {

	@Bean
	public ItineraryStrategy itineraryStrategy(RouteFinder routeFinder) {
		return new SingleMeanItineraryStrategy(routeFinder);
	}
	
	@Bean
	public JtsModule jtsModule() {
		return new JtsModule();
	}
}
