package database;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private static final long NEGATIVE_ID = -1L;
    private static final long ID_TO_FIND = 1L;
    private static final String USERNAME_TO_FIND = "Pesho";

    private Database database;

    @Before
    public void initialize() {
        this.database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkIfAddCommandBlocksNull() throws OperationNotSupportedException {
        Human humanToAdd = null;
        this.database.add(humanToAdd);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void checkIfAddCommandBlocksNegativeId() throws OperationNotSupportedException {
        Human humanToAdd = Mockito.mock(Human.class);
        Mockito.when(humanToAdd.getId()).thenReturn(NEGATIVE_ID);
        this.database.add(humanToAdd);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addCommandThrowsExceptionIfDatabaseIsFull() throws OperationNotSupportedException {
        Human humanToAdd = Mockito.mock(Human.class);
        for (int i = 0; i <= 17; i++) {
            this.database.add(humanToAdd);
        }
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeThrowsExceptionIfDatabaseIsEmpty() throws OperationNotSupportedException {
        this.database.remove();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameWithMissingUsername() throws OperationNotSupportedException {
        this.database.findByUsername(USERNAME_TO_FIND);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByUsernameWithNullParameter() throws OperationNotSupportedException {
        this.database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void findByIdWithMissingId() throws OperationNotSupportedException {
        this.database.findById(ID_TO_FIND);
    }
}