# JEP 377: ZGC GC

https://openjdk.java.net/jeps/377

## Usage
Run `MemoryUsage` with `-Xmx25m`, launch JConsole tool and monitor the process with the default (G1) Garbage Collector.

Run `MemoryUsage` with `-Xmx25m -XX:+UseZGC`, launch JConsole tool and monitor the process with the Z Garbage Collector.