package examples.controllers;


import java.util.HashMap;
import java.util.Map;

public class FactoryController {
    private static Map<String, ICommandRequest> controllers = new HashMap<>();

    private FactoryController() {
        controllers.put("user", new UserController());
        controllers.put("useBean", new SetBeanExample());
    }

    public static ICommandRequest getController(String urlValue) {
        if (controllers.containsKey(urlValue)) {
            return controllers.get(urlValue);
        }
        throw new IllegalArgumentException("No controllers found");
    }
}
