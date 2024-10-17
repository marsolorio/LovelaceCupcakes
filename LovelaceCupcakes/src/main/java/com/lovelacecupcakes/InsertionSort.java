package com.lovelacecupcakes;

import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class InsertionSort {

    public static void main(String[] args) {
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("src/main/java/com/lovelacecupcakes/cupcake_3906.json");
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

            // Print sorted cupcakes
            for (int i = 0; i < cupcakes.size(); i++) {
                System.out.println(cupcakes.get(i).getAsJsonObject().get("name").getAsString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
