package com.company.SuperHeroFactory.extensions;

import com.company.SuperHeroFactory.SuperHero;
import com.company.SuperHeroFactory.SuperHeroList;

public class VillainFilterExtension implements Extension {

    private SuperHeroList superHeroList;

    @Override
    public boolean isAcceptableHero(SuperHero superHero) {
        return !superHero.getName().contains("Thanos");
    }

    @Override
    public double increaseHeroPower(double power) {
        return power;
    }

    @Override
    public void setSuperHeroList(SuperHeroList superHeroList) {
        this.superHeroList = superHeroList;
    }
}
