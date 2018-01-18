package intenthandlers;

import ai.api.model.Result;

public class LogCaloriesHandler implements LogHandler {

    public LogCaloriesHandler() {

    }

    @Override
    public String log(Result result) {
        String response = "you consumer " + result.getStringParameter("calorieValue") + " calories";
        return response;
    }


}
