Feature: Taux de Change

Scenario: Creation Taux de Change
Given creation d'un taux de change
When taux devient persistant
Then le taux es bien dans la base