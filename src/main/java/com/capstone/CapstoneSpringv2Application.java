package com.capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.capstone.domain.Category;
import com.capstone.domain.Song;
import com.capstone.domain.UserDetails;
import com.capstone.repositories.CategoryRepository;
import com.capstone.repositories.SongRepository;
import com.capstone.repositories.UserDetailsRepository;

@SpringBootApplication
public class CapstoneSpringv2Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CapstoneSpringv2Application.class, args);
	}
	
	@Autowired
	SongRepository songRepo;
	
	@Autowired
	CategoryRepository categoryRepo;
	
	@Autowired
	UserDetailsRepository userDetailsRepo;

	@Override
	public void run(String... args) throws Exception {
		initializeCategoryAndSongs();
	}

	private void initializeCategoryAndSongs() {
		// list of genres
		Category c1 = new Category();
		c1.setGenre("Hip Hop");
		Category c2 = new Category();
		c2.setGenre("Pop");
		Category c3 = new Category();
		c3.setGenre("Country");
		Category c4 = new Category();
		c4.setGenre("Rap");
		Category c5 = new Category();
		c5.setGenre("Rock");
		
		categoryRepo.save(c1);
		categoryRepo.save(c2);
		categoryRepo.save(c3);
		categoryRepo.save(c4);
		categoryRepo.save(c5);
		
		// list of songs
		Song s1 = new Song();
		s1.setTitle("s1Title");
		s1.setArtist("s1Artist");
		s1.setPrice(1.11);
		s1.setQuantity(10);
		s1.setGenre(c1);
		
		Song s2 = new Song();
		s2.setTitle("s2Title");
		s2.setArtist("s2Artist");
		s2.setPrice(2.22);
		s2.setQuantity(10);
		s2.setGenre(c1);
		
		Song s3 = new Song();
		s3.setTitle("s3Title");
		s3.setArtist("s3Artist");
		s3.setPrice(3.33);
		s3.setQuantity(10);
		s3.setGenre(c1);
		
		Song s4 = new Song();
		s4.setTitle("s4Title");
		s4.setArtist("s4Artist");
		s4.setPrice(4.44);
		s4.setQuantity(10);
		s4.setGenre(c3);
		
		
		Song s5 = new Song();
		s5.setTitle("s5Title");
		s5.setArtist("s5Artist");
		s5.setPrice(5.55);
		s5.setQuantity(10);
		s5.setGenre(c3);
		
		Song s6 = new Song();
		s6.setTitle("s6Title");
		s6.setArtist("s6Artist");
		s6.setPrice(6.66);
		s6.setQuantity(10);
		s6.setGenre(c5);
		
		
		Song s7 = new Song();
		s7.setTitle("s7Title");
		s7.setArtist("s7Artist");
		s7.setPrice(7.77);
		s7.setQuantity(10);
		s7.setGenre(c4);
		
		
		Song s8 = new Song();
		s8.setTitle("s8Title");
		s8.setArtist("s8Artist");
		s8.setPrice(8.88);
		s8.setQuantity(10);
		s8.setGenre(c5);
		
		
		Song s9 = new Song();
		s9.setTitle("s9Title");
		s9.setArtist("s9Artist");
		s9.setPrice(9.99);
		s9.setQuantity(10);
		s9.setGenre(c4);
		
		Song s10 = new Song();
		s10.setTitle("s10Title");
		s10.setArtist("s10Artist");
		s10.setPrice(10.10);
		s10.setQuantity(10);
		s10.setGenre(c4);
		
		
		songRepo.save(s1);
		songRepo.save(s2);
		songRepo.save(s3);
		songRepo.save(s4);
		songRepo.save(s5);
		songRepo.save(s6);
		songRepo.save(s7);
		songRepo.save(s8);
		songRepo.save(s9);
		songRepo.save(s10);
		
		// list of UserDetails
		
		UserDetails ud1 = new UserDetails();
		ud1.setEmail("ud1@gmail.com");
		ud1.setFirstName("ud1First");
		ud1.setLastName("ud1Last");
		ud1.setCreditCardNumber(111111111);
		ud1.setAddress("111 streets");
		
		UserDetails ud2 = new UserDetails();
		ud2.setEmail("ud2@gmail.com");
		ud2.setFirstName("ud2First");
		ud2.setLastName("ud2Last");
		ud2.setCreditCardNumber(222222222);
		ud2.setAddress("222 streets");
		
		UserDetails ud3 = new UserDetails();
		ud3.setEmail("ud3@gmail.com");
		ud3.setFirstName("ud3First");
		ud3.setLastName("ud3Last");
		ud3.setCreditCardNumber(333333333);
		ud3.setAddress("333 streets");
		
		userDetailsRepo.save(ud1);
		userDetailsRepo.save(ud2);
		userDetailsRepo.save(ud3);
	
		
		
		
		
	
	}

}
