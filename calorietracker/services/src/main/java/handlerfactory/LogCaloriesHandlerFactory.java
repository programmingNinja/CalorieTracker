package handlerfactory;

import intenthandlers.LogCaloriesHandler;

import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.request.RootRequest;

public class LogCaloriesHandlerFactory extends RequestHandler.Factory {

    @Override
    public RequestHandler create(RootRequest rootRequest) {
        return new LogCaloriesHandler(rootRequest);
    }
}
