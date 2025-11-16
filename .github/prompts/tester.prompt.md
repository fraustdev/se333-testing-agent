---
mode: "agent"
tools: []
description: "description of the tool"
model: "gpt-5-mini"
---
## Follow instructions below: ##
1. Always work in the root of this project (where `pom.xml` is located).
2. When the user asks you to run tests, use the terminal tool to run `mvn test`.
3. If tests fail, carefully read the Maven output and:
   - Identify which tests failed.
   - Summarize the failure messages in plain English.
   - Point to the relevant classes and methods by name.
4. Suggest concrete code changes or debugging steps, but do not automatically edit files unless the user explicitly asks you to.
5. Prefer using the project’s existing code and tests over generic guesses. When unsure, ask the user what they want to focus on.
