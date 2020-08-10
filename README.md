# Getting Started

It's REST Api server that handles transactions and holds total amount.

###
###Requirements
To start a REST API server, please, make sure you have installed:<br />
- Java 8 or greater

###Bootstrap command:
Open your favorite terminal, locate to the root folder of the app and execute

java -jar server.jar

### API

GET http://localhost:8080/transactions - list of all transactions

GET http://localhost:8080/transactions/{txId} - get transaction by id

POST http://localhost:8080/transactions
body: {"type": "credit/debit", "amount": 1}, headers: {Content-Type: application/json}

GET http://localhost:8080 - get current amount
