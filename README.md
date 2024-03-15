# super-market-app

Building a Spring Boot Application for super market.

Current application is using dummy data provided in the code itself. <<TODO: Set up a SQL Database to store, retrieve data related to products and promotional offers>>

Endpoint Details:

# GET-"/products" 
- Fetch list of available Products


# POST-"/products"
- Add new product to list 
- Allowed by only authorised Admin users 
- Must not be exposed to Customers
- This endpoint is not expected as per the business requirement provided
- Need additional handling of authorisation


# POST "/createOrder" - Add product to Cart <<Dev In Progress>>
- Exposed to customers
- Help in adding product to customer's cart
- Must handle the business logic for product offers