package com.axiv548.springbootblog.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Types
 *
 * @date 2020/7/4 1:23
 */

@Entity
@Table(name = "t_types")
public class Types {


    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "types")
    private List<Blog> blogs = new ArrayList<>();

    public Types() {

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

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }

    @Override
    public String toString() {
        return "Types{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
