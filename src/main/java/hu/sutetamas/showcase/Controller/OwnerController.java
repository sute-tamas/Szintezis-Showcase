package hu.sutetamas.showcase.Controller;

import hu.sutetamas.showcase.Entity.Examination;
import hu.sutetamas.showcase.Entity.Owner;
import hu.sutetamas.showcase.Service.ExaminationService;
import hu.sutetamas.showcase.Service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping()
    public ResponseEntity<String> saveOwner(@RequestBody Owner owner) {
        OwnerService.addOwner(owner);
        return new ResponseEntity<String>("Owner added", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Owner getOwner(@PathVariable long id) {
        return OwnerService.getOwner(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOwner(@RequestBody Owner owner, @PathVariable long id) {
        OwnerService.putOwner(id, owner);
        return new ResponseEntity<String>("Owner put", HttpStatus.OK);
    }

}
