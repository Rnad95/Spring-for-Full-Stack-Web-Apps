package com.example.songr.Repositories;

import com.example.songr.domain.Song;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends CrudRepository<Song,Integer> {

    List<Song> findAllByAlbum_Id(Integer id);
}
