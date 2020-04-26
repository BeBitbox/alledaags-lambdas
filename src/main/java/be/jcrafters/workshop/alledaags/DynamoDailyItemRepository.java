package be.jcrafters.workshop.alledaags;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toList;

public class DynamoDailyItemRepository {

    private final DynamoDBMapper dynamoDBMapper;

    public DynamoDailyItemRepository() {
        var amazonDynamoDB = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion("eu-west-3")
                .build();
        dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
    }

    public List<DailyItem> getDailyItems() {
        Map<String, AttributeValue> eav = Map.of(":dateString", new AttributeValue().withS(LocalDate.now().toString()));

        DynamoDBQueryExpression<DynamoDailyItem> queryExpression = new DynamoDBQueryExpression<DynamoDailyItem>()
                .withKeyConditionExpression("dateString = :dateString")
                .withExpressionAttributeValues(eav);
        var query = dynamoDBMapper.query(DynamoDailyItem.class, queryExpression);

        if (query == null || query.isEmpty()) {
            return List.of();
        } else {
            return query
                    .stream()
                    .map(DynamoDailyItem::asDailyItem)
                    .collect(toList());
        }
    }
}
