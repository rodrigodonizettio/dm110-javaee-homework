# DM110 Final Home Work

- REST CRU for DB requests to support the Product Service. (It requires the use of Stateless Session Bean)
- Message Driven Bean (MDB) that consumes and Auditing queue registers (log system)
- Data persistence in Relational DB


Tiago Carvalho
18/11/2019:

- After changing the product database, a message is sent and received by mdb classes. But just debug yet.

- Don´t forget to create the queue productqueue, according to "Prática Aula 3 - Configuração das filas JMS no WildFly (via CLI)_19855.pdf" document.

- Changed "persistence.xml" to automatically create the database tables if does not exists.

- No Data handler yet.