create database salesDb;
use salesDb;

CREATE TABLE store (
    id INT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE product (
    id INT PRIMARY KEY,
    name VARCHAR(50),
    mrp DECIMAL(10, 2)
);

CREATE TABLE sale (
    product_id INT,
    sale_quantity INT,
    store_id INT,
    FOREIGN KEY (product_id) REFERENCES product(id),
    FOREIGN KEY (store_id) REFERENCES store(id)
);


INSERT INTO store (id, name) VALUES (1, 'super market');
INSERT INTO store (id, name) VALUES (2, 'super bazar');

INSERT INTO product (id, name, mrp) VALUES (1, 'good day', 20);
INSERT INTO product (id, name, mrp) VALUES (2, 'Nutri choice', 30);
INSERT INTO product (id, name, mrp) VALUES (3, 'dairy milk', 50);

INSERT INTO sale (product_id, sale_quantity, store_id) VALUES (2, 3, 2);
INSERT INTO sale (product_id, sale_quantity, store_id) VALUES (1, 4, 1);
INSERT INTO sale (product_id, sale_quantity, store_id) VALUES (2, 3, 1);
INSERT INTO sale (product_id, sale_quantity, store_id) VALUES (1, 4, 2);
INSERT INTO sale (product_id, sale_quantity, store_id) VALUES (2, 5, 2);

commit;
