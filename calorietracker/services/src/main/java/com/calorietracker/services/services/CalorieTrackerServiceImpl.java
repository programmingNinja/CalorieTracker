package com.calorietracker.services.services;

import handlerfactory.LogHandlerFactory;
import intenthandlers.LogHandler;

import org.api.CalorieTrackerService;

import ai.api.model.Fulfillment;
import ai.api.web.AIWebhookServlet;

public class CalorieTrackerServiceImpl extends AIWebhookServlet implements CalorieTrackerService {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public String logCalories(String request) {
        // TODO Auto-generated method stub
        return null;
    }

    public String logConsumption(String request) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    protected void doWebhook(AIWebhookRequest webhookrequest, Fulfillment output) {
        LogHandlerFactory handlerFactory = new LogHandlerFactory();
        LogHandler logHandler = handlerFactory.getHandler(webhookrequest.getResult().getMetadata().getIntentName());
        output.setSpeech(logHandler.log(webhookrequest.getResult()));
    }

}
