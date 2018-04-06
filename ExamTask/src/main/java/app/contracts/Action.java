package app.contracts;

import javax.naming.OperationNotSupportedException;
import java.util.List;

public interface Action {
    String executeAction(List<Targetable> participants) throws OperationNotSupportedException;
}
