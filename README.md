# API-REST SpringBoot with MySQL Database:

## SUMMARY

[Introduction](#Introduction)

[SpringBoot Initializr](#SpringBoot-Initializr)

[CRUD-Operations](#CRUD-Operations)

[Configuracion](#Configuracion)

[Members Contribution](#Members-Contribution)

## 1. Introduction

This is the final task for the academic subject Object Oriented Programming(OOP). The objective was to create a REST API using SpringBoot and connect it to a database such as MySQL or PostgreSQL.

The team decided to build the API using a MySQL Database called DrugStore, which was developed for the academic subject Database Design, Development, and Management. The database contains the following tables:

* Category
* Invoice
* InvoiceItems
* RegisterClient
* RegisterEmployee
* RegisterProduct

Some of the tables have one-to-many relationships where we needed to develop the correct coding.

## 2. SpringBoot Initializr

For the basic project generated on the Spring Boot Initializr (URL: https://start.spring.io) was set up using the following configuration:

* Project: Maven
* Language: Java
* Spring Boot: 4.0.0
* Packaging: Jar
* Configuration: Properties
* Java: 17

## 3. CRUD-Operations

The Controller folder contains all the CRUD operations to manage the table attributes. Here, it's possible to perform:

* GET (List all items): Lists all items in the class.
* GET (by ID): Lists a specific item in the class by its ID.
* POST (Create item): Creates a specific item.
* PUT (by ID): Updates a specific item by its ID.
* DELETE (by ID): Deletes a specific item by its ID.

## 4. Configuracion

### Initial Requirement

First thing is configuret the **application.properties** file:

    spring.datasource.url=jdbc:mysql://localhost:3306/drugstore
    spring.datasource.username=root
    spring.datasource.password=(your password goes here)

If you have a password to access the MySQL, is necessary to put on the especifie line, if not is just left empty.

After, go to your MySQL an use the following code to create the database empty: **drugstore**

    CREATE DATABASE drugstore;

### API_REST 

You can start the API using the file **ApiProjectOopApplication.java** on /API-Project_OOP/src/main/java/com/example/APIProjectOOP just press **RUN**. When the API is runnig the backend go create all the tables an attibuts.

### POSTMAN

Now you can use whatever API manager you what, we chose the POSTMAN, just setup and create a workspaces for your API. Add a http protocol, and this is where in going use the controllers.

For all the CRUD operacions we gonna use the URL **http://localhost:8001/api/**, the last part of the URL define what is the table we gon change. 

### Testing and Examples

#### Category

##### GET

To list all the entities on the database just put the URL **http://localhost:8001/api/category** on POSTMAN and set the method to GET. 

To list one specifically entity the URL need to include the Id of the category, example: **http://localhost:8001/api/category/1**, 1 represent the Id.

##### POST

For create a new category you can use URL **http://localhost:8001/api/category**, set the POSTMAN to POST and use the following JSON Syntax:

    {
        "categorydescription": "Category A"
    }

#### UPDATE

To DELETE a determined entity use the example URL **http://localhost:8001/api/category/1** with the POSTMAN set to PUT:

    {
        "categorydescription": "Category A"
    }

##### DELETE

To DELETE a determined entity use the example URL **http://localhost:8001/api/category/1** with the POSTMAN set to DELETE.

### Register Product

URL: **http://localhost:8001/api/registerproduct**

It is just possible to create a product after a category exists, because the product needs an Id_Categoty for the **foreign key**, the syntax for this case is:

    {
        "idcategory":{
            "idcategory":1 
        },
        "description":"banana",
        "productvalue":9.99
    }

### Register Client

URL: **http://localhost:8001/api/registerclient**

Syntax example:
    
    {
        "clientname":"Bill",
        "clientadress":"Texas",
        "clientphone":"11-22-33-44",
        "clientemail":"bill@texas.com"
    }

### Register Employee

URL: **http://localhost:8001/api/registeremployee**

Syntax example:

{
    "employeename":"Josh",
    "employeeadress":"Washington",
    "employeephone":"22-33-44-55",
    "employeeemail":"josh@washington.com"
}

### Invoice

URL: **http://localhost:8001/api/invoice**

Syntax example:

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

### Invoice Itens

URL: **http://localhost:8001/api/invoiceitens**

After the creation of a invoice you can make the relationship with the items using the syntax example:

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

### Invoice Itens PK

This is a special table, represent the relacionship betwee Invoice and Invoice Items, how the Id_Invoice and Id_Product are embed we don't need maje anythig, the backend stipulat the relacion.

## 5. Members Contribution

The Repository was created by Thiago Borsatto, who also invited the other members: Douglas Nolli and Kaue Dimas.

The Entity and Repository folders were developed by Thiago Borsatto, Douglas Nolli, and Kaue Dimas. All members helped with the development, choosing the names, methods, and correcting the syntax.

The Controller folder was created by Thiago Borsatto and Douglas Nolli. Both coded all controllers together, defining the @RestControllers and @RequestMappings.

README: Documentation typed by Thiago Borsatto.
