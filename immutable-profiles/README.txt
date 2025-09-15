Exercise B: Immutable Profiles

Objective:
Refactor UserProfile to be an immutable class with a Builder pattern, improving design and validation.

Key Tasks:
1. Convert UserProfile to immutable (private final fields, remove setters)
2. Create Builder with:
   - Required: id, email
   - Optional: phone, displayName, address, marketingOptIn, twitter, github
3. Centralize validation in Builder.build() method
4. Update ProfileService to prevent post-creation mutations

Build/Run Instructions:
  cd immutable-profiles/src
  javac com/example/profiles/*.java TryIt.java
  java TryIt