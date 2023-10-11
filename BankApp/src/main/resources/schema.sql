# CREATE TABLE IF NOT EXISTS managers (
#     id INT AUTO_INCREMENT PRIMARY KEY,
#     first_name VARCHAR(50),
#     last_name VARCHAR(50),
#     status INT,
#     description VARCHAR(255),
#     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
#
# );
#
# CREATE TABLE IF NOT EXISTS clients (
#     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     manager_id INT,
#     status INT,
#     tax_code VARCHAR(20),
#     first_name VARCHAR(50),
#     last_name VARCHAR(50),
#     email VARCHAR(60),
#     address VARCHAR(80),
#     phone VARCHAR(20),
#     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
# );
#
# CREATE TABLE IF NOT EXISTS products (
#     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     manager_id INT,
#     name VARCHAR(70),
#     status INT,
#     currency_code INT,
#     interest_rate NUMERIC(6, 4),
#     `limit` NUMERIC(15, 2),
#     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
# );
#
# CREATE TABLE IF NOT EXISTS accounts (
#     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     client_id INT,
#     name VARCHAR(100),
#     type INT,
#     status INT,
#     balance NUMERIC(15, 2),
#     currency_code INT,
#     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
# );
#
# CREATE TABLE IF NOT EXISTS agreements (
#     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     account_id INT,
#     product_id INT,
#     interest_rate NUMERIC(6, 4),
#     status INT,
#     sum NUMERIC(15, 2),
#     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
#     updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
# );
#
# CREATE TABLE IF NOT EXISTS transactions (
#     id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
#     debit_account_id INT,
#     credit_account_id INT,
#     type INT,
#     amount NUMERIC(12, 2),
#     description VARCHAR(255),
#     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
# );

# ALTER TABLE clients ADD FOREIGN KEY (manager_id) REFERENCES managers(id);
# ALTER TABLE products ADD FOREIGN KEY (manager_id) REFERENCES managers(id);
# ALTER TABLE accounts ADD FOREIGN KEY (client_id) REFERENCES clients(id);
# ALTER TABLE agreements ADD FOREIGN KEY (product_id) REFERENCES products(id);
# ALTER TABLE agreements ADD FOREIGN KEY (account_id) REFERENCES accounts(id);
# ALTER TABLE transactions ADD FOREIGN KEY (debit_account_id) REFERENCES accounts(id);
# ALTER TABLE transactions ADD FOREIGN KEY (credit_account_id) REFERENCES accounts(id);



