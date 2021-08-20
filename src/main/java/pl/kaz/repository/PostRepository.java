package pl.kaz.repository;

import java.util.List;

// import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.kaz.domain.Post;

@Repository
public interface PostRepository extends CrudRepository<Post, Integer> {

	//Page <Post> findAll(pagable);
	Post findFirstByOrderByPostedOnDesc();
	
	List<Post> findAllByOrderByPostedOnDesc();

	Post findBySlug(String slug);

	List<Post> findAllByAuthorIdOrderByPostedOnDesc(Integer id);

}
