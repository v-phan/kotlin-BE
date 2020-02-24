package no.knips.repositories

import no.knips.entities.Ordre
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdreRepository: CrudRepository<Ordre, Int> {

}