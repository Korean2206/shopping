package com.asm.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "colors")
public class Color {
    @Id
    String id;
    String color_name;
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
    @JsonIgnore
    @OneToMany(mappedBy = "color")
    List<Division> division;
}
