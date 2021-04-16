/**
 * 
 */
package cd.java.springdata.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cd.java.springdata.lookify.models.Song;
import cd.java.springdata.lookify.repositories.SongRepository;

/**
 * @author ccomstock
 *
 */
@Service
public class SongService {
	
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepo) {
		songRepository = songRepo;
	}
	
	/**
	 * @param l the new Song to create in the db
	 * @return the newly created song
	 */
	public Song createOne(Song l) {
		return songRepository.save(l);
	}
	
	/**
	 * @return list of all the Songs in the db
	 */
	public List<Song> readAll() {
		return songRepository.findAll();
	}
	
	/**
	 * @param id the id of the Song to retrieve from the db
	 * @return the Song that was retrieved
	 */
	public Song readOne(Long id) {
		Optional<Song> optLang = songRepository.findById(id);
		if(optLang.isPresent())
			return optLang.get();
		else
			return null;
	}
	
	/**
	 * @param l the Song to update in the db
	 * @return the updated song
	 */
	public Song updateOne(Song l) {
		return songRepository.save(l);
	}
	
	/**
	 * @param id the id of the Song to delete from the db
	 */
	public void destroyOne(Long id) {
		if(songRepository.existsById(id)) {
			songRepository.deleteById(id);
		}
	}
	
}
