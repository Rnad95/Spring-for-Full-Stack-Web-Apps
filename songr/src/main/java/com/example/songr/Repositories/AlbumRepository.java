package com.example.songr.Repositories;

import com.example.songr.domain.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Integer> {
}
