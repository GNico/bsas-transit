package com.gnico.transit.usecases;

import java.util.List;

public class GetAllLinesResponse {

	private List<String> busLines;
	private List<String> subwayLines;
	private List<String> trainLines;
	
	public GetAllLinesResponse() {}

	public GetAllLinesResponse(List<String> busLines, List<String> subwayLines, List<String> trainLines) {
		this.busLines = busLines;
		this.subwayLines = subwayLines;
		this.trainLines = trainLines;
 
	}

	public List<String> getBusLines() {
		return busLines;
	}

	public void setBusLines(List<String> busLines) {
		this.busLines = busLines;
	}

	public List<String> getSubwayLines() {
		return subwayLines;
	}

	public void setSubwayLines(List<String> subwayLines) {
		this.subwayLines = subwayLines;
	}
	
	public List<String> getTrainLines() {
		return trainLines;
	}

	public void setTrainLines(List<String> trainLines) {
		this.trainLines = trainLines;
	}
	
	
}
