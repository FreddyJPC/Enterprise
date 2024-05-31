package com.example.enterprise.repository

import com.example.enterprise.entity.Country
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<Country, Long> {
}
