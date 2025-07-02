package org.lms.service;

import org.lms.model.Patron;
import java.util.*;

public class PatronService {
    private Map<String, Patron> patrons = new HashMap<>();

    public void addPatron(Patron patron) {
        patrons.put(patron.getId(), patron);
    }

    public void updatePatron(String id, Patron updatedPatron) {
        patrons.put(id, updatedPatron);
    }

    public Patron getPatron(String id) {
        return patrons.get(id);
    }

    public Collection<Patron> getAllPatrons() {
        return patrons.values();
    }
}
