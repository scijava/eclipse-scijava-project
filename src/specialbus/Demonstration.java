package specialbus;

import org.scijava.Context;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.PluginService;
import org.scijava.plugin.SciJavaPlugin;

public class Demonstration {

	public static void main(final String... args) {
		final Context context = new Context();
		final PluginService plugins = context.getService(PluginService.class);
		for (final Greeting greeting : plugins.createInstancesOfType(Greeting.class)) {
			System.out.println("Class " + greeting.getClass().getName()
					+ " says " + greeting.sayHello());
		}
	}

	@Plugin(type = Greeting.class)
	public static class BugsBunny implements Greeting {

		@Override
		public String sayHello() {
			return "Hey! What's up, doc?";
		}

	}

	public interface Greeting extends SciJavaPlugin {
		String sayHello();
	}
}
