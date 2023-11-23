CREATE DATABASE submission_project_wms_api;

USE submission_project_wms_api;
drop database submission_project_wms_api;

CREATE TABLE branches (
    id_branch VARCHAR(100) NOT NULL,
    code_branch VARCHAR(100) NOT NULL,
    name_branch VARCHAR(100) NOT NULL,
    address VARCHAR(100),
    phone_number VARCHAR(100),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_branch)
);


CREATE TABLE products(
    id_product VARCHAR(100) NOT NULL,
    price_product VARCHAR(100),
    code_product VARCHAR(100) NOT NULL,
    name_product VARCHAR(100) NOT NULL,
    price DECIMAL(10),
    id_branch VARCHAR(100),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_product),
    FOREIGN KEY fk_branches_products (id_branch) REFERENCES branches(id_branch)
);

CREATE TABLE transactions (
    id_bill VARCHAR(100) NOT NULL,
    receipt_number VARCHAR(100) NOT NULL,
    trans_date TIMESTAMP,
    transaction_type VARCHAR(100),
    created_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    last_modified_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (id_bill)
);

CREATE TABLE bill_details(
    id_bill_detail VARCHAR(100) NOT NULL PRIMARY KEY ,
    id_bill VARCHAR(100) NOT NULL ,
    id_product VARCHAR(100) NOT NULL ,
    quantity int DEFAULT 0,
    total_sales DECIMAL(10),
    FOREIGN KEY fk_transactions_bill_details (id_bill) REFERENCES transactions(id_bill),
    FOREIGN KEY fk_products_bill_details (id_product) REFERENCES  products(id_product)
);

CREATE TABLE serial_number (
    id_number SERIAL PRIMARY KEY,
    code_branch VARCHAR(10) NOT NULL,
    year INT NOT NULL,
    current_value INT NOT NULL
);