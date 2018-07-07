package com.comfortdelivery.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "CATEGORIES")
public class Category {

    @Id
    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "category_seq")
    private long categorySeq;

    @OneToMany(mappedBy = "category",
               fetch = FetchType.EAGER,
               cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Subcategory> subcategories;

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subCategories) {
        this.subcategories = subCategories;
    }

}
