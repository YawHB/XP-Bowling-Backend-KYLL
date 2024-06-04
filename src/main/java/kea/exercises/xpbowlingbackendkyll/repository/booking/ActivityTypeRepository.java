package kea.exercises.xpbowlingbackendkyll.repository.booking;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {
}