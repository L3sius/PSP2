package com.company.SuperHeroFactory.decorated;

import com.company.SuperHeroFactory.SuperHero;
import com.company.SuperHeroFactory.SuperHeroList;

import java.util.Optional;

public class SuperHeroListWithSuperPowers implements SuperHeroList {

    private SuperHeroList superHeroList;
    private Class decoratedClass;

    public SuperHeroListWithSuperPowers(SuperHeroList superHeroList, Class decoratedClass) {
        this.superHeroList = superHeroList;
        this.decoratedClass = decoratedClass;
    }

    @Override
    public void createSuperHero(SuperHero superHero) {
        superHeroList.createSuperHero(superHero);
    }

    @Override
    public double getTotalPower() {
        return superHeroList.getTotalPower() * getSuperHeroPower();
    }

    @Override
    public SuperHeroList getDecorator() {
        return superHeroList;
    }

    @Override
    public Class getDecoratedClass() {
        return this.decoratedClass;
    }

    public double getSuperHeroPower() {
        return 2;
    }

    public double getInjuredHeroPower() {
        return superHeroList.getTotalPower() * 0.5;
    }
}
