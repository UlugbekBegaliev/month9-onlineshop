use `onlineshop`;

CREATE TABLE `reviews` (
  `id` INT AUTO_INCREMENT NOT NULL,
  `customer_id` INT NOT NULL,
  `product_id` INT NOT NULL,
  `description` VARCHAR(128) NOT NULL,
  FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`),
  FOREIGN KEY (`product_id`) REFERENCES `products` (`id`),
  PRIMARY KEY (`id`)
)