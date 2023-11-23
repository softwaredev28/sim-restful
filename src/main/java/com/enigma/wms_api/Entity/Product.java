package com.enigma.wms_api.Entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "m_product")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder(toBuilder = true)
public class Product {

    @Id
    @GeneratedValue(generator = "uuid-hibernate-generator")
    @GenericGenerator(name = "uuid-hibernate-generator", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "product_price_id", nullable = false, unique = true)
    private String productPriceId;

    @Column(name = "product_code", nullable = false, unique = true)
    private String productCode;

    @Column(name = "product_name", nullable = false, unique = true)
    private String productName;

//    @NotNull(message = "price is required")
//    @Min(value = 0, message = "price must be greater than equal 0")
//    @Column(name = "price", nullable = false)
//    private BigDecimal price;

//    @ManyToOne
//    @JoinColumn(name = "branch_id")
//    @JsonBackReference
//    private Branch branch;

    @OneToMany(mappedBy = "product")
    @JsonManagedReference
    private List<ProductPrice> productPrices;

}
