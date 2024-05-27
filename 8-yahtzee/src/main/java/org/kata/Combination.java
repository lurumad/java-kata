package org.kata;

import org.kata.combinations.Ones;
import org.kata.combinations.Twos;

public abstract class Category {
    public abstract int score(Roll roll);

    public static Category ones() {
        return new Ones();
    }
    public static Category twos() {
        return new Twos();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || (obj != null && this.getClass() == obj.getClass());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
}
