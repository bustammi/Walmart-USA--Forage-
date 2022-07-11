/*
Task 3 - Relational Database Design (ERD TO MySQL Conversion)
*/

CREATE TABLE `Manufacturer` (
  `manufacturer_id` int(10),
  `name` nvarchar(50),
  `industry` nvarchar(25),
  PRIMARY KEY (`manufacturer_id`)
);

CREATE TABLE `Animal` (
  `animal_id` int(10),
  `name` nvarchar(50),
  `category` nvarchar(25),
  PRIMARY KEY (`animal_id`)
);

CREATE TABLE `Customer` (
  `customer_id` int(10),
  `firstName` nvarchar(50),
  `middleName` nvarchar(50),
  `lastName` nvarchar(50),
  `email` varchar(255),
  PRIMARY KEY (`customer_id`)
);

CREATE TABLE `Transaction` (
  `transaction_id` int(10),
  `customer_id` int(10),
  `product_id` int(10),
  `shipment_id` int(10),
  `date` datetime,
  PRIMARY KEY (`transaction_id`),
  FOREIGN KEY (`customer_id`) REFERENCES `Customer`(`customer_id`)
);

CREATE TABLE `Shipment` (
  `shipment_id` int(10),
  `store_id` int(10),
  `transaction_ID` int(10),
  `origin` varchar(255),
  `destination` varchar(255),
  `collection_name` varchar(255),
  `quantity` int(10),
  PRIMARY KEY (`shipment_id`),
  FOREIGN KEY (`shipment_id`) REFERENCES `Transaction`(`shipment_id`)
);

CREATE TABLE `Product` (
  `product_id` int(10),
  `animal_id` int(10),
  `manufacturer_id` int(10),
  `transaction_id` int(10),
  `customer_id` int(10),
  `name` varchar(255),
  `description` varchar(255),
  PRIMARY KEY (`product_id`),
  FOREIGN KEY (`manufacturer_id`) REFERENCES `Manufacturer`(`manufacturer_id`)
);

CREATE TABLE `StoreLocation` (
  `store_id` int(10),
  `name` varchar(255),
  `zip_code` int10),
  PRIMARY KEY (`store_id`)
);

CREATE TABLE `Apparel` (
  `app_id` int(10),
  `product_id` int(10),
  `color` char(10),
  `manufacturer` char(15),
  `durability` varchar(50),
  PRIMARY KEY (`app_id`),
  FOREIGN KEY (`product_id`) REFERENCES `Product`(`product_id`)
);

CREATE TABLE `Toys` (
  `toy_id` int(10),
  `product_id` int(10),
  `asc_material` varchar(255),
  `name` varchar(255),
  `manufacturer` char(15),
  `durability` varchar(50),
  PRIMARY KEY (`toy_id`),
  FOREIGN KEY (`product_id`) REFERENCES `Product`(`product_id`),
  KEY `Key` (`product_id`)
);

CREATE TABLE `Food` (
  `food_id` int(10),
  `product_id` int(10),
  `name` varchar(255),
  `manufacturer` char(15),
  `weight` real,
  `flavor` char(10),
  `target_health` varchar(15),
  PRIMARY KEY (`food_id`),
  FOREIGN KEY (`product_id`) REFERENCES `Product`(`product_id`)
);

