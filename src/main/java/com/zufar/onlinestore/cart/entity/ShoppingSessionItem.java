package com.zufar.onlinestore.cart.entity;

import com.zufar.onlinestore.product.entity.ProductInfo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Version;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shopping_session_item")
public class ShoppingSessionItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Version
    private Integer version; // Adding version field for optimistic locking

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_session_id", nullable = false)
    private ShoppingSession shoppingSession;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id", nullable = false)
    private ProductInfo productInfo;

    @Column(name = "products_quantity", nullable = false)
    private Integer productsQuantity;

    public ShoppingSessionItem(UUID id, ShoppingSession shoppingSession, ProductInfo productInfo, Integer productsQuantity) {
        this.id = id;
        this.shoppingSession = shoppingSession;
        this.productInfo = productInfo;
        this.productsQuantity = productsQuantity;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        ShoppingSessionItem that = (ShoppingSessionItem) object;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "ShoppingSessionItem {" +
                "id = " + id +
                '}';
    }
}