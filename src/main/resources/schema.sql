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

-- Criação da tabela 'provider'
CREATE TABLE provider (
    id_provider INTEGER PRIMARY KEY,
    username VARCHAR(255),
    password VARCHAR(255),
    email VARCHAR(255),
    cpf VARCHAR(20),
    phone VARCHAR(15),
    zipcode VARCHAR(10),
    address VARCHAR(255),
    district VARCHAR(100),
    addressNumber VARCHAR(10),
    dateCreated TIMESTAMP
);

-- Criação da tabela 'service'
CREATE TABLE service (
    id_service INTEGER PRIMARY KEY,
    id_provider INTEGER,
    service_value VARCHAR(255),
    dt_cadastro TIMESTAMP,
    FOREIGN KEY (id_provider) REFERENCES provider(id_provider)
);

-- Criação da tabela 'order'
CREATE TABLE "order" ( 
    id_order INTEGER PRIMARY KEY,
    id_user INTEGER,
    id_service INTEGER,
    dt_cadastro TIMESTAMP,
    FOREIGN KEY (id_user) REFERENCES users(id),
    FOREIGN KEY (id_service) REFERENCES service(id_service)
);
