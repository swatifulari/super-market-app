# super-market-app

Building a Spring Boot Application for super market.

Current application is using dummy data provided in the code itself. 



Endpoint Details:

# GET-"/products" 
- Fetch list of available Products


# POST-"/products"
- Add new product to list 
- Allowed by only authorised Admin users 
- Must not be exposed to Customers
- This endpoint is not expected as per the business requirement provided but still added
- Need additional handling of authorisation


# POST "/createOrder"
- Exposed to customers
- Creates Customers Cart
- Handles the business logic for product offers


# Future Enhancements
- In this code, data is hard coded in ProductService class, which can be also picked from application.properties
- Best way is to use of Database like SQL to store, retrieve data related to application.
- For POST - createOrder functionality , handle customerId. Endpoint must be like /{customerId}/createOrder.
- Update Error Handling - Assumed that user will input all correct and tested happy flow conditions.
- Creating RAML or OAS specification for API Contracts
- Integrating with swagger will help user to execute these APIs
- Write Junits to test the code - Spring MockMvc can be used
