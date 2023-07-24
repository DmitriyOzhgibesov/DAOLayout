CREATE TABLE customers
(
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    age INT NOT NULL CHECK (age >= 0 AND age <= 100),
    phone_number VARCHAR(255) NOT NULL,
    PRIMARY KEY (id)
);

INSERT INTO customers(name, surname, age, phone_number)
VALUES ('Alexey', 'Ozhgibesov', 32, '+7-951-381-76-39'), ('AlexEY', 'Voronov', 27, '+7-999-777-66-44'), ('alexEY', 'Trizin', 28, '+7-987-654-32-11'), ('Anna', 'Medoeva', 26, '+7-888-777-66-55'), ('Artem', 'Shiev', 42, '+7-123-456-78-99');

CREATE TABLE orders
(
    id SERIAL,
    date DATE NOT NULL,
    customer_id INT NOT NULL,
    product_name VARCHAR(255) NOT NULL ,
    amount INT NOT NULL CHECK (amount >= 0),
    PRIMARY KEY (id),
    FOREIGN KEY (customer_id) REFERENCES customers(id)
);

INSERT INTO orders(date, customer_id, product_name, amount)
VALUES ('2023-07-21', 2, 'HDMI 2.1 переходник', 3000), ('2023-07-22', 2, 'WI-FI роутер', 2000), ('2023-07-23', 4, 'Монитор', 7000), ('2023-07-24', 5, 'USB мышь', 500), ('2023-07-25', 1, 'Bluetooth адаптер', 2500);

SELECT product_name, name
FROM orders
         JOIN customers ON customers.id = orders.customer_id