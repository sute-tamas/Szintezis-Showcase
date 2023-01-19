package hu.sutetamas.showcase.Controller;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Entity.Workplace;
import hu.sutetamas.showcase.Service.WorkplaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workplace")
public class WorkplaceController {

    @Autowired
    private WorkplaceService workplaceService;

    @PostMapping()
    public ResponseEntity<String> saveWorkplace(@RequestBody Workplace workplace) {
        workplaceService.addWorkplace(workplace);
        return new ResponseEntity<String>("Workplace added", HttpStatus.OK);
    }

    @GetMapping()
    public List<Workplace> getAllWorkplaces() {
        return workplaceService.getAllWorkplaces();
    }

    @GetMapping("/{id}")
    public Workplace getWorkplace(@PathVariable long id) {
        return workplaceService.getWorkplace(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateWorkplace(@RequestBody Workplace workplace, @PathVariable long id) {
        workplaceService.putWorkplace(id, workplace);
        return new ResponseEntity<String>("Workplace put", HttpStatus.OK);
    }

}
