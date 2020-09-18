package com.imitation.restaurant.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.imitation.restaurant.deliveryPerson.model.DeliveryPerson;
import com.imitation.restaurant.deliveryPerson.service.DeliveryPersonSerializer;
import com.imitation.restaurant.generic.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order implements Model {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String address;

    private Status status;

    private int durationInMins;

    @JsonSerialize(using = DeliveryPersonSerializer.class)
    @ManyToOne(fetch = FetchType.LAZY)
    private DeliveryPerson deliveryPerson;

    private long customerId;

    @OneToMany(mappedBy="order" ,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItem;

    @CreationTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createDateTime;

    @UpdateTimestamp
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime updateDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime deliveryStartDateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime deliveryEndDateTime;

    public enum Status{

        INITIATED("INITIATED"),
        PROCESSING("PROCESSING"),
        DELIVERED("DELIVERED"),
        CANCELLED("CANCELLED");

        private final String value;

        Status(String v) {
            value = v;
        }
    }
}


