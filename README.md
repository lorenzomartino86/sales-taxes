[![Build Status](https://travis-ci.org/lorenzomartino86/sales-taxes.svg?branch=master)](https://travis-ci.org/lorenzomartino86/sales-taxes)

# SalesTaxes

Application goal is to solve the problem of "SALES TAXES": Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

This application calculates and prints out the receipt details for input shopping baskets.

## Examples

INPUT:

Input 1:

1 book at 12.49

1 music CD at 14.99

1 chocolate bar at 0.85

Input 2:

1 imported box of chocolates at 10.00

1 imported bottle of perfume at 47.50

Input 3:

1 imported bottle of perfume at 27.99

1 bottle of perfume at 18.99

1 packet of headache pills at 9.75

1 box of imported chocolates at 11.25

OUTPUT

Output 1:

1 book : 12.49

1 music CD: 16.49

1 chocolate bar: 0.85

Sales Taxes: 1.50

Total: 29.83

Output 2:

1 imported box of chocolates: 10.50

1 imported bottle of perfume: 54.65

Sales Taxes: 7.65

Total: 65.15

Output 3:

1 imported bottle of perfume: 32.19

1 bottle of perfume: 20.89

1 packet of headache pills: 9.75

1 imported box of chocolates: 11.85

Sales Taxes: 6.70

Total: 74.68


### Architecture
Project has been designed with builder and visitor patterns.
Following class diagram resumes overall architecture of this project:
![Alt text](/etc/class-diagram.png "sales-taxes")

### Assumptions

- Price given in input is assumed to be the unitarian price


### Installation

- clone project from github

```
git clone https://github.com/stonebreakers/sales-taxes
```

- build project by command (and force execution of Junit test classes)

```
mvn clean package
```

### Running the Application

mvn generates a jar file containing all jar dependencies that can be executed to run the application using one of following command line argument:
- get the help application by command:

```
java -jar target/sales-taxes-1.0.0-jar-with-dependencies.jar -h
```
- run application with hard coded data:

```
java -jar target/sales-taxes-1.0.0-jar-with-dependencies.jar -a
```

- run with data inserted on command line:

```
java -jar target/sales-taxes-1.0.0-jar-with-dependencies.jar -b
```
