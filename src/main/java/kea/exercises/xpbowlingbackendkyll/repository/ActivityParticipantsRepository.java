package kea.exercises.xpbowlingbackendkyll.repository;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityParticipants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityParticipantsRepository extends JpaRepository<ActivityParticipants, Integer> {

}
