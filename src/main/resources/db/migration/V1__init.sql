-- Creación de la tabla 'country'
CREATE TABLE IF NOT EXISTS country (
    id SERIAL,
    code VARCHAR(10) UNIQUE NOT NULL,
    country_name VARCHAR(255) NOT NULL,
    continent_name VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
    );

-- Creación de la tabla 'user'
CREATE TABLE IF NOT EXISTS user (
     id SERIAL,
     fullname VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    gender VARCHAR(10) NOT NULL,
    date_of_birth DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    country_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country(id)
    );

-- Creación de la tabla 'merchant'
CREATE TABLE IF NOT EXISTS merchant (
    id SERIAL,
    merchant_name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    admin_id INT NOT NULL,
    country_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (country_id) REFERENCES country(id)
    );

-- Creación de la tabla 'order'
CREATE TABLE IF NOT EXISTS order (
    id SERIAL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (user_id) REFERENCES user(id)
    );

-- Creación de la tabla 'product'
CREATE TABLE IF NOT EXISTS product (
    id SERIAL,
    description TEXT NOT NULL,
    merchant_id INT,
    price DECIMAL(10, 2) NOT NULL,
    status VARCHAR(50) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id),
    FOREIGN KEY (merchant_id) REFERENCES merchant(id)
    );

-- Creación de la tabla 'order_item'
CREATE TABLE IF NOT EXISTS order_item (
    id SERIAL,
    quantity INT NOT NULL,
    order_id INT,
    product_id INT,
    PRIMARY KEY (id),
    FOREIGN KEY (order_id) REFERENCES order(id),
    FOREIGN KEY (product_id) REFERENCES product(id)
    );
