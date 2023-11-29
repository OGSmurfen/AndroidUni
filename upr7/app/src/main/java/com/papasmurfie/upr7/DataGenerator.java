package com.papasmurfie.upr7;

import java.util.ArrayList;
import java.util.Random;

public class DataGenerator {
    public static ArrayList<Vegetable> generateList(int number)
    {
        ArrayList<Vegetable> production = new ArrayList<>();
        Random random = new Random();

        for(int i = 1; i<= number; i++)
        {
            //Vegetable
            production.add(new Vegetable("Vegetable"+i, 10+random.nextInt()%99,
                    4L+random.nextDouble()%99L));
            //Fruit
            production.add(new Fruit("Fruit"+i, 4+random.nextInt()%99, 4L+random.nextDouble()%99L,
                    random.nextInt(10)));
        }
        return production;
    }
}
