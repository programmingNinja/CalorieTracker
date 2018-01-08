package com.calorietracker.services.services;

import handlerfactory.LogCaloriesHandlerFactory;
import handlerfactory.LogConsumptionHandlerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.api.CalorieTrackerService;

import com.frogermcs.gactions.AssistantActions;
import com.frogermcs.gactions.api.request.RootRequest;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class CalorieTrackerServiceImpl extends HttpServlet implements CalorieTrackerService {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(CalorieTrackerServiceImpl.class.getName());

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AssistantActions assistantActions =
                new AssistantActions.Builder(new AppEngineResponseHandler(response))
                        .addRequestHandlerFactory(Intents.LOG_CALORIES, new LogCaloriesHandlerFactory())
                        .addRequestHandlerFactory(Intents.LOG_CONSUMPTION, new LogConsumptionHandlerFactory())
                        .build();

        assistantActions.handleRequest(parseActionRequest(request));
    }

    public String logCalories(String request) {
        // TODO Auto-generated method stub
        return null;
    }

    public String logConsumption(String request) {
        // TODO Auto-generated method stub
        return null;
    }

    private RootRequest parseActionRequest(HttpServletRequest request) throws IOException {
        // printPayload(request);
        JsonReader jsonReader = new JsonReader(request.getReader());
        RootRequest rootRequest = new Gson().fromJson(jsonReader, RootRequest.class);
        log.info("REQUEST:" + rootRequest);
        return rootRequest;
    }

    private void printPayload(HttpServletRequest request) throws IOException {
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = request.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        System.out.println("Payload body: " + buffer.toString());

    }

}
