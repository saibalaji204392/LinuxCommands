CREATE SCHEMA `practicedec17` ;

create table `practicedec17`.departments
(department_id int primary key,
department_name varchar(50) not null,
manager_id int
);

CREATE TABLE `practicedec17`.`employees` (
employee_id int primary key,
first_name varchar(50) not null,
last_name varchar(50) not null,
department_id int, 
salary decimal(10,2),
hire_date date not null,
foreign key(department_id) references departments(department_id)
);

-- alter table employees add foreign key(department_id) references departments(department_id);

create table `practicedec17`.projects
(project_id int primary key,
project_name varchar(50),
start_date date,
end_date date);

create table `practicedec17`.employees_projects
(project_id int,
employee_id int,
hours_logged decimal(10,2),
allocation_date date,
foreign key(project_id) references projects(project_id),
foreign key(employee_id) references employees(employee_id)
);

create table `practicedec17`.transactions
(transaction_id int primary key,
employee_id int,
amount decimal(10,2),
transaction_date date,
transaction_type varchar(50),
foreign key(employee_id) references employees(employee_id)
);

Inserting data::
INSERT INTO practicedec17.departments (department_id, department_name, manager_id) VALUES
(1, 'Human Resources', 101),
(2, 'Finance', 102),
(3, 'Engineering', 103),
(4, 'Marketing', 104),
(5, 'Sales', 105),
(6, 'Customer Support', 106),
(7, 'IT Support', 107),
(8, 'Legal', 108),
(9, 'Product Development', 109),
(10, 'Operations', 110);

INSERT INTO practicedec17.employees (employee_id, first_name, last_name, department_id, hire_date, salary)
   VALUES
       (1, 'John', 'Doe', 1, '2020-01-15', 55000),
       (2, 'Jane', 'Smith', 2, '2021-03-20', 60000),
       (3, 'Michael', 'Johnson', 3, '2019-11-10', 70000),
       (4, 'Emily', 'Davis', 4, '2022-07-14', 45000),
       (5, 'James', 'Wilson', 5, '2018-05-22', 80000),
       (6, 'Sarah', 'Brown', 1, '2021-09-30', 48000),
       (7, 'David', 'Taylor', 2, '2019-06-02', 55000),
       (8, 'Laura', 'Miller', 3, '2020-12-01', 65000),
       (9, 'Steven', 'Anderson', 4, '2023-01-25', 40000),
       (10, 'Jessica', 'Thomas', 5, '2022-08-17', 75000),
	   (11, 'sai', 'balaji', 5, '2022-08-18', 65000);
	   
INSERT INTO practicedec17.projects (project_id, project_name, start_date, end_date)
   VALUES
       (1, 'Project A', '2023-01-01', '2023-12-31'),
       (2, 'Project B', '2023-03-15', '2024-06-30'),
       (3, 'Project C', '2024-02-01', '2024-12-31'),
       (4, 'Project D', '2024-06-01', '2024-12-31'),
       (6, 'Project E', '2024-07-01', '2024-12-31');
 
INSERT INTO practicedec17.employees_projects (employee_id, project_id, hours_logged, allocation_date) VALUES
(1, 1, 120.50, '2024-01-15'),
(1, 2, 120.50, '2024-03-15'),
(1, 3, 120.50, '2024-04-15'),
(1, 4, 120.50, '2024-05-15'),
(1, 5, 120.50, '2024-02-15'),
(1, 6, 120.50, '2024-02-17'),
(2, 1, 85.75, '2024-02-10'),
(3, 2, 95.00, '2024-03-05'),
(4, 3, 140.25, '2024-04-01'),
(5, 4, 110.00, '2024-01-20'),
(6, 6, 130.00, '2024-02-15'),
(7, 6, 100.50, '2024-03-12'),
(2,1,90.0,'2024-02-01');
 
INSERT INTO practicedec17.transactions (transaction_id, employee_id, amount, transaction_date, transaction_type) VALUES
(1, 1, 5000.00, '2024-01-31', 'Salary'),
(2, 2, 4500.00, '2024-01-31', 'Salary'),
(3, 3, 5500.00, '2024-01-31', 'Salary'),
(4, 4, 600.00, '2024-02-15', 'Bonus'),
(5, 5, 150.00, '2024-02-20', 'Deduction'),
(6, 6, 800.00, '2024-03-05', 'Bonus'),
(7, 7, 4900.00, '2024-03-31', 'Salary'),
(8, 8, 700.00, '2024-03-15', 'Bonus'),
(9, 9, 300.00, '2024-04-01', 'Deduction'),
(10, 10, 5500.00, '2024-04-30', 'Salary');
(11, 10, 6500.00, '2024-05-30', 'Salary');

1. Write a query to fetch the names of employees and their department name.

	SELECT e.first_name AS employee_first_name,e.last_name AS employee_last_name,d.department_name FROM practicedec17.employees e JOIN 
practicedec17.departments d ON e.department_id = d.department_id;

