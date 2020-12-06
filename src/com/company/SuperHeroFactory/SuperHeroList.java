package com.company.SuperHeroFactory;

import java.util.Optional;

public interface SuperHeroList {
    void createSuperHero(SuperHero superHero);
    double getTotalPower();

    SuperHeroList getDecorator();
    Class getDecoratedClass();

}
