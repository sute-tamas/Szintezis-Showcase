package hu.sutetamas.showcase.Service;

import hu.sutetamas.showcase.Entity.*;
import hu.sutetamas.showcase.Repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public Owner getOwner(long id) {
        return ownerRepository.findById(id).orElseThrow();
    }

    public List<Owner> getAllOwners() {
        Iterable<Owner> ownersIterator = ownerRepository.findAll();
        List<Owner> owners = StreamSupport
                .stream(ownersIterator.spliterator(), false)
                .collect(Collectors.toList());
        return owners;
    }

    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public void putOwner(long id, Owner owner) {
        Owner o = ownerRepository.findById(id).orElseThrow();
        o.setFirstName(owner.getFirstName());
        o.setLastName(owner.getLastName());
        o.setBirthDate(owner.getBirthDate());
        ownerRepository.save(o);
    }

    // ---- FELADAT S -----

    public Owner addOwner(long id, String firstName, String lastName, LocalDate birthDate){
        Owner o = new Owner();
        o.setId(id);
        o.setFirstName(firstName);
        o.setLastName(lastName);
        o.setBirthDate(birthDate);
        return o;
    }
}
