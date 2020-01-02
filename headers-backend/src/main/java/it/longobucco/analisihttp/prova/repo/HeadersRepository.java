package it.longobucco.analisihttp.prova.repo;

import it.longobucco.analisihttp.prova.model.HeadersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HeadersRepository extends JpaRepository<HeadersModel,Integer> {
}
