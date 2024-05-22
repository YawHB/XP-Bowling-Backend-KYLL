package kea.exercises.xpbowlingbackendkyll.service;

import kea.exercises.xpbowlingbackendkyll.model.activity.ActivityParticipants;
import kea.exercises.xpbowlingbackendkyll.repository.ActivityParticipantsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActivityParticipantsService {

        private final ActivityParticipantsRepository activityParticipantsRepository;

        public ActivityParticipantsService(ActivityParticipantsRepository activityParticipantsRepository){
            this.activityParticipantsRepository = activityParticipantsRepository;
        }
        public Optional<ActivityParticipants> save(ActivityParticipants activityParticipant) {
            ActivityParticipants savedParticipant = activityParticipantsRepository.save(activityParticipant);
            return Optional.of(savedParticipant);
        }
        public List<ActivityParticipants> findAll() {
            return activityParticipantsRepository.findAll();
        }

        public Optional<ActivityParticipants> findById(int id) {
            return activityParticipantsRepository.findById(id);
        }


    }
