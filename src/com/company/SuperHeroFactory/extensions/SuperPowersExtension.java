package com.company.SuperHeroFactory.extensions;

import com.company.SuperHeroFactory.SuperHero;
import com.company.SuperHeroFactory.SuperHeroList;

public class SuperPowersExtension implements Extension{

    private SuperHeroList superHeroList;

    @Override
    public boolean isAcceptableHero(SuperHero superHero) {
        return true;
    }

    @Override
    public double increaseHeroPower(double power) {
        return power * 2;
    }

    @Override
    public void setSuperHeroList(SuperHeroList superHeroList) {
        this.superHeroList = superHeroList;
    }

    public double getInjuredHeroPower() {
        return this.superHeroList.getTotalPower() * 0.5;
    }
}
