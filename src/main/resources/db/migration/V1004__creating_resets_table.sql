use `onlineshop`;

CREATE TABLE `resets` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `token` VARCHAR(255) DEFAULT NULL,
  `customer_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`customer_id`) REFERENCES `customers` (`id`)
)

