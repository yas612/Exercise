
/* INNER JOIN */

SELECT Book.name, Price.price 
FROM Book 
INNER JOIN Price 
ON Book.id = Price.id;  

/* lEFT OUTER JOIN */

SELECT Book.name, Price.price 
FROM Book   
LEFT JOIN Price 
ON Book.id = Price.id;   

/* RIGHT OUTER JOIN */

SELECT Book.name, Price.price 
FROM Book
RIGHT JOIN Price 
ON Book.id = Price.id;

/* FULL OUTER JOIN */

SELECT Book.name, Price.price 
FROM Book
FULL OUTER JOIN Price 
ON Book.id = Price.id;

/* UNION */

SELECT "Book".id,"Book".name
 FROM "BOOK"
 UNION 
SELECT "price".id, "Price".price
 FROM "price"

/* INTERSECT */

SELECT "BOOK".id
FROM "BOOK"
INTERSECT
SELECT "Price".id
FROM "Price";

/* Subquery 1 */

SELECT
	"Price".id,
	"Price".price
FROM
	"Price"
WHERE
	"Price".price > 300;

/* Subquery 2 */

SELECT
	"Price".id,
	"Price".price
FROM
	"Price"
WHERE
	"Price".price > (
		SELECT
			AVG ("Price".price)
		FROM
			"Price"
	);

/* Subquery 3 */

SELECT
	"Book".id,
	"Book".name
FROM
	"Book"
WHERE
	"Book".name = 'hospital'