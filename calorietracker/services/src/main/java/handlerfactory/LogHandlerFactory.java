package handlerfactory;

import intenthandlers.LogCaloriesHandler;
import intenthandlers.LogConsumptionHandler;
import intenthandlers.LogHandler;

import java.util.HashMap;
import java.util.Map;

import com.calorietracker.services.services.Intents;

public class LogHandlerFactory {
    
    Map<Intents, LogHandler> handlers = new HashMap<>();
    
    public LogHandlerFactory() {
        handlers.put(Intents.LOG_CALORIES, new LogCaloriesHandler());
        handlers.put(Intents.LOG_CONSUMPTION, new LogConsumptionHandler());
        
    }
    
    public LogHandler getHandler(String intent) {
        return handlers.get(Intents.getEnum(intent));
    }

}
