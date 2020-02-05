package com.jpa.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 联合主键
 */
public final class LineKey implements Serializable {
    private Integer coustOrder;
    private int itemOder;

    public LineKey() {
    }

    public LineKey(Integer coustOrder, int itemOder) {
        this.coustOrder = coustOrder;
        this.itemOder = itemOder;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineKey lineKey = (LineKey) o;
        return itemOder == lineKey.itemOder &&
                coustOrder.equals(lineKey.coustOrder);
    }

    @Override
    public int hashCode() {
        return Objects.hash(coustOrder, itemOder);
    }

    @Override
    public String toString() {
        return "LineKey{" +
                "coustOrder=" + coustOrder +
                ", itemOder=" + itemOder +
                '}';
    }
}
