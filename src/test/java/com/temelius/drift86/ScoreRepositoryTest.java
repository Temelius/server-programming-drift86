package com.temelius.drift86;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.temelius.drift86.model.CarRepository;
import com.temelius.drift86.model.MapRepository;
import com.temelius.drift86.model.Score;
import com.temelius.drift86.model.ScoreRepository;


@ExtendWith(SpringExtension.class)
@DataJpaTest
public class ScoreRepositoryTest {
	
	@Autowired
	private ScoreRepository srepository;
	
	@Autowired
	private CarRepository crepository;
	
	@Autowired
	private MapRepository mrepository;
	
	@Test
	public void findAllByUserShouldReturnMapsByUser() {
		List<Score> scores = srepository.findAllByUser("Temecchi");
		
		assertThat(scores).hasSize(1);
		assertThat(scores.get(0).getUsername()).isEqualTo("Temecchi");
		assertThat(scores.get(0).getCar().getName()).isEqualTo("EG86");
	}
	
	@Test
	public void createNewScore() {
		Score score = new Score("Temecchi", "500330", "10:10:10", false, true, crepository.findByName("EG86").get(0), mrepository.findByName("Gunma").get(0));
		srepository.save(score);
		assertThat(score.getId()).isNotNull();
	}
	
	@Test
	public void deleteScore() {
		srepository.delete(srepository.findAllByUser("Temecchi").get(0));
		List<Score> scores = srepository.findAllByUser("Temecchi");
		assertThat(scores).hasSize(0);
		
	}
}
