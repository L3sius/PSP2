package com.company.SuperHeroFactory.extensions;

import com.company.SuperHeroFactory.SuperHero;
import com.company.SuperHeroFactory.SuperHeroList;

public interface Extension {
    boolean isAcceptableHero(SuperHero superHero);
    double increaseHeroPower(double power);
    void setSuperHeroList(SuperHeroList superHeroList);
}
