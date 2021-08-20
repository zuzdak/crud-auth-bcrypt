package pl.kaz.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.kaz.domain.Logs;

@Repository
public interface LogsRepository extends CrudRepository<Logs, Integer> {

}
