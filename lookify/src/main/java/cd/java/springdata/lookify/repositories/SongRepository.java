/**
 * 
 */
package cd.java.springdata.lookify.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cd.java.springdata.lookify.models.Song;

/**
 * @author ccomstock
 *
 */
@Repository
public interface SongRepository extends CrudRepository<Song, Long> {
	
	// this method retrieves all the songs from the database
	List<Song> findAll();
	
	// this method finds songs with artists containing the search string
	List<Song> findByArtistContainingIgnoreCase(String search);
	
	// this method finds the 10 songs with the highest ratings in descending order
	List<Song> findTop10ByOrderByRatingDesc();
	
	// this method counts how many songs have titles containing the search string
	Long countByTitleContaining(String search);
	
	// this method deletes a song that has a title starting with the search string
	Long deleteByTitleStartingWith(String search);
	
}
