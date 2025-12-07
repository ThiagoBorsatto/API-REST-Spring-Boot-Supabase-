# API-REST SpringBoot with MySQL Database:

##Introduction
This is the final task for the academic subject Object-Oriented Programming (OOP). The objective was to create a REST API using Spring Boot and connect it to a database such as MySQL or PostgreSQL.

The team decided to build the API using a MySQL Database called DrugStore, which was developed for the academic subject Database Design, Development, and Management. The database contains the following tables:

Category

Invoice

InvoiceItems

RegisterClient

RegisterEmployee

RegisterProduct

Some of the tables have one-to-many relationships where we needed to develop the correct coding.

The Controller folder contains all the CRUD operations to manage the table attributes. Here, it's possible to perform:

GET (List all items): Lists all items in the class.

GET (by ID): Lists a specific item in the class by its ID.

POST (Create item): Creates a specific item.

PUT (by ID): Updates a specific item by its ID.

DELETE (by ID): Deletes a specific item by its ID.

Contribution of Each Member:
The Repository was created by Thiago Borsatto, who also invited the other members: Douglas Nolli and Kaue Dimas.

The basic project generated on the Spring Boot Initializr (URL: https://start.spring.io) was set up by Thiago Borsatto and Douglas Nolli using the following configuration:

Project: Maven

Language: Java

Spring Boot: 4.0.0

Packaging: Jar

Configuration: Properties

Java: 17

Codification:
The Entity and Repository folders were developed by Thiago Borsatto, Douglas Nolli, and Kaue Dimas. All members helped with the development, choosing the names, methods, and correcting the syntax.

The Controller folder was created by Thiago Borsatto and Douglas Nolli. Both coded all controllers together, defining the @RestControllers and @RequestMappings.

README: Documentation typed by Thiago Borsatto.

New example of POST: made more readable

http://localhost:8001/api/registerproduct
{
    "idcategory":{
        "idcategory":1 
    },
    "description":"banana",
    "productvalue":9.99
}

http://localhost:8001/api/registerclient
{
    "clientname":"Bill",
    "clientadress":"Texas",
    "clientphone":"11-22-33-44",
    "clientemail":"bill@texas.com"
}

http://localhost:8001/api/registeremployee
{
    "employeename":"Josh",
    "employeeadress":"Washington",
    "employeephone":"22-33-44-55",
    "employeeemail":"josh@washington.com"
}

http://localhost:8001/api/category
{
    "categorydescription": "Category A"
}

http://localhost:8001/api/invoice
{
	"registerclient":{
        "idclient":1
    },
	"registeremployee":{
        "idemployee":1
    },
	"emissiondate":"2025-12-07",
	"invoicevalue":200.00,
    "itens":[]
}

http://localhost:8001/api/invoiceitens
{
	"idinvoiceitens":{
        "idinvoice":10,
        "idproduct":1
    },
    "invoice":{
        "idinvoice":10
    },
    "registerproduct":{
        "idProduct":1
    },
    "productquantity":32
    }

Continue the testing using the POSTMAN web to make shur the GET, POST, PUT and DELETE on invoice, invoiceItens and invoiceIntensPK are working as entended.
The entities register product,registerclient, registeremployee and category has being tested.