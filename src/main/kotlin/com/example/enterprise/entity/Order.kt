package com.example.enterprise.entity

import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "invoice")
class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false)
    var id: Long? = null

    @Column(name = "code", nullable = false, unique = true)
    var code: String? = null

    @Column(name = "create_at")
    var createAt: LocalDate? = null

    @Column(name = "total")
    var total: Double? = null

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false)
    var client: Country? = null

    @OneToMany(mappedBy = "invoice", cascade = [CascadeType.ALL], orphanRemoval = true)
    var details: MutableList<Merchant> = mutableListOf()
}
