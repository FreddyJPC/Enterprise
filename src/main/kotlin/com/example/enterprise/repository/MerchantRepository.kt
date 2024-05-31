package com.example.enterprise.repository

import com.example.enterprise.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MerchantRepository : JpaRepository<Order, Long> {
}
