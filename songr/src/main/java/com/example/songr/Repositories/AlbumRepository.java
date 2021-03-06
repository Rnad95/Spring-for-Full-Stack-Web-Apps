package com.example.songr.Repositories;

import com.example.songr.domain.Album;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Integer> {

    List<Album> findAll();
}
