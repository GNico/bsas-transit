package com.gnico.transit.usecases;

public interface GetAllLines {

	GetAllLinesResponse getAllLines();

	GetAllLinesResponse getLinesCloseTo(double lat, double lon);
}
