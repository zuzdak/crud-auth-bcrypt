package pl.kaz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import pl.kaz.domain.Author;
import pl.kaz.repository.AuthorRepository;

@Service
public class AuthorService {

	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		//super();
		this.authorRepository = authorRepository;
	}

	public List<Author> list() {
		return authorRepository.findAllByOrderByLastNameAscFirstNameAsc();
	}
	public  Author findAuthor(int id){
		return authorRepository.findOne(id);
	}
	
	public  void deleteAuthor(Integer id){
		authorRepository.delete(id);
	}
	
	public Author save(Author author) {
		return authorRepository.save(author);
	}
	
	public Author getActiveAuthor(String userName){
		
		return authorRepository.findByUserNameIgnoreCase(userName);
	}
	 
	 public Integer updatePassword(@Param("id") int id, @Param("password") String password){
		 return authorRepository.updatePassword(id, password) ;
	 }

}
