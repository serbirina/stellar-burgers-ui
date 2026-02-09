# Automated UI Tests for "Stellar Burgers"
Automated UI tests cover the registration and user login scenarios and navigation between different categories in the Constructor section.
Tests are implemented with Java, JUnit, Selenium, and generate Allure reports.
---
## Tech Stack

| Technology     | Version   |
|----------------|-----------|
| Java           | 11        |
| Maven          | 3.9.10    |
| JUnit          | 4.13.1    |
| RestAssured    | 5.2.0     |
| Gson           | 2.8.9     |
| AspectJ Weaver | 1.9.7     |
| Maven Surefire | 3.2.5     |
| Allure         | 2.16.0    |
| Selenium       |  4.37.0   |
---
## Run Tests
---
### Run Tests in the Chrome Browser
To run the UI tests in the Chrome browser:
```
mvn clean test -Dbrowser=chrome
```
### Run Tests in the Yandex Browser
You need to download the [Yandex WebDriver](https://github.com/yandex/YandexDriver/releases) before running the tests.

To run the UI tests in the Yandex browser:
```
mvn clean test -Dbrowser=yandex -Dyandex-browser-driver="path/to/yandexdriver" -Dyandex-browser="path/to/Yandex"
```

Where:
- `yandex-browser-driver` is the path to the Yandex WebDriver.
- `yandex-browser` is the path to the Yandex browser application.
---
## Allure Report

### Open an Already Generated Report
To open an already generated report, run:
- To open the Allure report for the Chrome browser:
```
allure open target/allure-report/chrome
```
- To open the Allure report for the Yandex browser:
```
allure open target/allure-report/yandex
```

### Generate New Report
After running all tests, you can generate Allure reports for different browsers:
- Generate report for Chrome browser
```
allure generate target/allure-results/chrome --clean -o target/allure-report/chrome
```
- Generate report for Yandex browser
```
allure generate target/allure-results/yandex --clean -o target/allure-report/yandex
```
