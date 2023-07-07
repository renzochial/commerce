-- Drop table
DROP TABLE IF EXISTS prices;
DROP TABLE IF EXISTS brands;

CREATE TABLE brands (
	brand_id INT AUTO_INCREMENT  PRIMARY KEY,
	name VARCHAR NOT NULL
);

CREATE TABLE prices (
	price_id INT AUTO_INCREMENT  PRIMARY KEY,
	brand_id INTEGER NOT NULL,
	start_date TIMESTAMP NULL,
	end_date TIMESTAMP NULL,
	price_list INTEGER NOT NULL,
	product_id INTEGER NOT NULL,
	priority INTEGER NOT NULL,
	price DOUBLE NOT NULL,
	curr VARCHAR NOT NULL,
	FOREIGN KEY (brand_id) REFERENCES brands (brand_id)
);

INSERT INTO brands (brand_id, name) VALUES
( 1, 'ZARA');

INSERT INTO prices (price_id, brand_id, start_date, end_date, price_list, product_id, priority, price, curr) VALUES
(1, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 1, 35455, 0, 35.50, 'EUR'),
(2, 1, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 2, 35455, 1, 25.45, 'EUR'),
(3, 1, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 3, 35455, 1, 30.50, 'EUR'),
(4, 1, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 4, 35455, 1, 38.95, 'EUR');