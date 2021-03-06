package com.capstone.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capstone.domain.Song;
import com.capstone.repositories.SongRepository;

@RestController
@RequestMapping("/api/songs")
public class SongRestController {

	@Autowired
	SongRepository songRepo;
	
	@GetMapping
	public List<Song> getAllSongs(HttpServletResponse response) {
		return songRepo.findAll();
	}
	
	@GetMapping("/{id}")
	public Song getSong(@PathVariable("id") Long id) {
		return songRepo.findById(id).get();
	}	
	
	@PutMapping()
	public Song updateSong(@RequestBody Song updatedSong) {
		
		System.out.println("INSIDE UPDATE METHOD()");
		Song originalSong = songRepo.findById(updatedSong.getId()).get();
		originalSong.setTitle(updatedSong.getTitle());
		originalSong.setArtist(updatedSong.getArtist());
		originalSong.setPrice(updatedSong.getPrice());
		originalSong.setQuantity(updatedSong.getQuantity());
		originalSong.setGenre(updatedSong.getGenre());
		return songRepo.save(originalSong);
	}

	@PostMapping()
	public Song newSong(@RequestBody Song song) {
		return songRepo.save(song);
	}
	
	@DeleteMapping("/{id}")
	public void deleteSong(@PathVariable("id") long id) {
		songRepo.deleteById(id);
	}
	
	@RequestMapping(value = "/verify", headers = {
    "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public int veririfyStock(@RequestBody List<ItemAndQuantity> iq) {
		List<ItemAndQuantity> cart = iq;
		System.out.println(cart.get(0).songTitle);
		return cart.get(0).songId;
	}
	


}

class ItemAndQuantity {
	int songId;
	String songTitle;
	String songArtist;
	double songPrice;
	double totalCost;
	int quantity;
	
	public ItemAndQuantity() {}
	
	public ItemAndQuantity(int songId, String songTitle, String songArtist, double songPrice, double totalCost,
			int quantity) {
		this.songId = songId;
		this.songTitle = songTitle;
		this.songArtist = songArtist;
		this.songPrice = songPrice;
		this.totalCost = totalCost;
		this.quantity = quantity;
	}



	int getSongID() {
		return songId;
	}
}
