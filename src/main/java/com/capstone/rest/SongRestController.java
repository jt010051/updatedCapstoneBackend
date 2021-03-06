package com.capstone.rest;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public Song updateRoom(@RequestBody Song updatedSong) {
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

}
