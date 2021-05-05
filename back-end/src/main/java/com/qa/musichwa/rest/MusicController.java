package com.qa.musichwa.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.musichwa.domain.Music;
import com.qa.musichwa.service.MusicService;

@RestController
public class MusicController {
	
	private MusicService service;
	
	public MusicController(MusicService service) {
		super();
		this.service = service;
	}
	
	// CREATE
	@PostMapping("/create")
	public Music createMusic(@RequestBody Music music) {
		return this.service.create(music);
	}
	
	// READ ALL
	@GetMapping("/getAll")
	public List<Music> getAll() {
		return this.service.getAll();
	}
	
	// READ ONE
	@GetMapping("/getOne/{id}")
	public Music getOne(@PathVariable long id) {
		return this.service.getOne(id);
	}
	
	// DELETE ONE
	@DeleteMapping("/remove/{id}")
	public boolean delete(@PathVariable long id) {
		return this.service.delete(id);
	}
	
	// UPDATE ONE
	@PutMapping("/update/{id}")
	public Music update(@RequestBody Music newMusic, @PathVariable long id) {
		return this.service.update(id, newMusic);
	}
}