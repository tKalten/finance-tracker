# finance-tracker
A java application to aid in tracking finances

## Description
The Application reads in txt files containing information regarding date, type and amount of the expense. This expense amount is then aggregated per month and output to a txt file. An additional txt file is written containing all data entries. 

## Usage
Any expense that should be included in the calculation must be placed in the directory `./app/expenses/`. In the first line of the txt the last two numbers of the year are declared (e.g. 2019 -> 19). Next the relevant date is listed and in its subsequent lines the information off the expense followed by the amount of the expense is entered (or in reversed order). Information for different dates is separated by a blank line. To enter information for a different year add another file. The filename itself does not matter.

Example input file:
```sdsd
>19
>20.06
>zug 24,5
>33,5 einkaufmarkt
>
>1.07
>essen 5
```