package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import hu.sutetamas.showcase.Repository.ExaminationRepository;
import hu.sutetamas.showcase.Repository.InspectorRepository;
import hu.sutetamas.showcase.Repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ExaminationService {

    @Autowired
    private ExaminationRepository examinationRepository;
    @Autowired
    private InspectorRepository inspectorRepository;
    @Autowired
    private VehicleRepository vehicleRepository;

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

    public List<Examination> getAllExaminations(LocalDate date) {
        Iterable<Examination> examinationsIterator = examinationRepository.findAll();
        List<Examination> examinations = StreamSupport
                .stream(examinationsIterator.spliterator(), false)
                .collect(Collectors.toList());

        List<Examination> sameDayExaminations = new ArrayList<>();
        for(Examination examination : examinations) {
            if (examination.getStartTime().toLocalDateTime().toLocalDate().isEqual(date)) {
                sameDayExaminations.add(examination);
            }
        }
        return sameDayExaminations;
    }

    public void addExamination(Examination examination) {
        examinationRepository.save(examination);

        Timer timer = new Timer();
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(examination.getStartTime().getTime() + TimeUnit.MINUTES.toMillis(30) + TimeUnit.HOURS.toMillis(1)); // +1 óra mert a localdate késik ennyit
        Date date = calendar.getTime();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Random ran = new Random();
                int x = ran.nextInt(100); // random 0-99
                if (x < 15) {
                    LocalDate date = examination.getStartTime().toLocalDateTime().toLocalDate();
                    List<Examination> examinations = getAllExaminations(date);
                    Timestamp lastExamTime = new Timestamp(0);
                    for (Examination examination : examinations) {
                        if (examination.getStartTime().after(lastExamTime)) {
                            lastExamTime = examination.getStartTime();
                        }
                    }
                    examination.setStartTime(new Timestamp(lastExamTime.getTime() + TimeUnit.MINUTES.toMillis(70)));
                    examinationRepository.save(examination);
                }
            }
        }, date);
    }

    public void putExamination(long id, Examination examination) {
        Examination e = examinationRepository.findById(id).orElseThrow();
        e.setStartTime(examination.getStartTime());
        examinationRepository.save(e);
    }

    public boolean addInspectorToExamination(long exId, long inId) {
        Examination e = examinationRepository.findById(exId).orElseThrow();
        Inspector i = inspectorRepository.findById(inId).orElseThrow();
        if (i.getExaminations() != null) {
            List<Examination> examinations = i.getExaminations();
            for (Examination examination : examinations) {
                Timestamp start = new Timestamp(examination.getStartTime().getTime() - TimeUnit.MINUTES.toMillis(70));
                Timestamp end = new Timestamp(examination.getStartTime().getTime() + TimeUnit.MINUTES.toMillis(10));
                if (e.getStartTime().after(start) && e.getStartTime().before(end)) {
                    return false;
                }
            }
        }
        e.addInspector(i);
        examinationRepository.save(e);
        return true;
    }

    public void addVehicleToExamination(long exId, long veId) {
        Examination e = examinationRepository.findById(exId).orElseThrow();
        Vehicle v = vehicleRepository.findById(veId).orElseThrow();
        e.addVehicle(v);
        vehicleRepository.save(v);
    }

    // ---- FELADAT-S ----

    public Examination addExamination(long id, Timestamp startTime) {
        Examination e = new Examination();
        e.setStartTime(startTime);
        e.setId(id);
        return e;
    }

}
