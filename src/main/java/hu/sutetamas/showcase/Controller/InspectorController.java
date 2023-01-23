package hu.sutetamas.showcase.Controller;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Service.InspectorService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inspector")
public class InspectorController {

    @Autowired
    private InspectorService inspectorService;

    @PostMapping()
    public ResponseEntity<String> saveInspector(@RequestBody Inspector inspector) {
        inspectorService.addInspector(inspector);
        return new ResponseEntity<String>("Inspector added", HttpStatus.OK);
    }

    @PostMapping("/{inId}/addworkplace/{woId}")
    public ResponseEntity<String> addWorkplace(@PathVariable long inId, @PathVariable long woId) {
        inspectorService.addWorkplace(inId, woId);
        return new ResponseEntity<String>("Workplace added", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Inspector getInspector(@PathVariable long id) {
        return inspectorService.getInspector(id);
    }

    @GetMapping()
    public List<Inspector> getAllInspectors() {
        return inspectorService.getAllInspectors();
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateInspector(@RequestBody Inspector inspector, @PathVariable long id) {
        inspectorService.putInspector(id, inspector);
        return new ResponseEntity<String>("Inspector put", HttpStatus.OK);
    }

}
