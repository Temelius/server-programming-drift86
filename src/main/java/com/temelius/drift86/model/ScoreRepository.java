package com.temelius.drift86.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Score, Long> {
	List<Score> findAllByUser(String username);
	List<Score> findAllByMapOrderByPointsDesc(Map map);
	List<Score> findAllByVerified(boolean isVerified);
}
