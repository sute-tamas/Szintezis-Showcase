package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import hu.sutetamas.showcase.Repository.InspectorRepository;
import hu.sutetamas.showcase.Repository.WorkplaceRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InspectorService {

    @Autowired
    private InspectorRepository inspectorRepository;
    @Autowired
    private WorkplaceRepository workplaceRepository;

    public void addInspector(Inspector inspector) {
        inspectorRepository.save(inspector);
    }

    public Inspector getInspector(long id) {
        return inspectorRepository.findById(id).orElseThrow();
    }

    public List<Inspector> getAllInspectors() {
        Iterable<Inspector> inspectorsIterator = inspectorRepository.findAll();
        List<Inspector> inspectors = StreamSupport
                .stream(inspectorsIterator.spliterator(), false)
                .collect(Collectors.toList());
        return inspectors;
    }

    public void putInspector(long id, Inspector inspector) {
        Inspector i = inspectorRepository.findById(id).orElseThrow();
        i.setFirstName(inspector.getFirstName());
        i.setLastName(inspector.getLastName());
        i.setBirthDate(inspector.getBirthDate());
        inspectorRepository.save(i);
    }

    public void addWorkplace(long inId, long woId) {
        Inspector i = inspectorRepository.findById(inId).orElseThrow();
        Workplace w = workplaceRepository.findById(woId).orElseThrow();
        i.addWorkplace(w);
        inspectorRepository.save(i);
    }

    public Inspector addInspector(long id, String firstName, String lastName, LocalDate birthDate){
        Inspector i = new Inspector();
        i.setId(id);
        i.setFirstName(firstName);
        i.setLastName(lastName);
        i.setBirthDate(birthDate);
        return i;
    }
}
