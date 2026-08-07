package com.soniya.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

import com.soniya.beans.Book;

@Controller
public class BookAppController{
	
	@RequestMapping("/")
	public String home() {
//		return "index.html"; 
		return "index.html"; //.html is optional
	}
	
	@PostMapping("/SearchBook")
	public String searchBook(@RequestParam String name,Model m) {
		RestTemplate restTemplate=new RestTemplate();
		Book b=restTemplate.getForObject("http://localhost:2222/searchBook/"+name, Book.class);
		if(b==null) {
			m.addAttribute("msg", "Book NOT Found!");
		}else {
			m.addAttribute("book", b);
		}
		return "index";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@PostMapping("/SearchBook2")
//	public String searchBook2(@RequestParam String aname, Model m) {
//		List<Book> b=bookRepo.findAllByAname(aname);
//		if(!b.isEmpty()) {
//			m.addAttribute("books", b);
//			return "PrintBooks";
//		}else {
//			m.addAttribute("msg", "Book Not Found!");
//			return "index";
//		}
//	}
//	@PostMapping("/SearchBook3")
//	public String searchBook3(@RequestParam int price,@RequestParam String aname, Model m) {
//		List<Book> b=bookRepo.getMyBooks(price, "%"+aname+"%");
//		if(!b.isEmpty()) {
//			m.addAttribute("books", b);
//			return "PrintBooks";
//		}else {
//			m.addAttribute("msg", "Book Not Found!");
//			return "index";
//		}
//	}
//	@GetMapping("/GetImage")
//	public void getImage(@RequestParam String name, HttpServletResponse response ) throws IOException {
//		Book b=bookRepo.findById(name).orElse(null);
//		byte[] image=null;
//		if(b.getImage()!=null) {
//			image=b.getImage();
//		}else {
//			InputStream is = this.getClass().getClassLoader().getResourceAsStream("static/book.png");
//			image=is.readAllBytes();
//		}
//		response.getOutputStream().write(image);
//	}
//	@GetMapping("/GetImage2")
//	public void getImage2(@RequestParam String name, HttpServletResponse response ) throws IOException {
//		Book b=bookRepo.findById(name).orElse(null);
//		byte[] image=b.getImage();
//		response.getOutputStream().write(image);
//	}
//	@RequestMapping("/BookDetails")
//	public String bookDetails(@RequestParam String name,Model m) {
//		Book b=bookRepo.findById(name).orElse(null);
//		m.addAttribute("book", b);
//		return "BookDetails";
//	}
//	@GetMapping("/GetPdf")
//	public void getPdf(@RequestParam String name, HttpServletResponse response ) throws IOException {
//		Book b=bookRepo.findById(name).orElse(null);
//		byte[] pdf=b.getContent();
//		response.getOutputStream().write(pdf);
//	}
//	@PostMapping("/DownloadPdf")
//	public void downloadPdf(@RequestParam String name, HttpServletResponse response ) throws IOException {
//		Book b=bookRepo.findById(name).orElse(null);
//		byte[] pdf=b.getContent();
//		response.setHeader("Content-Disposition","attachment; filename=" + name+".pdf" );
//		response.getOutputStream().write(pdf);
//	}
}