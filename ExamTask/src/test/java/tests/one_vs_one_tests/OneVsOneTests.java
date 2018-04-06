package tests.one_vs_one_tests;

import app.contracts.Action;
import app.contracts.Hero;
import app.contracts.Targetable;
import app.models.actions.OneVsOne;
import app.models.participants.Warrior;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.List;

public class OneVsOneTests {
    private static final String WRONG_NUMBER_OF_PARTICIPANTS = "There should be exactly 2 participants for OneVsOne!";

    private Action duel;

    @Before
    public void initialize() {
        this.duel = new OneVsOne();

    }

    @Test(expected = OperationNotSupportedException.class)
    public void executeActionWithNullParams() throws OperationNotSupportedException {
        this.duel.executeAction(null);
    }

    @Test
    public void testOneVsOneWithWrongNumberOfParticipants() throws OperationNotSupportedException {
        List<Targetable> oneWarr = new ArrayList<>();
        oneWarr.add(new Warrior());
        String result = this.duel.executeAction(oneWarr);
        Assert.assertEquals("OneVsOne is able to start with wrong number of participants",
                WRONG_NUMBER_OF_PARTICIPANTS, result);
    }

    @Test
    public void firstHeroDiesInFight() throws OperationNotSupportedException {
        List<Targetable> participants = new ArrayList<>();
        Hero firstParticipant = new Warrior();
        Hero secondParticipant = new Warrior();
        firstParticipant.setName("ivan");
        secondParticipant.setName("gosho");

        firstParticipant.setHealth(10.0);
        secondParticipant.setHealth(100.0);

        secondParticipant.setDexterity(10);
        secondParticipant.setIntelligence(10);
        secondParticipant.setStrength(10);

        participants.add(firstParticipant);
        participants.add(secondParticipant);

        String result = this.duel.executeAction(participants);
        String expectedResult = "ivan attacked!\r\ngosho attacked!ivan has been slain by gosho.\r\ngosho is victorious!";
        Assert.assertEquals("OneVsOne fight isn't working", expectedResult + System.lineSeparator(),
                result);
    }

    @Test
    public void secondHeroDiesInFight() throws OperationNotSupportedException {
        List<Targetable> participants = new ArrayList<>();
        Hero firstParticipant = new Warrior();
        Hero secondParticipant = new Warrior();
        firstParticipant.setName("ivan");
        secondParticipant.setName("gosho");

        firstParticipant.setHealth(100.0);
        secondParticipant.setHealth(10.0);

        firstParticipant.setDexterity(10);
        firstParticipant.setIntelligence(10);
        firstParticipant.setStrength(10);

        participants.add(firstParticipant);
        participants.add(secondParticipant);

        String result = this.duel.executeAction(participants);
        String expectedResult = "ivan attacked!gosho has been slain by ivan.\r\nivan is victorious!";
        Assert.assertEquals("OneVsOne fight isn't working", expectedResult + System.lineSeparator(),
                result);
    }
}
