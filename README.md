# Java Selenium Automation Suite

End-to-end UI test automation suite built with Java 17, Selenium WebDriver 4,
and TestNG, targeting [the-internet.herokuapp.com](https://the-internet.herokuapp.com) -
a site purpose-built for demonstrating browser automation skills.

This project is a Java/TestNG/Maven implementation of the same test suite I built
in [Python/Pytest/Selenium](https://github.com/prashantibhatt04/python-selenium-automation-suite),
demonstrating the ability to work across both automation stacks.

## Tech Stack
- Java 17
- Selenium WebDriver 4
- TestNG
- Maven
- Page Object Model (POM)
- Extent Reports (HTML reporting)
- Jenkins ready (Jenkinsfile included)
- GitHub Actions (CI/CD)

## Test Coverage

| Module          | Tests | Concepts Covered                         |
|-----------------|-------|------------------------------------------|
| Login           | 3     | Form input, valid/invalid credentials, flash messages |
| Dropdown        | 2     | Select element handling                  |
| Checkboxes      | 3     | Default state assertions, toggling state |
| Dynamic Loading | 2     | Explicit waits, dynamic content detection |
| File Upload     | 1     | File path handling, upload confirmation  |

**Total: 11 tests across 5 modules**

## Design Patterns
- **Page Object Model (POM)** : each page has its own class, keeping tests clean and maintainable
- **BaseDriver** : browser setup and teardown handled centrally via TestNG @BeforeMethod/@AfterMethod, equivalent to Pytest fixtures
- **Explicit waits** : used for dynamic content instead of unreliable sleep() calls
- **Headless Chrome** : tests run without opening a browser window, CI/CD compatible
- **TestNG groups** : tests organized into smoke and regression suites via testng.xml

## How to Run Locally

```bash
git clone https://github.com/prashantibhatt04/java-selenium-automation-suite.git
cd selenium-suite
mvn clean test
```

Report is generated at: `reports/ExtentReport.html` — open in any browser to view results.

## CI/CD
Tests run automatically on every push via GitHub Actions.
See the [Actions tab](https://github.com/prashantibhatt04/java-selenium-automation-suite/actions) for live results.
A `Jenkinsfile` is also included for Jenkins pipeline integration.

## Project Structure

```
├── src/main/java/com/tdqa/
│   ├── base/BaseDriver.java        # Browser setup/teardown (TestNG)
│   └── pages/                      # Page Object classes
│       ├── LoginPage.java
│       ├── DropdownPage.java
│       ├── CheckboxesPage.java
│       ├── DynamicLoadingPage.java
│       └── UploadPage.java
├── src/test/java/com/tdqa/
│   ├── tests/                      # Test classes
│   │   ├── LoginTest.java
│   │   ├── DropdownTest.java
│   │   ├── CheckboxesTest.java
│   │   ├── DynamicLoadingTest.java
│   │   └── UploadTest.java
│   └── listeners/                  # Extent Reports listener
│       └── ExtentReportListener.java
├── reports/                        # Generated HTML reports (git ignored)
├── testng.xml                      # Suite config (smoke + regression groups)
├── Jenkinsfile                     # Jenkins CI pipeline
├── test_upload.txt                 # Sample file used by upload test
└── pom.xml                         # Maven dependencies
```