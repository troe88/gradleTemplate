Feature: Example feature

  @ID-1
  @smoke
  Scenario: Smoke scenario ID-1
    Given Open Portal
    When Search "user_1"

  @ID-2
  @criticalPath
  Scenario: CriticalPath scenario ID-2
    Given Open Portal
    When Search "user_1"

  @ID-3
  @criticalPath
  Scenario: CriticalPath scenario ID-3
    Given Open Portal
    When Search "user_1"
