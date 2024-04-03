
# CatlogManagementSystem

-> This Spring Boot application is designed to Catlog Management System. It is built using Spring Boot "3.2.3".

# Setup Instructions
Prerequisites
Before running the application, ensure you have the following installed:

Java Development Kit (JDK) "1.8.0_381"
Maven "4.0.0"

# API Endpoints:- 

1. Get All Products
Endpoint: /products
Method: GET
Description: Retrieves all products from the database.
Request Parameters: None
Response Format: JSON

[
    {
        "pid": 1,
        "name": "Product 1",
        "description": "Description of Product 1",
        "price": 20.12,
        "quantity": 14
    },
    {
        "pid": 2,
        "name": "Product 2",
        "description": "Description of Product 2",
        "price": 34.2,
        "quantity": 10
    }
]



2. Get Product by ID
Endpoint: /products/{id}
Method: GET
Description: Retrieves a specific product by its ID.
Request Parameters:id (Path Variable): ID of the product to retrieve the Product.
Response Format: JSON

{
    "pid": 1,
    "name": "Product 1",
    "description": "Description of Product 1",
    "price": 20.12,
    "quantity": 14
}




