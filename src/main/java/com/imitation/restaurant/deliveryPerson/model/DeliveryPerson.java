package com.imitation.restaurant.deliveryPerson.model;

import com.imitation.restaurant.generic.Model;
import com.imitation.restaurant.order.model.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@Entity
@Table(name = "delivery_persons")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeliveryPerson implements Model {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private boolean active;

    private Status status;

    @OneToMany(mappedBy="deliveryPerson" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Order> orders;

    public enum Status{

        UNASSIGNED("UNASSIGNED"),
        ASSIGNED("ASSIGNED"),
        FULFILLED("FULFILLED");

        private final String value;

        Status(String v) {
            value = v;
        }
    }
}





