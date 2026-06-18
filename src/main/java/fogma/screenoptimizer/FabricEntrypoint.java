package fogma.screenoptimizer;

import fogma.screenoptimizer.optimization.ScreenOptimizer;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FabricEntrypoint implements ModInitializer {
	public static final String MOD_ID = "screenoptimizer";
	public static final String VERSION = "1.0 (26.2 edition)";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("ScreenOptimizer V" + VERSION + " initialized | Hello from Fogma!");
		ScreenOptimizer.start();
	}
}