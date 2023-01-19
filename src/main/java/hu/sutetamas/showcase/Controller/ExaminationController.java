package hu.sutetamas.showcase.Controller;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Service.ExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/examination")
public class ExaminationController {

    @Autowired
    private ExaminationService examinationService;

    @PostMapping()
    public ResponseEntity<String> saveExamination(@RequestBody Examination exam) {
        examinationService.addExamination(exam);
        return new ResponseEntity<String>("Examination added", HttpStatus.OK);
    }

    @GetMapping()
    public List<Examination> getAllExaminations() {
        return examinationService.getAllExaminations();
    }

    @GetMapping("/{id}")
    public Examination getExamination(@PathVariable long id) {
        return examinationService.getExamination(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateExamination(@RequestBody Examination exam, @PathVariable long id) {
        examinationService.putExamination(id, exam);
        return new ResponseEntity<String>("Examination put", HttpStatus.OK);
    }
}
