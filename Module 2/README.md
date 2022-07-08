# Walmart USA Global Tech Advanced Software Engineering Virtual Experience 
## Task 2: Software Architecture: Design a System which satisfies complex database requirements
#
### Your task is to draft a UML class diagram describing the data processors for a pipeline. The component responsible for reading in input data is being designed by another engineer, so you only need to worry about what happens to the data when it reaches your processor. You may assume three classes already exist:

- **Datapoint:** this class represents both raw and processed data points. Any time data moves between methods you may use this class as an abstraction.
- **ModeIdentifier:** an enum used to identify a processor mode.
- **DatabaseIdentifier:** an enum used to identify a database connection.

### Here are the requirements for your design:

- The processor must implement a configure method that accepts a ModeIdentifier and a DatabaseIdentifier as parameters.
- This method is called to change the operating mode of the processor, and/or select the current database.
- The processor must be able to change between the following modes:
    - **Dump mode:** simply drops the data.
    - **Passthrough mode:** inserts the data into the currently configured database.
    - **Validate mode:** validates the data, then inserts it (both operations are carried out on the currently configured database).
- The processor must be able to swap between the following databases. Each database will require a different implementation to insert and validate data
    - Postgres.
    - Redis.
    - Elastic.
- The processor must implement a process method that accepts a DataPoint as a parameter.
- This method will have different behavior depending on the currently configured mode and database.
- There is no need to get into implementation specifics, keep things abstract and high level. For example, you need only specify connect, insert, and validate methods for each database, there is no need to specify how those methods go about performing their verbs. 
- The point of this task is to think about how code is structured. When you’re finished, convert your class diagram to a PDF and submit it below.

**Estimated time for task completion: 45-60 minutes, depending on your learning style.**