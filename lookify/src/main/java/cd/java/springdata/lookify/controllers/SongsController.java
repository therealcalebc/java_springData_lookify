/**
 * 
 */
package cd.java.springdata.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import cd.java.springdata.lookify.models.Song;
import cd.java.springdata.lookify.services.SongService;

/**
 * @author ccomstock
 *
 */
@Controller
public class SongsController {
	
	private final SongService songService;
	
	public SongsController(SongService songServ) {
		songService = songServ;
	}
	
	@GetMapping("/dashboard")
	public String viewDashboard(Model model) {
		List<Song> songList = songService.readAll();
		model.addAttribute("songs", songList);
		return "dashboard/index.jsp";
	}
	
	@GetMapping("/songs/new")
	public String viewNew(@ModelAttribute Song song) {
		return "songs/new.jsp";
	}
	
	@PostMapping("/songs")
	public String addNew(@Valid @ModelAttribute Song song, BindingResult result) {
		System.out.println("SongsController.addNew(): result.hasErrors() == " + result.hasErrors());
		if(result.hasErrors())return "songs/new.jsp";
		songService.createOne(song);
		return "redirect:/dashboard";
	}
	
	@GetMapping("/songs/{id}")
	public String viewShow(@PathVariable Long id, Model model) {
		Song song = songService.readOne(id);
		if(song == null) return "redirect:/dashboard";
		model.addAttribute("song", song);
		return "songs/show.jsp";
	}
	
	@GetMapping("/songs/{id}/edit")
	public String viewEdit(@PathVariable Long id, Model model) {
		Song song = songService.readOne(id);
		if(song == null) return "redirect:/dashboard";
		model.addAttribute("song", song);
		return "songs/edit.jsp";
	}
	
	@PutMapping("/songs/{id}")
	public String update(@Valid @ModelAttribute Song song, BindingResult result) {
		if(result.hasErrors()) return "songs/edit.jsp";
		songService.updateOne(song);
		return "redirect:/songs";
	}
	
	@DeleteMapping("/songs/{id}")
	public String delete(@PathVariable Long id) {
		songService.destroyOne(id);
		return "redirect:/dashboard";
	}
	
}
