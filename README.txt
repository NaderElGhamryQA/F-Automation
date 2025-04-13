🔧 Test Automation Framework:

This project is a dynamic, scalable, and maintainable test automation framework,
designed for both Web UI and API testing.
Built with best practices in mind, it offers flexibility, reusability, and ease of configuration,
making it ideal for cross-environment and cross-browser testing.

✅ Key Features

1-Modular & Maintainable Design

2-Built using the Page Object Model (POM) along with the Builder design pattern for clarity, reusability, and separation of concerns.

3-Fully supports multi-browser execution (Chrome, Firefox, Edge, etc.) via configuration.

4-Supports Parallel execution from test.xml (up to 5 threads), with usage of threadlocals to prevent intercations between drivers calls

🧪 API Testing Support
Integrated REST-assured library for seamless API testing.

Clearly structured test cases with meaningful assertions.

Response models are mapped using POJOs for better readability and validation.

Full support for dynamic test execution based on different API endpoints and payloads.

🖥 Allure Reporting Integration
Allure Reports are included to generate rich, interactive, and visual reports.

Automatically captures and attaches screenshots for failed test cases.

Includes detailed test steps, logs, request/response payloads, and timestamps.

Reports are browser-compatible and easily shareable.

💻 Seamless Setup & Execution
The framework automatically manages browser session setup and teardown.

Easily runnable on different machines with all necessary dependencies pre-bundled using Maven.

📝 Well-Documented & Commented Code
Code is commented and documented to describe the logic and flow of each test, making onboarding new contributors easier.

🔧 Externalized Configuration & Test Data
All test data and configuration settings are externalized to improve maintainability and customization.

To view or modify test data, navigate to:
src/main/resources/Data/Data/data.properties

🔐 Credential Management
You’re encouraged to use your own credentials.

Simply add or update them in the provided data.properties file for secure and personalized test runs.

Project Structure Overview
src
├── main
│   ├── java
│   │   └── API / Web Test Classes
│   └── resources
│       └── Data
│           └── data.properties
├── test
│   └── java
│       └── TestNG Test Suites


🚀 Getting Started
Clone the repo.

Make sure Java 11+ and Maven are installed.

Add your desired credentials in data.properties.

Choose your browser and environment via configuration.

Run the tests using your preferred IDE or command line with Maven.
