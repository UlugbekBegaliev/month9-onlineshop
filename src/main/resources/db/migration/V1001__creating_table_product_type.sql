use `onlineshop`;

    CREATE TABLE `product_types` (
    `id` INT auto_increment NOT NULL,
    `name` VARCHAR(128) NOT NULL,
    `icon` VARCHAR(128) NOT NULL,
    PRIMARY KEY (`id`)
);

ALTER TABLE `products`
ADD COLUMN `product_type_id` INT NOT NULL after `image`, ADD CONSTRAINT `fk_product__product_types`
FOREIGN KEY (`product_type_id`) REFERENCES `product_types` (`id`);

INSERT INTO `product_types` (`name`, `icon`) VALUES
('Audi', 'audi.png'),
('BMW', 'bmw.jpg'),
('Mercedes', 'mers.png'),
('Toyota', 'toyota.png');