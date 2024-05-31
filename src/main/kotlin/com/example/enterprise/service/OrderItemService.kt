package com.example.enterprise.service

import com.example.enterprise.entity.Order
import com.example.enterprise.repository.MerchantRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderItemService {

    @Autowired
    lateinit var invoiceRepository: MerchantRepository

    fun list(): List<Order> {
        return invoiceRepository.findAll()
    }

    fun save(invoice: Order): Order {
        return invoiceRepository.save(invoice)
    }

    fun update(invoice: Order): Order {
        return invoiceRepository.save(invoice)
    }

    fun delete(id: Long) {
        invoiceRepository.deleteById(id)
    }

    fun getById(id: Long): Order? {
        return invoiceRepository.findById(id).orElse(null)
    }

    fun partialUpdate(id: Long, invoice: Order): Order? {
        val existingInvoice = invoiceRepository.findById(id).orElse(null) ?: return null
        existingInvoice.code = invoice.code ?: existingInvoice.code
        existingInvoice.createAt = invoice.createAt ?: existingInvoice.createAt
        existingInvoice.total = invoice.total ?: existingInvoice.total
        existingInvoice.client = invoice.client ?: existingInvoice.client
        return invoiceRepository.save(existingInvoice)
    }
}
