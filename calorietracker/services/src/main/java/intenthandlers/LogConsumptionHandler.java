package intenthandlers;

import ai.api.model.Result;

public class LogConsumptionHandler implements LogHandler {

    public LogConsumptionHandler() {
    }

    @Override
    public String log(Result result) {
        String response = "you ate food " + result.getStringParameter("food");
        return response;

    }

}
