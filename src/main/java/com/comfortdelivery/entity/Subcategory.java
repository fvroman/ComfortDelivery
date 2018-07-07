package com.comfortdelivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "SUBCATEGORIES")
public class Subcategory {
    @Id
    @Column(name = "subcategory_name")
    private String subcategoryName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "category_name")
    private Category category;

    public String getSubcategoryName() {
        return subcategoryName;
    }

    public void setSubcategoryName(String subcategoryName) {
        this.subcategoryName = subcategoryName;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
