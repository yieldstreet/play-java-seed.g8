## Running
First, copy `.env.example` to `.env` if the latter doesn't already exist. Then run:

```
sbt $name$-play/run
```

If you're using IntelliJ IDEA, create a new Run Configuration of type "sbt Task", and use `$name$-play/run` as the task name. This multi-project build isn't supported by IDEA's "Play 2 App" type.

Configuration is done by setting environment variables; don't modify `application.conf` for development needs. Instead, make sure that every configuration value that needs to be changed can be set from an environment variable, and edit `.env` with your overrides. 
