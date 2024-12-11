CREATE TABLE ToDoList (
    no INT AUTO_INCREMENT PRIMARY KEY,
    task_name VARCHAR(255) NOT NULL,
    task_desc VARCHAR(500),
    status VARCHAR(50)
);
INSERT INTO ToDoList (task_name, task_desc, status)
VALUES ('Java', 'Java Programming', 'Pending');
