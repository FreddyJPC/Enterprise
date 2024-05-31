package com.example.enterprise.entity

import jakarta.persistence.*

@Entity
@Table(name = "detail")
class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "quantity", nullable = false)
    var quantity: Int? = null

    @Column(name = "price")
    var price: Double? = null

    @Column(name = "subtotal", insertable = false, updatable = false)
    var subtotal: Double? = null

    @ManyToOne
    @JoinColumn(name = "invoice_id", nullable = false)
    var invoice: Order? = null

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    var product: Product? = null
}
