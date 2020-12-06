package com.company;

import com.company.SuperHeroFactory.SuperHero;
import com.company.SuperHeroFactory.SuperHeroList;
import com.company.SuperHeroFactory.decorated.DefaultSuperHeroList;
import com.company.SuperHeroFactory.decorated.SuperHeroListWithSuperPowers;
import com.company.SuperHeroFactory.decorated.VillainFilterSuperHeroList;
import com.company.SuperHeroFactory.extensions.ExtendableSuperHeroList;
import com.company.SuperHeroFactory.extensions.SuperPowersExtension;
import com.company.SuperHeroFactory.extensions.VillainFilterExtension;

public class Main {
    public static void main(String[] args) {
        //Default
        //SuperHeroList superHeroList = new DefaultSuperHero();

        //Decorated
        //SuperHeroList superHeroList = new SuperHeroListWithSuperPowers(new DefaultSuperHeroList());

        //Decorated 2x
        SuperHeroList superHeroList = new VillainFilterSuperHeroList(
                new SuperHeroListWithSuperPowers(
                        new DefaultSuperHeroList(), DefaultSuperHeroList.class
                ), SuperHeroListWithSuperPowers.class
        );

        runProgram(superHeroList, "Decorator example");

        //Extended

        ExtendableSuperHeroList extendableSuperHeroList = new ExtendableSuperHeroList();

        extendableSuperHeroList.addExtension(new SuperPowersExtension());
        extendableSuperHeroList.addExtension(new VillainFilterExtension());

        runProgram(extendableSuperHeroList, "Extendable example");

        System.out.println("Check total hero power level if heroes are injured: " + extendableSuperHeroList.getExtension(SuperPowersExtension.class).get().getInjuredHeroPower());


        //Use this algorithm to find if there is a specific decorated class
        findByClass(superHeroList, SuperHero.class);
        findByClass(superHeroList, SuperHeroListWithSuperPowers.class);
    }
    private static void runProgram(SuperHeroList superHeroList, String text){
        superHeroList.createSuperHero(new SuperHero("SpiderMan", 100.0));
        superHeroList.createSuperHero(new SuperHero("Thor", 200.0));
        superHeroList.createSuperHero(new SuperHero("Iron Man", 300.0));
        superHeroList.createSuperHero(new SuperHero("Thanos", 9000.0));

        System.out.println(text + ": " + superHeroList.getTotalPower());
    }

    private static void findByClass(SuperHeroList superHeroList, Class className){
        SuperHeroList temporaryClass = superHeroList;
        while (temporaryClass.getDecorator() != null)
        {
            if(className.equals(temporaryClass.getDecoratedClass()))
            {
                System.out.println(temporaryClass.getDecorator());
                return;
            }
            temporaryClass=temporaryClass.getDecorator();
        }
        System.out.println("Class with name: " + className + " was not found.");
    }
}
