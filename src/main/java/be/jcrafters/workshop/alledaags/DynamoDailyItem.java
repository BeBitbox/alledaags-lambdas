package be.jcrafters.workshop.alledaags;

import com.amazonaws.services.dynamodbv2.datamodeling.*;

import java.time.Instant;

@DynamoDBTable(tableName = "DailyItem")
public class DynamoDailyItem {

    @DynamoDBHashKey(attributeName = "dateString")
    private String date;

    @DynamoDBRangeKey(attributeName = "title")
    private String title;

    @DynamoDBAttribute(attributeName = "specific")
    private String specific;

    @DynamoDBAttribute(attributeName = "image")
    private String image;

    @DynamoDBAttribute(attributeName = "credit")
    private String credit;

    @DynamoDBAttribute(attributeName = "creditName")
    private String creditName;

    @DynamoDBTypeConverted(converter = InstantConverter.class)
    @DynamoDBAttribute(attributeName = "creationTime")
    private Instant creationTime;

    public DynamoDailyItem() {
    }

    DailyItem asDailyItem() {
        return DailyItem.DailyItemBuilder.aDailyItem()
                .withTitle(title)
                .withCredit(credit)
                .withCreditName(creditName)
                .withImage(image)
                .withSpecific(specific)
                .build();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCreditName() {
        return creditName;
    }

    public void setCreditName(String creditName) {
        this.creditName = creditName;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }
}
