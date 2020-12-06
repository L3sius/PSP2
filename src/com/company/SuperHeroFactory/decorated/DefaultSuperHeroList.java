package com.company.SuperHeroFactory.decorated;

import com.company.SuperHeroFactory.SuperHero;
import com.company.SuperHeroFactory.SuperHeroList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class DefaultSuperHeroList implements SuperHeroList {

    private List<SuperHero> superHeroes =new ArrayList<>();

    @Override
    public void createSuperHero(SuperHero superHero) {
        this.superHeroes.add(superHero);
    }

    @Override
    public double getTotalPower() {
        return superHeroes.stream().mapToDouble(SuperHero::getPower).sum();
    }

    @Override
    public SuperHeroList getDecorator() {
        return null;
    }

    @Override
    public Class getDecoratedClass() {
        return null;
    }
}
