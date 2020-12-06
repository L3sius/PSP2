package com.company.SuperHeroFactory;

public class SuperHero {

    private String name;
    private double power;

    public SuperHero(String name, double power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }
}
