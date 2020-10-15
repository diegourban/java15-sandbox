# JEP 379: Shenandoah: A Low-Pause-Time Garbage Collector

https://openjdk.java.net/jeps/379

## Usage
Run `MemoryUsage` with `-Xmx25m`, launch JConsole tool and monitor the process with the default (G1) Garbage Collector.

Run `MemoryUsage` with `-Xmx25m -XX:+UseShenandoahGC`, launch JConsole tool and monitor the process with the Shenandoah Garbage Collector.

However, the official OpenJDK 15 build didn’t include the Shenandoah GC (just like what happened in Java 12). 
Read this story – [Not all OpenJDK 12 builds include Shenandoah: Here’s why.](https://developers.redhat.com/blog/2019/04/19/not-all-openjdk-12-builds-include-shenandoah-heres-why/)

To try Shenandoah GC, you need other JDK builds like [AdoptOpenJDK](https://adoptopenjdk.net/).