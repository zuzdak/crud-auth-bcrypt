package pl.kaz.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import pl.kaz.domain.Author;
import pl.kaz.service.AuthorService;

@Controller
// @RequestMapping("/authors")
public class AuthorController {

	private AuthorService authorService;

	@Autowired
	public AuthorController(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}

	@RequestMapping("/authors/list") // @RequestMapping("/list")
	public String list(Model model) {
		model.addAttribute("authors", authorService.list());
		model.addAttribute("ilosc", authorService.list().size());
		return "author/list";
	}

	@RequestMapping("/admin/authors") // @RequestMapping("/list")
	@Secured("ROLE_ADMIN")
	public String listAu(Model model) {
		model.addAttribute("authors", authorService.list());
		return "/admin/authors/list";
	}

	@RequestMapping("/view")
	public String view(Model model) {
		return "author/view";
	}

	// ------------- Admin CRUD site
	@RequestMapping("/admin/author/delete/{id}")
	public String delete(@PathVariable Integer id) {
		authorService.deleteAuthor(id);
		return "redirect:/admin/authors/list";
	}

	@RequestMapping("/admin/author/{id}")
	@Secured("ROLE_ADMIN")
	public String viewAuthor(@PathVariable(value = "id") Integer id, Model model) {
		model.addAttribute("author", authorService.findAuthor(id));
		return "/admin/authors/view";
	}
	
	@RequestMapping("/admin/pass/{userName}")
	public String getActiveAuthor(@PathVariable(value = "userName") String userName, Model model) {
		model.addAttribute("author", authorService.getActiveAuthor(userName));
		return "admin/authors/authorPass";
	}
	
	// Author getActiveAuthor(String userName){
	@Secured("ROLE_ADMIN")
	@RequestMapping("/admin/author/create")
	public String create(Model model) {
		Author author = new Author();
		ArrayList<String> role  = listRole();
		model.addAttribute("roles", role);
		model.addAttribute("author", author);
		return "admin/authors/authorForm";
	}

	@RequestMapping(value = "/admin/author/save", method = RequestMethod.POST)
	public String save(@Valid Author author, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			ArrayList<String> role  = listRole();
			model.addAttribute("roles", role);
			return "admin/authors/authorForm";
			// return "admin/post/postForm";
		} else {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			String pa =author.getPassword();
			System.out.println(pa);
			String pe = encoder.encode(pa);
			author.setPassword(pe);
			Author savedAuthor = authorService.save(author);
			return "redirect:/admin/author/" + savedAuthor.getId();
		}
	}
	
//	@RequestMapping(value = "/admin/author/update", method = RequestMethod.POST)
//	public String updatePass(@Valid Author author, BindingResult bindingResult,
//			@RequestParam(name = "id") int id,
//            @RequestParam(name = "password") String password,
//			Model model) {
//
//		if (bindingResult.hasErrors()) {
//			ArrayList<String> role  = listRole();
//			model.addAttribute("roles", role);
//			return "admin/authors/authorPass";
//			// return "admin/post/postForm";
//		} else {
//			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//			String pa =author.getPassword();
//			System.out.println(pa);
//			password = encoder.encode(pa);
//			// String pass = author.setPassword(pe);
//			 id = author.getId();
//			 updatePassword(id,password) ;
//			return "redirect:/admin/author/" + id;
//		}
//	}
	
	@RequestMapping("/admin/author/edit/{id}")
	public String edit(@PathVariable Integer id, Model model){
		ArrayList<String> role  = listRole();
		model.addAttribute("roles", role);
		model.addAttribute("author", authorService.findAuthor(id));
		return "admin/authors/authorForm";		
	}
	
	
	public ArrayList<String> listRole(){
		ArrayList<String> role = new ArrayList<String>();
		  /*This is how elements should be added to the array list*/
		  role.add("ROLE_ADMIN");
		  role.add("ROLE_KANC");
		  role.add("ROLE_USER");
		  role.add("ROLE_DBA");
		return role;
	}
	

}
