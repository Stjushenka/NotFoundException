package ru.netology.domain;


import java.util.Collection;
import java.util.Objects;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class TShirt extends Product {
    private String color;
    private String size;

    public TShirt() {

    }


    public TShirt(int id, String name, int price, String color, String size) {
        super(id, name, price);
        this.color = color;
        this.size = size;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TShirt shirt = (TShirt) o;
        return Objects.equals(color, shirt.color) &&
                Objects.equals(size, shirt.size);
    }


    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), color, size);
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (search.equalsIgnoreCase(color)) {
            return true;
        }
        if (search.equalsIgnoreCase(size)) {
            return true;
        }
        return false;
    }


}

