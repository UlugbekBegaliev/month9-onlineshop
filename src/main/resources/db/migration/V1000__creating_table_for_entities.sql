`use onlineshop`

CREATE TABLE `products` (
    `id` INT auto_increment NOT NULL,
    `name` VARCHAR(128) NOT NULL,
    `description` VARCHAR(300) NOT NULL,
    `image` VARCHAR(128) NOT NULL,
    `quantity` INT NOT NULL,
    `price` FLOAT NOT NULL,
    PRIMARY KEY (`id`)
);