CREATE TABLE IF NOT EXISTS run(
	id INT NOT NULL AUTO_INCREMENT,
	title VARCHAR(255) NOT NULL,
	started_on timestamp NOT NULL,
	completed_on TIMESTAMP NOT NULL,
	miles INT NOT NULL,
	location VARCHAR(10) NOT NULL,
	version INT,
	PRIMARY KEY (id)
);