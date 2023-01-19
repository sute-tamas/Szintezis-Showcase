package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import hu.sutetamas.showcase.Repository.ExaminationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;

    public Examination getExamination(long id) {
        return examinationRepository.findById(id).orElseThrow();
    }

    public List<Examination> getAllExaminations() {
        Iterable<Examination> examinationsIterator = examinationRepository.findAll();
        List<Examination> examinations = StreamSupport
                .stream(examinationsIterator.spliterator(), false)
                .collect(Collectors.toList());
        return examinations;
    }

    public void addExamination(Examination examination) {
        examinationRepository.save(examination);
    }

    public void putExamination(long id, Examination examination) {
        Examination e = examinationRepository.findById(id).orElseThrow();
        e.setStartTime(examination.getStartTime());
        examinationRepository.save(e);
    }

    // ---- FELADAT-S ----

    public Examination addExamination(long id, Timestamp startTime) {
        Examination e = new Examination();
        e.setStartTime(startTime);
        e.setId(id);
        return e;
    }

}
