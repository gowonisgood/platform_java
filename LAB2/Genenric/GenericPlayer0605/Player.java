package Java_platform.Genenric.GenericPlayer0605;


//package com.kifa.player.core;

public abstract class Player {
    private String name;
    private int jerseyNumber;
    protected int speed;

    public Player(Builder<?> builder) {
        this.name = builder.name;
        this.jerseyNumber = builder.jerseyNumber;
        this.speed = builder.speed;
    }

    public static abstract class Builder<T extends Builder<T>> {
        private String name;
        private int jerseyNumber;
        private int speed;

        public T setName(String name) {
            this.name = name;
            return self();
        }

        public T setJerseyNumber(int jerseyNumber) {
            this.jerseyNumber = jerseyNumber;
            return self();
        }

        public T setSpeed(int speed) {
            this.speed = speed;
            return self();
        }

        public abstract Player build();

        protected abstract T self();
    }

    /*public Player(Builder<?> builder) {
        this.name = builder.name;
        this.jerseyNumber = builder.jerseyNumber;
        this.speed = builder.speed;
    }*/

    public abstract int getSpeed();

    @Override
    public String toString() {
        return "Player Name='" + name + "', JerseyNumber=" + jerseyNumber + ", SPEED=" + getSpeed();
    }
}