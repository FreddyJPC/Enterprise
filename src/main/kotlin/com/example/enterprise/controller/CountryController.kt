package com.example.enterprise.controller

import com.example.enterprise.entity.Country
import com.example.enterprise.service.CountryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/client")
class CountryController {

    @Autowired
    lateinit var clientService: CountryService

    @GetMapping
    fun list(): List<Country> {
        return clientService.list()
    }

    @PostMapping
    fun save(@RequestBody client: Country): Country {
        return clientService.save(client)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody client: Country): Country {
        return clientService.update(id, client)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) {
        clientService.delete(id)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Country {
        return clientService.getById(id)
    }

    @PatchMapping("/{id}")
    fun partialUpdate(@PathVariable id: Long, @RequestBody partialClient: Map<String, Any>): Country {
        return clientService.partialUpdate(id, partialClient)
    }
}
