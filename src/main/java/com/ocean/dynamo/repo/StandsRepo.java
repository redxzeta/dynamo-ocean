package com.ocean.dynamo.repo;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.ocean.dynamo.entity.Stands;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StandsRepo {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Stands save(Stands stands) {
        dynamoDBMapper.save(stands);
        return stands;
    }

    public Stands findById(String id, int part) {
        System.out.println(id);
        return dynamoDBMapper.load(Stands.class, id, part);
    }

    public List<Stands> findAll() {
        return dynamoDBMapper.scan(Stands.class, new DynamoDBScanExpression());
    }

    public String update(String id, Stands stands) {
        dynamoDBMapper.save(stands,
                new DynamoDBSaveExpression()
                        .withExpectedEntry("id",
                                new ExpectedAttributeValue(
                                        new AttributeValue().withS(id)
                                )));
        return id;
    }

    public String delete(String id, int part) {
        Stands deleteStand = new Stands();
        deleteStand.setId(id);
        deleteStand.setPart(part);
        dynamoDBMapper.delete(deleteStand);
        return "Deleted id";
    }
}
