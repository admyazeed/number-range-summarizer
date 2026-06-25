# Number Range Summarizer
## Overview
This project implements the NumberRangeSummarizer interface.

The summarizer accepts a comma-separated list of numbers and returns a summarized list in which consecutive values are represented as ranges.

Example

Input:
```
1,3,6,7,8,12,13,14,15,21,22,23,24,31
```
Output:
```
1, 3, 6-8, 12-15, 21-24, 31
```

## Requirements
- Java 21
- Apache Maven 3.9+

Project Structure
```
src/
├── main/
│   └── java/
│       └── numberrangesummarizer/
│           ├── NumberRangeSummarizer.java
│           └── Solution.java
│
└── test/
    └── java/
        └── numberrangesummarizer/
            └── SolutionTest.java
```

## Usage
**Build**
```
mvn compile
```

**Run tests**
Run all tests:
```
mvn test
```
Perform a clean build and run all tests:
```
mvn clean test
```

## Assumptions
1. **No duplicate numbers**: Duplicate numbers in an input string are silently ignored during collection.
2. **Input is sorted**: Numbers are sorted in ascending order during collection.
3. **No invalid characters**: Non-numerical characters are ignored, printing an error message for degbugging.
4. **Input is non-empty**: Summarizing a null or empty collection returns an empty string.
5. **Input numbers are sufficiently small**: Numbers in input do not exceed Integer maximum or minimum values in Java.
