package com.example.enterprise.service

import com.example.enterprise.entity.Merchant
import com.example.enterprise.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserService {

    @Autowired
    lateinit var detailRepository: OrderRepository

    fun list(): List<Merchant> {
        return detailRepository.findAll()
    }

    fun save(detail: Merchant): Merchant {
        return detailRepository.save(detail)
    }

    fun update(detail: Merchant): Merchant {
        return detailRepository.save(detail)
    }

    fun delete(id: Long) {
        detailRepository.deleteById(id)
    }

    fun getById(id: Long): Merchant? {
        return detailRepository.findById(id).orElse(null)
    }

    fun partialUpdate(id: Long, detail: Merchant): Merchant? {
        val existingDetail = detailRepository.findById(id).orElse(null) ?: return null
        existingDetail.quantity = detail.quantity ?: existingDetail.quantity
        existingDetail.price = detail.price ?: existingDetail.price
        return detailRepository.save(existingDetail)
    }
}
