package org.example.domain;

import java.util.List;

public record State(String name, String capital, List<City> cities, Integer numOfDistricts) { }
