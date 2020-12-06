package com.company.SuperHeroFactory.extensions;

import com.company.SuperHeroFactory.SuperHero;
import com.company.SuperHeroFactory.SuperHeroList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExtendableSuperHeroList implements SuperHeroList {

    private List<SuperHero> superHeroes = new ArrayList<>();

    private List<Extension> extensions = new ArrayList<>();

    @Override
    public void createSuperHero(SuperHero superHero) {
        boolean acceptable = extensions.stream().map(extension -> extension.isAcceptableHero(superHero))
                .reduce(true,(left,right) -> left && right);


        if(acceptable) {
            this.superHeroes.add(superHero);
        }
    }

    @Override
    public double getTotalPower() {
        double totalPower = superHeroes.stream().mapToDouble(SuperHero::getPower).sum();

        for(Extension extension : extensions){
            totalPower = extension.increaseHeroPower(totalPower);
        }
        return totalPower;
    }

    @Override
    public SuperHeroList getDecorator() {
        return null;
    }

    @Override
    public Class getDecoratedClass() {
        return null;
    }

    public void addExtension(Extension extension){
        this.extensions.add(extension);

        extension.setSuperHeroList(this);
    }

    public <T extends Extension> Optional<T> getExtension(Class<T> type){
        return extensions.stream()
                .filter(extension -> type.isInstance(extension))
                .map(extension -> (T) extension)
                .findFirst();
    }
}
