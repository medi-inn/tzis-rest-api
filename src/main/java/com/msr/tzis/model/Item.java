package com.msr.tzis.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Item {

    private @Id @GeneratedValue(strategy=GenerationType.IDENTITY) Long id;
    private String name;
    private String lagerort;

    public Item(){}

    public Item(String name, String lagerort){
        this.name = name;
        this.lagerort = lagerort;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLagerort() { return lagerort; }

    public void setLagerort(String lagerort) { this.lagerort = lagerort; }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof Item))
            return false;
        Item item = (Item) o;
        return Objects.equals(this.id, item.id) &&
                Objects.equals(this.name, item.name) &&
                Objects.equals(this.lagerort, item.lagerort);
    }

    @Override
    public String toString(){
        return "Desktop{" + "id=" + this.id + ", name='" + this.name + '\'' +
                ", lagerort=" + lagerort.toString();
    }
}
