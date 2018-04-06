package app.core;

import app.contracts.Battlefield;
import app.contracts.Reader;
import app.contracts.TargetableFactory;
import app.contracts.Writer;
import app.factory.TargetableFactoryImpl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Engine implements app.contracts.Engine {
    private Battlefield battlefield;
    private TargetableFactory targetableFactory;
    private Reader reader;
    private Writer writer;

    public Engine(Reader reader, Writer writer) {
        this.reader = reader;
        this.writer = writer;
    }

    @Override
    public void run() throws IOException {
        this.targetableFactory = new TargetableFactoryImpl();
        this.battlefield = new BattlefieldImplementation(this.writer, this.targetableFactory);

        String input = this.reader.readLine();
        while (!"peace".equalsIgnoreCase(input)) {
            String[] tokens = input.split("\\s+");
            String action = tokens[0];

            switch (action) {
                case "CreateParticipant":
                    this.battlefield.createParticipant(tokens[1], tokens[2]);
                    break;
                case "CreateAction":
                    List<String> participants = Arrays.asList(tokens).subList(2, tokens.length);
                    this.battlefield.createAction(tokens[1], participants.toArray(new String[0]));
                    break;
                case "CreateSpecial":
                    try {
                        this.battlefield.createSpecial(tokens[1], tokens[2]);
                    } catch (UnsupportedOperationException uoe) {

                    }
                    break;
                case "StatParticipants":
                    this.battlefield.reportParticipants();
                    break;
                case "StatActions":
                    this.battlefield.reportActions();
                    break;
            }
            input = this.reader.readLine();
        }
    }
}
