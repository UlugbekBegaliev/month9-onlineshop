use `onlineshop`;

CREATE TABLE `purchases` (
    `id` INT auto_increment NOT NULL,
    `product_name` VARCHAR(128) NOT NULL,
    `quantity` FLOAT NOT NULL,
    `price` FLOAT NOT NULL,
    `customer_id` INT NOT NULL,
    FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
    PRIMARY KEY (`id`)
)