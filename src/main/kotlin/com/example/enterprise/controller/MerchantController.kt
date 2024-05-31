package com.example.enterprise.controller

import com.example.enterprise.entity.Merchant
import com.example.enterprise.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/details")
class MerchantController {

    @Autowired
    lateinit var detailService: UserService

    @GetMapping
    fun list(): List<Merchant> {
        return detailService.list()
    }

    @PostMapping
    fun save(@RequestBody detail: Merchant): Merchant {
        return detailService.save(detail)
    }

    @PutMapping
    fun update(@RequestBody detail: Merchant): ResponseEntity<Merchant> {
        val updatedDetail = detailService.update(detail)
        return ResponseEntity.ok(updatedDetail)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        detailService.delete(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Merchant> {
        val detail = detailService.getById(id)
        return if (detail != null) {
            ResponseEntity.ok(detail)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @PatchMapping("/{id}")
    fun partialUpdate(@PathVariable id: Long, @RequestBody detail: Merchant): ResponseEntity<Merchant> {
        val updatedDetail = detailService.partialUpdate(id, detail)
        return if (updatedDetail != null) {
            ResponseEntity.ok(updatedDetail)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
