package com.yuanshi.Config;

import com.mongodb.MongoClient;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.yuanshi.Exception.ClientNotFoundException;
import com.yuanshi.Exception.DatabaseNotFoundException;


import java.util.Objects;

public class MongoDBConfig{
    private MongoClient client = null;
    private MongoDatabase database = null;


    public MongoClient getClient() {
        return client;
    }

    public MongoDatabase getDatabase() {
        return database;
    }

    public void createMongoConnection(String myClient, String myDatabase){

        try {
            client = new MongoClient(myClient);

            if (client.toString().equals("")) {
                throw new ClientNotFoundException();
            }

            database = client.getDatabase(myDatabase);

            if (database.toString().equals("")) {
                throw new DatabaseNotFoundException();
            }

        }catch (RuntimeException e) {
            e.printStackTrace();
        } catch (ClientNotFoundException | DatabaseNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public MongoCollection getCollection(String collection) {
        return database.getCollection(collection);
    }

    public void closeMongoConnection(String myClient) {

        try {
            client = new MongoClient(myClient);

            if (!Objects.equals(client, new MongoClient(myClient))) {
                throw new ClientNotFoundException();
            }

            client.close();

        }catch (ClientNotFoundException e){
            e.printStackTrace();
        }

    }

}
