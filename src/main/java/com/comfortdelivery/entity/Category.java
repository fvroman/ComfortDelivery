package com.comfortdelivery.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "category_name")
    private String Title;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    @OneToMany(mappedBy = "category",
               fetch = FetchType.EAGER,
               cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Subcategory> subcategories;

    public long getCategoryId() {
        return categoryId;
    }

    public List<Subcategory> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(List<Subcategory> subCategories) {
        this.subcategories = subCategories;
    }
}
