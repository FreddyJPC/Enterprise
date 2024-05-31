package com.example.enterprise.controller

import com.example.enterprise.entity.Order
import com.example.enterprise.service.OrderItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/invoices")
class UserController {

    @Autowired
    lateinit var invoiceService: OrderItemService

    @GetMapping
    fun list(): List<Order> {
        return invoiceService.list()
    }

    @PostMapping
    fun save(@RequestBody invoice: Order): Order {
        return invoiceService.save(invoice)
    }

    @PutMapping
    fun update(@RequestBody invoice: Order): ResponseEntity<Order> {
        val updatedInvoice = invoiceService.update(invoice)
        return ResponseEntity.ok(updatedInvoice)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        invoiceService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Order> {
        val invoice = invoiceService.getById(id)
        return if (invoice != null) {
            ResponseEntity.ok(invoice)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    fun partialUpdate(@PathVariable id: Long, @RequestBody invoice: Order): ResponseEntity<Order> {
        val updatedInvoice = invoiceService.partialUpdate(id, invoice)
        return if (updatedInvoice != null) {
            ResponseEntity.ok(updatedInvoice)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
