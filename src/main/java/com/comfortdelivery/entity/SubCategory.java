package com.comfortdelivery.entity;

import javax.persistence.*;

@Entity
@Table(name = "subCategories")
public class SubCategory {
    @Id
    @Column(name = "subcategory_id")
    private long subcategoryId;

    @Column(name = "subcategory_name")
    private String subcategoryName;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                          CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "category_id")
    private Category category;

    public long getSubcategoryId() {
        return subcategoryId;
    }

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
