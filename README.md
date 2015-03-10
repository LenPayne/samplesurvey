# Sample Survey Based on OpenShift Wildfly Cartridge with MySQL

This is a partial sample performing CRUD with jQuery and JAX-RS. It 
functions as a question-post now, allowing people to post questions. To
turn this into a fully-functional survey would require the following changes:

1. Delete and Remove options
2. Ability to answer questions
3. User accounts

Create the DB with:

    CREATE TABLE questions (id INT NOT NULL AUTO_INCREMENT,
    question TEXT NOT NULL,
    PRIMARY KEY(id));

    CREATE TABLE answers (id INT NOT NULL AUTO_INCREMENT,
    answer TEXT NOT NULL,
    question_id INT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (question_id) REFERENCES questions(id));