DROP TABLE IF EXISTS `users` CASCADE;
CREATE TABLE `users` (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(255),
  password VARCHAR(255),
  email VARCHAR(255),
  cpf VARCHAR(255),
  phone VARCHAR(255),
  zipcode VARCHAR(255),
  address VARCHAR(255),
  address_number VARCHAR(255),
  district VARCHAR(255),
  PRIMARY KEY (id)
);