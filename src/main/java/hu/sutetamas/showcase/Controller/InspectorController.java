package hu.sutetamas.showcase.Controller;

import hu.sutetamas.showcase.Entity.Inspector;
import hu.sutetamas.showcase.Service.InspectorService;
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
        InspectorService.addInspector(inspector);
        return new ResponseEntity<String>("Inspector added", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Inspector getInspector(@PathVariable long id) {
        return InspectorService.getInspector(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateInspector(@RequestBody Inspector inspector, @PathVariable long id) {
        InspectorService.putInspector(id, inspector);
        return new ResponseEntity<String>("Inspector put", HttpStatus.OK);
    }

}
