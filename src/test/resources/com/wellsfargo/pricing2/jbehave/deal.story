Feature: Deal test

Scenario: all deal test
Given user request for all deals
Then there should be following deals
| dealId | edn | currentAppliedScenarioId |
|1 | 1 | 1|
|2 | 2 | 2|
|3 | 3 | 3|

Scenario: single deal test
Given user requests for loan 1
Then loan with edn 1 should be returned