# Clock Application

This Java project entails the development of a clock application that supports both French and Anglo-Saxon display formats. The implementation relies on the Singleton and Observer design patterns. And a user interface (UI) has been created to effectively display the time.

## Singleton Pattern

The Singleton pattern ensures that a class has only one instance and provides a global point of access to that instance. In the context of this project, the Singleton pattern guarantees that there is only one instance of the clock application throughout its lifecycle.

## Observer Pattern

The Observer pattern establishes a one-to-many dependency between objects. When one object changes its state, all its dependents are notified and updated automatically. In this project, the Observer pattern allows the UI to observe changes
