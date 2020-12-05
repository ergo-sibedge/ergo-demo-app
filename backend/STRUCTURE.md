# Project structure

The main project parts can be approximately illustrated as the following tree of folders:

```text
. (src/main/java/com/sibedge/leadmatch)
│
├── api                  (1)
├── core                 (2)
│   ├── component        (3)
│   │   ├── component_a
│   │   │   └── domain
│   │   └── component_b
│   │       └── domain
│   ├── shared           (4)
│   │   └── domain
│   ├── tool             (5)
│   └── usecase          (6)
├── extension            (7)
└── infrastructure       (8)
```

(1) `api` accommodates *the primary (driving) adapters* that exploit *a use case* to tell the core what to do. (this
package defines all APIs for ingoing communication supported by the application - e.g. REST-controllers). In other
words, the package exposes the public entry points for all external clients.

(2) `core` is a home for *the application core*. It includes all *ports* (use case and tool specifications) for
interacting with *primary* and *secondary* adapters and contains cross-component classes and components.

(3) `component` includes use case implementations. Typically, this is a set of components where each one implements one
or more use cases and defines *entities* and *domain services*.

(4) `shared` (a.k.a shared kernel) includes all cross-component classes that can be reused within application services
(e.g. DTOs).

(5) `tool` specifies interfaces to be implemented by the *secondary (driven) adapters*. Typically, it contains all
specifications for external system infrastructure required by the application (they can be databases, message brokers,
SMS gates, external systems, and so on).

(6) `usecase` specifies all features provided by the application via interfaces. The `api` package is the main consumer
of it that delegates user requests to a particular use case to be performed.

(7) `extension` is a home for any convenient utilities and helper classes.

(8) `infrastructure` contains *the secondary (driven) adapters* that implement the specifications defined at `tool`
package for interacting with external services (it usually includes 3rd party libraries, such as database connectivity,
message buses, SMS providers and so on).

This structure partly respects the *Clean architecture* where there is the *Core* which contains domain entities as well
as all application use cases required to fulfill business needs. Being the most internal layer, *the core* provides
interfaces to the outer world: one to process ingoing requests (various API such as REST, CLI and so on) providing
*use case contracts*; one to ask external system for something using *tool contracts* that have to be implemented by the
infrastructure side.

To sum it up, the simplified control flow can be drawn as:

```text
 user request   +----------------+  call use case  +----------+ (opt. use tools)   +------------+
--------------> |                | --------------> |          | - - - - - - - - -> |            |
 user response  | API (i.e. WEB) |  response       | Use case |  (response)        | ext. tools |
<-------------- |                | <-------------- |          | <- - - - - - - - - |            |
                +----------------+                 +----------+                    +------------+
```
