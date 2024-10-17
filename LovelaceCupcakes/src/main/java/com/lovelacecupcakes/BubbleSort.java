package com.lovelacecupcakes;

import java.io.FileReader;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

public class BubbleSort {

  public static void main(String[] args) {
    try {
      Gson gson = new Gson();
      FileReader reader = new FileReader("src/main/java/com/lovelacecupcakes/cupcake_3906.json");
      JsonArray cupcakes = gson.fromJson(reader, JsonArray.class);

      // Bubble sort algorithm
      for (int i = 0; i < cupcakes.size() - 1; i++) {
        for (int j = 0; j < cupcakes.size() - i - 1; j++) {
          JsonObject cupcake1 = cupcakes.get(j).getAsJsonObject();
          JsonObject cupcake2 = cupcakes.get(j + 1).getAsJsonObject();

          if (cupcake1.get("name").getAsString().compareTo(cupcake2.get("name").getAsString()) > 0) {
            // Swap
            cupcakes.set(j, cupcake2);
            cupcakes.set(j + 1, cupcake1);
          }
        }
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
