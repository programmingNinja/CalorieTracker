package org.api;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface CalorieTrackerService {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public String logCalories(String request);

    public String logConsumption(String request);
}
