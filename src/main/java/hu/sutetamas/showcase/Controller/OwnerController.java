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
        ownerService.addOwner(owner);
        return new ResponseEntity<String>("Owner added", HttpStatus.OK);
    }

    @GetMapping()
    public List<Owner> getAllOwners() {
        return ownerService.getAllOwners();
    }

    @GetMapping("/{id}")
    public Owner getOwner(@PathVariable long id) {
        return ownerService.getOwner(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateOwner(@RequestBody Owner owner, @PathVariable long id) {
        ownerService.putOwner(id, owner);
        return new ResponseEntity<String>("Owner put", HttpStatus.OK);
    }

}
