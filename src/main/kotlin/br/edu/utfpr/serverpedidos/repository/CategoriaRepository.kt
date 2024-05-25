package br.edu.utfpr.serverpedidos.repository

import br.edu.utfpr.serverpedidos.entity.Categoria
import org.springframework.data.domain.Page
import org.springframework.data.jpa.repository.JpaRepository
import java.awt.print.Pageable

interface CategoriaRepository : JpaRepository<Categoria, Int> {
    fun findByNomeContainsIgnoreCase(nome: String): List<Categoria>
}
