package kea.exercises.xpbowlingbackendkyll.repository.booking;

import kea.exercises.xpbowlingbackendkyll.model.activity.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

}
