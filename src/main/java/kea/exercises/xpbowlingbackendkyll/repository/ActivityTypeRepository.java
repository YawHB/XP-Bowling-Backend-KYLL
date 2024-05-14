package kea.exercises.xpbowlingbackendkyll.repository;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {

}