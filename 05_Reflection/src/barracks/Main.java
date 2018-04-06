package barracks;

import barracks.contracts.Repository;
import barracks.contracts.UnitFactory;
import barracks.core.Engine;
import barracks.core.factories.UnitFactoryImpl;
import barracks.data.UnitRepository;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
		Runnable engine = new Engine(repository, unitFactory);
		engine.run();
	}
}
