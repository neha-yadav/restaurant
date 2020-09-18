package com.imitation.restaurant.item.model;

import com.imitation.restaurant.generic.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity
@Table(name="items")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Item implements Model {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    @Min(value=1)
    private int quantityAvailable;

    private String description;

    private String name;

    @DecimalMin(value = "0.1")
    private float price;
}
