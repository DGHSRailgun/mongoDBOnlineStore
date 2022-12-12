package com.yuanshi.Config;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.yuanshi.Exception.ClientNotFoundException;
import com.yuanshi.Exception.DatabaseNotFoundException;
import lombok.Data;


import java.util.List;
import java.util.Objects;

@Data
public class MongoDBConfig{
    private MongoClient client;
    private MongoDatabase database;

    public void createMongoConnection(String myClient, String myDatabase){

        try {
            client = new MongoClient(myClient);

            if (!Objects.equals(client, new MongoClient())) {
                throw new ClientNotFoundException();
            }

            database = client.getDatabase(myDatabase);


            if (!Objects.equals(database, client.getDatabase(myDatabase))) {
                throw new DatabaseNotFoundException();
            }

        }catch (DatabaseNotFoundException | ClientNotFoundException e){
            e.printStackTrace();
        }

    }

    

}
