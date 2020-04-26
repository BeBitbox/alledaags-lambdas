package be.jcrafters.workshop.alledaags;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Handler implements RequestHandler<Object, String> {

    @Override
    public String handleRequest(Object s, Context context) {
        System.out.println("Start of Lambda");
        var objectMapper = new ObjectMapper();

        var json = "{}";
        try {
            var dailyItems = new DynamoDailyItemRepository().getDailyItems();
            json = objectMapper.writeValueAsString(dailyItems) ;
        } catch (JsonProcessingException e) {
            System.out.println("Exception while serializing " + e);
        } catch (Exception e) {
            System.out.println("Unexpected exception " + e);
        }
        System.out.println(json);
        return json;
    }
}
