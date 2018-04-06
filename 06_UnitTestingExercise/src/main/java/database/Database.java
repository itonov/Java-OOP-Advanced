package database;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<Human> people;

    public Database() {
        this.people = new ArrayList<>();
    }

    public void add(Human personToAdd) throws OperationNotSupportedException {
        if (people.size() == 16 || personToAdd == null || personToAdd.getId() < 0) {
            throw new OperationNotSupportedException();
        } else {
            for (Human person : this.people) {
                if (person.getId() == personToAdd.getId()) {
                    throw new OperationNotSupportedException();
                }
            }
        }

        this.people.add(personToAdd);
    }

    public void remove() throws OperationNotSupportedException {
        if (this.people.size() == 0) {
            throw new OperationNotSupportedException();
        }

        this.people.remove(this.people.size() - 1);
    }

    public Human findByUsername(String username) throws OperationNotSupportedException {
        if (username == null) {
            throw new OperationNotSupportedException();
        }

        for (Human person : this.people) {
            if (person.getUsername().equals(username)) {
                return person;
            }
        }

        throw new OperationNotSupportedException();
    }

    public Human findById(long id) throws OperationNotSupportedException {
        for (Human person : this.people) {
            if (person.getId() == id) {
                return person;
            }
        }

        throw new OperationNotSupportedException();
    }

}
