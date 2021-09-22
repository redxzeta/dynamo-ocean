package com.ocean.dynamo.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.*;
import com.ocean.dynamo.dtos.StandDTO;
import lombok.Data;
import lombok.ToString;


@Data
@ToString
@DynamoDBTable(tableName = "Stands")
public class Stands {
    @DynamoDBHashKey
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private String ability;
    @DynamoDBAttribute
    @DynamoDBRangeKey
    private int part;


    public Stands dtoToEntity(StandDTO standDTO) {
        Stands newStand = new Stands();
        newStand.setName(standDTO.getName());
        newStand.setAbility(standDTO.getAbility());
        newStand.setPart(standDTO.getPart());
        return newStand;
    }

}
