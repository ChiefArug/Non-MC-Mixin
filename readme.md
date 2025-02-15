# Mixin Attempt
#### A basic example of using Mojang's LaunchWrapper to launch an arbitrary program with mixins targetting it.

The key thing that makes most of this work is the program arguments, which are configured as an IntelliJ run located at `.idea/runConfigurations/Launch.xml`
They are also explained further on.

## Launching the built jar
For ease of use, this project has shadow jar set up, to build a jar run `gradle shadowJar`, then the build jar will be in `build/libs/` and have the `-all` postfix.
This jar can just be run directly from the commandline with arguments appended after it, like so:
`java -jar MixinAttempt-1.0-SNAPSHOT-all.jar -tweakClass chiefarug.projects.mixinattempt.tweaker.PrimaryTweaker -tweakClass org.spongepowered.asm.launch.MixinTweaker chiefarug.projects.mixinattempt.Main --mixin.config mixinattempt.mixins.json`

## Arg explanations

- `-tweakClass chiefarug.projects.mixinattempt.tweaker.PrimaryTweaker`
  - The tweak class that provides the launch target, taken from the args. This happens because it is the first tweak class defined.
- `-tweakClass org.spongepowered.asm.launch.MixinTweaker`
  - The mixin tweak class. This makes mixin work, but if left as the primary (first) tweak class will attempt to launch `net.minecraft.client.main.Main`.
- `chiefarug.projects.mixinattempt.Main`
  - The target class, this is used by `PrimaryTweaker` to say what to launch. This just needs to be the first non launchwrapper arg. This class should have a `public static void main(String[] args)` method.
- `--mixin.config mixinattempt.mixins.json`
  - Adds the mixin config for mixin to use. Multiple of these can be added to have multiple mixin configs.
