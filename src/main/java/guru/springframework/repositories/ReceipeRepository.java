package guru.springframework.repositories;

import org.springframework.data.repository.CrudRepository;

import guru.springframework.domain.Receipe;

public interface ReceipeRepository extends CrudRepository<Receipe, Long> {

}
