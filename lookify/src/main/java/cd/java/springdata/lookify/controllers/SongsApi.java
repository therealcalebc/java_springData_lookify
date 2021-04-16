/**
 * 
 */
package cd.java.springdata.lookify.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cd.java.springdata.lookify.models.Song;
import cd.java.springdata.lookify.services.SongService;

/**
 * @author ccomstock
 *
 */
@RestController
public class SongsApi {
	
	private final SongService songService;
	
	public SongsApi(SongService songService) {
		this.songService = songService;
	}
	
	@GetMapping("/api/songs")
	public List<Song> readAll() {
		return songService.readAll();
	}
	
	@PostMapping("/api/songs")
	public Song create(@RequestParam String title, @RequestParam String artist, @RequestParam Integer rating) {
		Song song = new Song(title, artist, rating);
		return songService.createOne(song);
	}
	
	@GetMapping("/api/songs/{id}")
	public Song readOne(@PathVariable Long id) {
		Song song = songService.readOne(id);
		return song;
	}
	
	@PutMapping("/api/songs/{id}")
	public Song update(@PathVariable Long id, @RequestParam String title, @RequestParam String artist, @RequestParam Integer rating) {
		Song song = songService.readOne(id);
		if(song != null) {
			song.setTitle(title);
			song.setArtist(artist);
			song.setRating(rating);
		}
		return songService.updateOne(song);
	}
	
	@DeleteMapping("/api/songs/{id}")
	public void destroy(@PathVariable Long id) {
		songService.destroyOne(id);
	}
	
}