2. Find the total hours logged by each employee across all projects.

	SELECT e.first_name AS employee_first_name,e.last_name AS employee_last_name,SUM(ep.hours_logged) AS total_hours_logged FROM practicedec17.employees_projects ep INNER JOIN practicedec17.employees e ON ep.employee_id = e.employee_id GROUP BY e.employee_id;

3. Retrieve the department name and count of employees in each department.

	select d.department_id,count(e.employee_id) as NoOfEmployees from practicedec17.employees e INNER JOIN practicedec17.departments d ON e.department_id = d.department_id GROUP BY e.department_id;
	
4. Identify employees who work on more than 2 projects.

	select ep.employee_id,first_name,last_name,count(project_id) as NoOfProjects from practicedec17.employees_projects ep INNER JOIN practicedec17.employees e ON e.employee_id = ep.employee_id group by e.employee_id Having count(project_id) >= 2;

5. Write a query to find employees who do not work on any project.
	select first_name,last_name from practicedec17.employees e LEFT JOIN practicedec17.employees_projects ep ON e.employee_id = ep.employee_id where project_id IS NULL;

6. Find employees earning a salary greater than the average salary of their department.

	SELECT e.employee_id, e.first_name,e.last_name, e.salary, e.department_id FROM practicedec17.employees e
JOIN (SELECT department_id, AVG(salary) AS AvgSalary FROM practicedec17.employees GROUP BY department_id) avg_dept ON e.department_id = avg_dept.department_id
WHERE e.salary > avg_dept.AvgSalary;

7. Write a query using a self join to display employee names along with their managers name.
	
	
8. Identify projects where the total hours logged by all employees exceed 500.

	SELECT e.first_name AS employee_first_name,e.last_name AS employee_last_name,SUM(ep.hours_logged) AS total_hours_logged FROM practicedec17.employees_projects ep INNER JOIN practicedec17.employees e ON ep.employee_id = e.employee_id GROUP BY e.employee_id Having sum(ep.hours_logged) > 500;
	
9. Retrieve the name of the department where the manager has the highest salary.
	
10. Display employees who have logged more than 40 hours on any project using a CASE
statement to classify them as 'Overtime' or 'Normal.'

	SELECT e.first_name AS employee_first_name,e.last_name AS employee_last_name,CASE 
           WHEN SUM(ep.hours_logged) > 40 THEN 'Overtime'
           ELSE 'Normal'
       END AS WorkClassification FROM practicedec17.employees_projects ep INNER JOIN practicedec17.employees e ON ep.employee_id = e.employee_id group by e.employee_id;
	
11. Find employees who were hired after January 1, 2020, and have not been allocated to
any projects.

	select e.employee_id,e.first_name,e.last_name from practicedec17.employees e LEFT JOIN practicedec17.employees_projects ep ON e.employee_id = ep.employee_id  where hire_date > '2020-01-01' group by e.employee_id Having count(project_id) = 0;
		
12. Write a query to display employees whose total salary transactions (including
bonuses/deductions) exceed 10,000.

	select e.employee_id,first_name,last_name,sum(t.amount) from practicedec17.employees e JOIN practicedec17.transactions t on e.employee_id = t.employee_id group by t.employee_id having sum(t.amount) > 10000;
	
13. Retrieve the transaction details of employees where the transaction type is "Bonus"
and the amount is in the top 5% of all bonuses.

	select * from practicedec17.transactions where transaction_type = 'Bonus' LIMIT 5;

14. List employees whose salary is the highest in their respective department.

	select * from practicedec17.employees where salary in (select max(salary) from practicedec17.employees group by department_id); 

15. Display the average hours logged by employees for each project.

	select project_id,avg(hours_logged) from practicedec17.employees_projects group by project_id;

16. Write a query to fetch all employees who belong to the same department as "John
Doe" using self joins.

	select e1.employee_id,concat(e1.first_name,e1.last_name) as employee_name from practicedec17.employees e1 JOIN practicedec17.employees e2 on e1.employee_id = e2.employee_id where e1.department_id = (select department_id from practicedec17.employees where first_name = 'John' and last_name = 'Doe');

17. Find the departments where no projects have started.

	select d.department_id,d.department_name from departments d LEFT JOIN (select e.department_id,project_id from employees e JOIN employees_projects ep ON e.employee_id = ep.employee_id) projectdetails on d.department_id = projectdetails.department_id where projectdetails.project_id IS NULL; 

18. Retrieve employee details for employees working on all projects.

	select employee_id,first_name,last_name from employees 
where employee_id IN (select employee_id from employees_projects group by employee_id having count(project_id)=(select count(project_id) from projects));

19. List employees whose names start with the letter 'A' and have logged more than 20
hours on any project.

	select e.employee_id,e.first_name,last_name from employees e JOIN employees_projects ep ON e.employee_id = ep.employee_id where e.first_name like 'A%' and ep.hours_logged > 20

20. Identify the total transactions per employee along with their latest transaction date.

	select employee_id,count(transaction_id) as NoOfTransactions,max(transaction_date) as LatestTransactionDate from transactions group by employee_id ;



