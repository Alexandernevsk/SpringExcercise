package com.receptenapp.SpringExcercise.recipe_ingredient;

public enum measureUnit {
        THEESPOONS, G, L, M, CUPS;


        @Override
        public String toString() {
            return this.name().charAt(0) + this.name().substring(1).toLowerCase();
        }

}
