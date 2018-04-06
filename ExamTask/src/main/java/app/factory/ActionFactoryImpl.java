package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;

import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {
    @Override
    public Action create(String actionName, String... participantNames) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        switch (actionName) {
            case "CreateParticipant":
                break;
            case "CreateAction":
                break;
            case "CreateSpecial":
                break;
            case "StatParticipants":
                break;
            case "StatActions":
                break;
            default:
                return null;
        }

        return null;
    }
}
