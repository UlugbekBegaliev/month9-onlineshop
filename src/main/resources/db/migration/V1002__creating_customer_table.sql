use `onlineshop`;

CREATE TABLE `customers` (
     `id` INT auto_increment NOT NULL,
     `email` VARCHAR(128) NOT NULL,
     `password` VARCHAR(128) NOT NULL,
     `fullname` VARCHAR(128) NOT NULL DEFAULT ' ',
     `enabled` boolean NOT NULL DEFAULT TRUE,
     `role` VARCHAR(16) NOT NULL DEFAULT 'USER',
     PRIMARY KEY (`id`),
     UNIQUE INDEX `email_unique` (`email` ASC)
);

CREATE TABLE `baskets` (
    `id` INT auto_increment NOT NULL,
    `product_name` VARCHAR(128) NOT NULL,
    `quantity` FLOAT NOT NULL,
    `price` FLOAT NOT NULL,
    `customer_id` INT NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
    PRIMARY
)