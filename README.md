# Welcome!

Hi teachers! The project structure is a little weird because we wanted to use JMH to benchmark, and that requires a specific project structure.

- `Main.java` is a placeholder - it doesn't particularly do anything.
- All our "coding" files are in `src/main/java/bench`.
- To compile the code, run `mvn -DskipTests package` (note: you need to have Maven installed)
- To run the code, use `java -jar target/stackingQueues-1.0-SNAPSHOT-bench.jar -prof gc`
- If you don't have Maven installed, you can also use the provided `BENCH.jar` file in the root folder after downloading the project
- You can also run the Stack and Queue classes directly like a normal Java file - through the `Main.java` file if you desire - just ensure that they are correctly imported