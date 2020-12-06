package com.company.SuperHeroFactory.decorated;

import com.company.SuperHeroFactory.SuperHero;
import com.company.SuperHeroFactory.SuperHeroList;

import java.util.Optional;

public class VillainFilterSuperHeroList implements SuperHeroList {

    private SuperHeroList superHeroList;
    private Class decoratedClass;

    public VillainFilterSuperHeroList(SuperHeroList superHeroList, Class decoratedClass) {
        this.superHeroList = superHeroList;
        this.decoratedClass = decoratedClass;
    }

    @Override
    public void createSuperHero(SuperHero superHero) {
        if(!superHero.getName().contains("Thanos")){
            this.superHeroList.createSuperHero(superHero);
            System.out.println("You can't add villain!");
        }
    }

    @Override
    public double getTotalPower() {
        return superHeroList.getTotalPower();
    }

    @Override
    public SuperHeroList getDecorator() {
        return superHeroList;
    }

    @Override
    public Class getDecoratedClass() {
        return decoratedClass;
    }
}
