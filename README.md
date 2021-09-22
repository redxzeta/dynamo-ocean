dynamo-ocean

# Sprinb Boot DynamoDB

A proof of concept to connect dynamodb and spring boot. It runs locally


## Lessons Learned

Learned how to set up a local version of dynamodb, install the aws cli and how it connects with spring boot. 
Learned the hard way using aws cli with pws 7 and switched to bash. 


## Installation

Install with maven

```bash
    mvn clean install
```

Download Local Dynamodb

[DynamoDB Link](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/DynamoDBLocal.DownloadingAndRunning.html)

Extract to Somewhere

Install AWS CLI


## Run Locally

### Recommended to use Git Bash

Navigate where you downloaded DynamoDB

```bash
  java -Djava.library.path=./DynamoDBLocal_lib -jar DynamoDBLocal.jar -sharedDb
```

Create a table

```bash
aws dynamodb create-table \
--table-name Stands \
--attribute-definitions \
AttributeName=name,AttributeType=S \
AttributeName=part,AttributeType=N \
--key-schema AttributeName=name,KeyType=HASH AttributeName=part,KeyType=RANGE \
--provisioned-throughput ReadCapacityUnits=1,WriteCapacityUnits=1 --endpoint-url http://localhost:8000
```

The end part is important because we are running locally


List Tables

```bash
aws dynamodb list-tables --endpoint-url http://localhost:8000
```

Delete Table

```bash
aws dynamodb delete-table --table-name Stands --endpoint-url http://localhost:8000
```

Add item

```bash
 aws dynamodb put-item \
    --table-name Stands \
    --item '{
      "name": {"S": "Golden Experience"},
	  "part":{"N":"3"}
    }' \
    --endpoint-url http://localhost:8000
```


Run Spring Boot

```bash
./mvnw spring-boot:run
```


## License

[MIT](https://choosealicense.com/licenses/mit/)


## Documentation

[Documentation](https://docs.aws.amazon.com/amazondynamodb/latest/developerguide/dynamodb-dg.pdf#Introduction)

[Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)

  
