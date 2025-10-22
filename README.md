# Diplom_2
## Automated UI Tests for "Stellar Burgers"
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
`mvn clean test -Dbrowser=chrome`
### Run Tests in the Yandex Browser
You need to download the [Yandex WebDriver](https://github.com/yandex/YandexDriver/releases) before running the tests.

To run the UI tests in the Yandex browser:
`mvn clean test -Dbrowser=yandex -Dyandex-browser-driver="path/to/yandexdriver" -Dyandex-browser="path/to/Yandex"`

Where:
- `yandex-browser-driver` is the path to the Yandex WebDriver.
- `yandex-browser` is the path to the Yandex browser application.
---
## Allure Report

### Open an Already Generated Report
To open an already generated report, run:  
`allure open target/allure-report`

### Generate New Report
After running all tests, a new Allure report can be generated and opened:  
`allure generate target/allure-results --clean -o target/allure-report`