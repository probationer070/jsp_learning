CREATE TABLE Book(
    b_id VARCHAR2(10) NOT NULL PRIMARY KEY,
    b_name VARCHAR2(20),
	b_unitPrice INTEGER,
	b_author VARCHAR2(20),
	b_description LONG,
	b_publisher VARCHAR2(20),
   	b_category VARCHAR2(20),	
	b_unitsInStock NUMBER,
	b_releaseDate VARCHAR2(20),
	b_condition VARCHAR2(20),
	b_fileName  VARCHAR2(20)
);

DESC Book;