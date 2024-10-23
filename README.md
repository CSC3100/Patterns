![Static Badge](https://img.shields.io/badge/author-javiergs-orange)
![GitHub repo size](https://img.shields.io/github/repo-size/CSC3100/Patterns)

# Patterns
Examples of design patterns

<br>

## Observer Pattern

The Observer pattern is a behavioral design pattern that defines a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically. This pattern is commonly used in event handling systems and user interfaces to maintain consistency and synchronization between objects. These are some examples of the Observer pattern:

### observer.template

The observer.template package contains template classes and interfaces that define the structure and behavior of the Observer design pattern. This package provides a foundational framework that can be extended and customized for specific use cases, ensuring a consistent implementation of the Observer pattern.

### observer.deprecated

The observer.deprecated package includes legacy implementations (in Java SDK) of the Observer design pattern that are no longer recommended for use. These classes and interfaces are maintained for backward compatibility and historical reference but should be replaced with more modern and efficient implementations found in other packages.

### observer.current

The observer.current package features the latest and most optimized implementations of the Observer design pattern (in Java SDK). This package leverages features and best practices to provide a robust and efficient solution for managing observer-subject relationships.

<br>

## Singleton Pattern

The Singleton pattern is a creational design pattern that ensures a class has only one instance and provides a global point of access to that instance. This pattern is commonly used in scenarios where a single instance of a class is required. These are some examples of the Singleton pattern:

### singleton

The singleton package contains examples of the Singleton design pattern implemented in various ways. These examples demonstrate different approaches to creating a singleton instance, including lazy initialization, eager initialization, and thread-safe initialization.

<br>

## Decorator Pattern

The Decorator pattern is a structural design pattern that allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class. This pattern is commonly used to extend the functionality of existing classes without modifying their structure or behavior directly. These are some examples of the Decorator pattern:

### decorator.template

The decorator.template package contains template classes and interfaces that define the structure and behavior of the Decorator design pattern. This package provides a foundational framework that can be extended and customized for specific use cases, ensuring a consistent implementation of the Decorator pattern.


### decorator.extra

The decorator.extra package includes additional classes and interfaces that extend the functionality of the Decorator design pattern. These classes provide advanced features and optimizations that can be used to enhance the performance and flexibility of decorator-based implementations.

### decorator.companion

The decorator.companion package features companion classes and utilities that support the Decorator design pattern. These classes provide helper methods, shared resources, and other tools that can be used to simplify and streamline the implementation of decorators in various applications.

<br>

# Integrative Examples

Examples that combine multiple design patterns to achieve a cohesive and functional application.

## Project Plotter

The Plotter project/module demonstrates the application of design patterns in a GUI context.
This project serves as an integrative example, combining Singleton, Observer, and Decorator to achieve a cohesive and functional application.


## Project MouseDots

The MouseDots project/module demonstrates the application of design patterns in a GUI context. 
This project serves as an integrative example, combining Singleton and Observer to achieve a cohesive and functional application.
