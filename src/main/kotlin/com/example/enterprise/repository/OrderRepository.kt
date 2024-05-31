package com.example.enterprise.repository

import com.example.enterprise.entity.Merchant
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : JpaRepository<Merchant, Long> {
}
