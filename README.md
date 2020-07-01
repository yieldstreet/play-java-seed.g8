# play-java-seed.g8

Giter8 template for generating a Yieldstreet Play project in Java.

It's a fork of Play's [play-java-seed.g8](https://github.com/playframework/play-java-seed.g8) with a number of additions relevant for our organization, namely:

* Use `YieldstreetPlayPlugin` instead of `PlayJava`. The latter includes HTML templates and other features that we won't need. `YieldstreetPlayPlugin` is based on `PlayService` and `RoutesCompiler`, providing a leaner base more appropriate for micro-services.
* Add [sbt-protoc](https://github.com/thesamet/sbt-protoc) plugin to compile protocol buffers.
* Add [sbt-dotenv](https://github.com/mefellows/sbt-dotenv) plugin to read environment variables from `.env`.
* Add Lagom's JDBC persistence module. Lagom is a fantastic solution for event-based, CQRS enabled systems like what we're trying to do. Unfortunately, Lagom's service interface is clunky and hides too much of the HTTP protocol. Through some experimentation, we've arrived at a hybrid solution based on Play instead of Lagom, but pulling in Lagom's persistence module for CQRS. This requires some additional configuration, all provided in this template.
* Define separate API and implementation projects. The API project should contain classes shared with clients, like protocol buffers and other model classes.
