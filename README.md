# Ecomm-Microservices

Two Microservices have been created (Order-service,product-service) which are communicating with feign client.
--product-service has Product and Product Category.For each Product category we have list of products.In this 
microservice we can create,fetch,update and delete Products.
Suppose we have category type as Electronics and products in it will be TV,Moblie etc.

Json for creating product category-http://localhost:8200/categories
{
"category":"Electronics"
}

Json for creating product-http://localhost:8200/categories/1/products
{
"title":"TV",
"description":"Samsung LED TV are high definition TV",
"price":45000.00
}

fetch::

--Order-service has order and order details.For single orderId we have list of order details.
In this microservice we can create order and fetch the list of product for the provide orderId by communicating with 
product-service using Feign.

Json for creating Order-http://localhost:8300/orders
{
"customerId":1,
"orderStatus":"CREATED",
"totalCost":10000.00
}

Json for creating Order Details-http://localhost:8300/orders/1/details
{
"productId":2,
"categoryId":1,
"cost":100.00
}

Fetch list of Products for given order Id:

http://localhost:8300/orders/1
{"orderId":1,"productDetails":[{"productTitle":"TV","productCost":45000.0}],"totalCost":45000.0}
