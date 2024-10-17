package com.lovelacecupcakes;

import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class InsertionSort {

    public static void main(String[] args) {
        try {
            // Pass the file path dynamically
            Gson gson = new Gson();
            FileReader reader = new FileReader(args[0]);
            JsonArray cupcakes = gson.fromJson(reader, JsonArray.class);

            // Insertion sort algorithm
            for (int i = 1; i < cupcakes.size(); i++) {
                JsonObject key = cupcakes.get(i).getAsJsonObject();
                int j = i - 1;

                while (j >= 0 && cupcakes.get(j).getAsJsonObject().get("name").getAsString()
                        .compareTo(key.get("name").getAsString()) > 0) {
                    cupcakes.set(j + 1, cupcakes.get(j));
                    j = j - 1;
                }
                cupcakes.set(j + 1, key);
            }

            // Print sorted cupcakes (including details)
            System.out.println("Sorted cupcakes:");
            for (int i = 0; i < cupcakes.size(); i++) {
                JsonObject cupcake = cupcakes.get(i).getAsJsonObject();
                System.out.println("Name: " + cupcake.get("name").getAsString() +
                        ", Price: " + cupcake.get("price").getAsDouble() +
                        ", Frosting: " + cupcake.get("frosting").getAsJsonArray().toString());
            }
        } catch (Exception e) {
            System.out.println("Error reading or parsing the JSON file.");
            e.printStackTrace();
        }
    }
}
