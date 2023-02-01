# Spring Boot Order Project

![order_image](/screenshot/image.png)

#### It is a simple order application developed using the following technologies.

- Java 19
- Spring Framework
- Spring Boot
- Spring MVC
- Spring Data
- Spring Rest
- MySQL 8

---

## Lesson Steps

- Spring Framework
- Spring Boot
- Spring MVC
- Spring Data (Jpa Hibernate)
- Spring Rest

---

# Screenshot

- Database Screenshot

|                Database                 |
|:---------------------------------------:|
| [Create](screenshot/CreateDatabase.png) |

- Postman Screenshot

|                              Customer                              |                            Order                             |
|:------------------------------------------------------------------:|:------------------------------------------------------------:|
|          [Create](screenshot/Customer/CreateCustomer.png)          |         [Create](screenshot/Order/CreateOrder.png/)          |
|            [List](screenshot/Customer/ListCustomer.png)            |            [List](screenshot/Order/ListOrder.png)            |
|          [Update](screenshot/Customer/UpdateCustomer.png)          |          [Update](screenshot/Order/UpdateOrder.png)          |
|          [Delete](screenshot/Customer/DeleteCustomer.png)          |          [Delete](screenshot/Order/DeleteOrder.png)          |
|    [No Order Customer](screenshot/Customer/NoOrderCustomer.png)    |   [Order ID Is Empty](screenshot/Order/OrderIdIsEmpty.png)   |
| [Customer ID Is Empty](screenshot/Customer/CustomerIdIsEmpty.png)  |  [Search Date Order](screenshot/Order/SearchDateOrder.png)   |
| [Search Name Customer](screenshot/Customer/SearchNameCustomer.png) |                   |

---

## Run Project

```
1.STEP

    MySQL (QUERY) --> CREATE DATABASE deneme_db;

```

```
2.STEP

    application.properties --> ddl-auto = create

```

```
3.STEP

    SpringBootApplication --> Run

```

```
4.STEP

    application.properties --> ddl-auto = update

```

## POSTMAN

### Customer

```
//LIST
http://localhost:8080//api/v1/customers


//CREATE
http://localhost:8080//api/v1/customers
        {
            "name": "furkan123",
            "age": 21
        }


//FIND
http://localhost:8080//api/v1/customers/1


//UPDATE
http://localhost:8080//api/v1/customers/1
        {
            "name": "furkan123",
            "age": 21
        }


//DELETE
http://localhost:8080//api/v1/customers/1


//LIST NO ORDERS
http://localhost:8080/api/v1/customers/noorders


//SEARCH CUSTOMER
http://localhost:8080/api/v1/cutomers/name/fur


```

### Order

```
//LIST
http://localhost:8080//api/v1/orders


//CREATE
http://localhost:8080//api/v1/orders
        {
		    "totalPrice": 2000,
		    "customerId": 1
        }


//FIND
http://localhost:8080//api/v1/orders/1


//UPDATE
http://localhost:8080//api/v1/orders/1
        {
		    "totalPrice": 2000,
		    "customerId": 1
        }


//DELETE
http://localhost:8080//api/v1/orders/1


//SEARCH ORDER
http://localhost:8080/api/v1/orders/date/2023-01-24

```

---
# License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details

Created by [Mehmet Furkan KAYA](https://www.linkedin.com/in/mehmet-furkan-kaya/)
