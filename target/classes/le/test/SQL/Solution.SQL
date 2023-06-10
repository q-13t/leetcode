-- 1757. Recyclable and Low Fat Products
SELECT product_id
FROM Products
WHERE low_fats = 'Y'
    AND recyclable = 'Y';
-- 584. Find Customer Referee
SELECT name
FROM Customer
WHERE referee_id NOT IN (2)
    OR referee_id IS null;
-- 595. Big Countries
SELECT name,
    population,
    area
FROM World
WHERE area >= 3000000
    OR population >= 25000000;
-- 1148. Article Views I
SELECT DISTINCT author_id as 'id'
FROM Views
WHERE author_id = viewer_id
ORDER BY author_id;
-- 1683. Invalid Tweets
SELECT tweet_id
FROM Tweets
WHERE LENGTH(content) > 15;
-- 1378. Replace Employee ID With The Unique Identifier
SELECT u.unique_id,
    e.name
FROM Employees e
    LEFT JOIN EmployeeUNI u ON u.id = e.id;
-- 1068. Product Sales Analysis I
SELECT p.product_name,
    s.year,
    s.price
FROM Sales s
    INNER JOIN Product p ON p.product_id = s.product_id;
-- 1581. Customer Who Visited but Did Not Make Any Transactions
SELECT v.customer_id,
    COUNT(1) 'count_no_trans'
FROM Visits v
    LEFT JOIN Transactions t ON t.visit_id = v.visit_id
WHERE ISNULL(t.visit_id)
GROUP BY v.customer_id;
-- 197. Rising Temperature
SELECT w1.id
FROM Weather w1
    JOIN Weather w2 ON w1.recordDate = DATE_ADD(w2.recordDate, INTERVAL 1 DAY)
WHERE w1.temperature > w2.temperature;
--1661. Average Time of Process per Machine
SELECT a1.machine_id,
    ROUND(AVG(a2.timestamp - a1.timestamp), 3) 'processing_time'
FROM Activity a1
    JOIN Activity a2 ON a1.machine_id = a2.machine_id
    AND a1.process_id = a2.process_id
    AND a2.timestamp > a1.timestamp
GROUP BY a1.machine_id;
-- 577. Employee Bonus
SELECT e.name,
    b.bonus
FROM Employee e
    LEFT JOIN Bonus b ON b.empId = e.empID
WHERE b.bonus < 1000
    OR b.bonus IS NULL;