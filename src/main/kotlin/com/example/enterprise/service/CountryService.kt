package com.example.enterprise.service

import com.example.enterprise.repository.UserRepository
import com.example.enterprise.entity.Country
import jakarta.persistence.EntityNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CountryService {

    @Autowired
    lateinit var clientRepository: UserRepository

    fun list(): List<Country> {
        return clientRepository.findAll()
    }

    fun save(client: Country): Country {
        return clientRepository.save(client)
    }

    fun update(id: Long, client: Country): Country {
        val existingClient = clientRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró el cliente con el ID: $id") }

        existingClient.nui = client.nui
        existingClient.fullname = client.fullname
        existingClient.address = client.address
        existingClient.email = client.email

        return clientRepository.save(existingClient)
    }

    fun delete(id: Long) {
        val existingClient = clientRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró el cliente con el ID: $id") }

        clientRepository.delete(existingClient)
    }

    fun getById(id: Long): Country {
        return clientRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró el cliente con el ID: $id") }
    }

    fun partialUpdate(id: Long, partialClient: Map<String, Any>): Country {
        val existingClient = clientRepository.findById(id)
            .orElseThrow { EntityNotFoundException("No se encontró el cliente con el ID: $id") }

        partialClient.forEach { (key, value) ->
            when (key) {
                "nui" -> existingClient.nui = value as String
                "fullname" -> existingClient.fullname = value as String
                "address" -> existingClient.address = value as String
                "email" -> existingClient.email = value as String
                else -> throw IllegalArgumentException("Campo no válido para actualización parcial: $key")
            }
        }

        return clientRepository.save(existingClient)
    }
}
