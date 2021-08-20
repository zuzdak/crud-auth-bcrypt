package pl.kaz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.kaz.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Integer> {

	List<Author> findAllByOrderByLastNameAscFirstNameAsc();
//	List<Author> 
	Author findByUserNameIgnoreCase(String userName);
	
	@Query("UPDATE Author c SET c.password = :password WHERE c.id = :id")
    int updatePassword(@Param("id") int id, @Param("password") String password);
	
//   @Query("select a from Author a where u a.username = :userName " )
//   List<Author> getActiveAuthor(String userName); // @Param("userName")

}
