package com.msr.tzis.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class ItemLine {
    private @Id @GeneratedValue(strategy= GenerationType.IDENTITY) Long id;

    @OneToOne
    private Item item;
    private int quantity;

    public ItemLine(){};
    public ItemLine(Item item, int quantity){
        this.item = item;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (!(o instanceof ItemLine))
            return false;
        ItemLine itemline = (ItemLine) o;
        return Objects.equals(this.id, itemline.id) &&
                Objects.equals(this.item, itemline.item) &&
                Objects.equals(this.quantity, itemline.quantity);
    }

    @Override
    public String toString(){
        return "ItemLine{" + "id=" + this.id + ", item='" + this.item.toString() + '\'' +
                ", quantity=" + this.quantity + "}";
    }
}
