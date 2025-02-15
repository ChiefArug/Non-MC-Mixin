package chiefarug.projects.mixinattempt.tweaker;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.config.Configurator;

import java.io.File;
import java.util.List;

/**
 * A tweaker that does nothing except set log level to debug (you'll probably want to remove that)
 * and provides a main class from the program args.
 * Note that this MUST be in its own package or stuff won't work {@see net.minecraft.launchwrapper.Launch#Launch#L122}
 */
@SuppressWarnings("unused") // This is referenced via classpath in the program args
public class PrimaryTweaker implements ITweaker {
    static { // set this as early as possible because log4j is really annoying to configure and this is simpler
        // see https://stackoverflow.com/questions/7126709/how-do-i-set-log4j-level-on-the-command-line
        Configurator.setRootLevel(Level.DEBUG);
    }
    private String target;
    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {
        if (args.isEmpty())
            throw new IllegalArgumentException("Need target launch class!");
        target = args.getFirst(); // Just use the first non consumed arg. It's simple this way
    }

    @Override
    public void injectIntoClassLoader(LaunchClassLoader classLoader) {}

    @Override
    public String getLaunchTarget() {
        return target;
    }

    @Override
    public String[] getLaunchArguments() {
        return new String[0];
    }
}
