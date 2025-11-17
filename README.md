Intelligent Testing Agent with MCP Tools
Author: Frida Frausto
Course: SE 333 - Software Testing
Final Project - Fall 2025

1. Overview
This project implements an intelligent testing agent using Machine Control Protocol (MCP) tools, a Python-based server, and a lightweight LLM. The agent can analyze Java source code, generate new tests, evaluate coverage with JaCoCo, and automate Git workflows.
It was designed to improve the testing quality of the Apache Commons Lang codebase by iteratively generating tests, detecting gaps, and increasing coverage.

This README documents how to run the tools, how the system works, and how to reproduce the improvements shown in the demo video.

2. Features Implemented

Tool Name:                      Purpose:

hello                           Simple connection test for the MCP server
calcualte                       Demo mathematical evaluator    
analyze_java_file               Reads java code and extracts metadata(lines, characters, etc.)
generate_junit_tests            Generates smoke tests based on method signatures
run_maven_tests                 Executes mvn test and returns results
analyze_coverage                Parse JaCoCo XML and return uncovered classes/methods with recommendations.
git_status                      Return git status output
git_add_all                     Stage all changes except build artifacts
git_commit                      Commit staged changes
git_push                        Push commits to the remote repository
git_pull_request                Simulate creation of a pull request
coverage_report                 Check for jacoco.xml and return basic stats
test_metrics                    Compute simple test quality metrics from JaCoCo (lines, covered, % estimate)
detect_flaky_tests              Runs a test class multiple times and reports if results are inconsistent.
mutation_check            Performs a simple mutation test on the file: Flips '==' to '!=' in the first occurrence and checks whether tests fail

3. Setup Instructions

A. Requirements
    - Python 3.12+
    - Java 8 or higher
    - Maven installed (mvn -v should work)
    - Git installed & configured

B. Running the MCP Server
    1. Navigate to your server folder
    2. Start the server: python server.py
    3. You should see: FASTMCP - Server running at http://127.0.0.1:8000/sse

4. How to use teh MCP Tools

Analyze a Java File
- Call analyze_java_file with path = "<absolute path to java file>"

Generate JUnit Tests
- Call generate_junit_tests with path = "<absolute path>"

Run Maven Tests
- Call run_maven_tests

analyze_coverage
-report_path = "<absolute path to jacoco.xml>"

coverage_report
- Call coverage_report

test_metrics
- Call test_metrics after running Maven tests and coverage

detect_flaky_tests
- test_command "mvn test - Dtest=SomeGeneratedTest and runs = 5

mutation_check
- Call mutation_check with target_path = "<java file or class>"



4. Reproducing the Coverage Improvements
    1. Run generated smoke tests
    2. Open JaCoCo report: 
        target/site/jacoco/index.html
    3. Open in browser
    4. Note instruction & branch coverage
    5. Use analyze -> generate tests -> run tests -> coverage loop
    6. Confirm improvements


5. Troubleshooting

Issue:                          Fix:

Port 8000 already in use        Run `netstat-ano
JaCoCo XML missing              Run mvn clean test first
Tools not showing               Reload MCP servers in VS Code Command Palette


Final Notes
This project demonstrates an end-to-end automated testing workflow enhanced by LLM-powered test generation and version control automation. All features shown in the video and described in the reflection have been implemented and commited.

