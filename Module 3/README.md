# Walmart USA Global Tech Advanced Software Engineering Virtual Experience 
## Task 3: Relational Database Design: Design a relational database to satisfy a complex collection of requirements
#

Your task is to draft a UML class diagram describing the data processors for a pipeline. 
**The component responsible for reading in input data is being designed by another engineer, so you only need to worry about what happens to the data when it reaches your processor. You may assume three classes already exist:**

- **Datapoint:** this class represents both raw and processed data points. Any time data moves between methods you may use this class as an abstraction.

- **ModeIdentifier:** an enum used to identify a processor mode.

- **DatabaseIdentifier:** an enum used to identify a database connection.

#
## Your task is to draft an ERD for an appropriately normalized relational database that satisfies these requirements:

- **The database should store information related to the following products.**
    - **Pet food,** which has a name, manufacturer, weight, flavor, and target health condition.
    - **Pet toys,** which have an associated material, name, manufacturer, and durability.
    - **Pet apparel,** which has a color, manufacturer, size, name, and specific care instructions.
- Each product should be associated with one or more animals.
- Each product should be associated with a manufacturer.
- The database should track customers and their transactions.
    - It should store customer names and email addresses.
    - Customers can make transactions to purchase one or more products.
    - Each transaction should store the date and the products involved.
-   The database should track shipments to various Walmart locations.
    - Each location should be represented by a name and a zip code.
    - A shipment is recorded as an origin, a destination, and a collection of products, each with an associated quantity.
- When you’re finished, convert your ERD to a PDF and submit it below.

**Estimated time for task completion: 45-60 minutes depending on your learning style.**