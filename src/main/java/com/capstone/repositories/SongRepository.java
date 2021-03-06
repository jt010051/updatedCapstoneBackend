package com.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.domain.Song;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {

}
