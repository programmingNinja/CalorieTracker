package intenthandlers;

import com.frogermcs.gactions.ResponseBuilder;
import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.request.RootRequest;
import com.frogermcs.gactions.api.response.RootResponse;

public class LogCaloriesHandler extends RequestHandler {

    public LogCaloriesHandler(RootRequest rootRequest) {
        super(rootRequest);
    }

    @Override
    public RootResponse getResponse() {
        System.out.println("Request = " + getRootRequest().toString());
        return ResponseBuilder.tellResponse("You have reached Log Calories handler");
    }

}
