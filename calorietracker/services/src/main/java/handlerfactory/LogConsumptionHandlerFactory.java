package handlerfactory;

import intenthandlers.LogConsumptionHandler;

import com.frogermcs.gactions.api.RequestHandler;
import com.frogermcs.gactions.api.request.RootRequest;

public class LogConsumptionHandlerFactory extends RequestHandler.Factory {

    @Override
    public RequestHandler create(RootRequest rootRequest) {
        return new LogConsumptionHandler(rootRequest);
    }
}
