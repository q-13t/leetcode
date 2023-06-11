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
-- 1251. Average Selling Price
SELECT r.id as product_id,
    ROUND(SUM(r.times) / SUM(r.units), 2) as average_price
FROM (
        SELECT p.product_id as id,
            p.price as price,
            u.units as units,
            p.price * u.units as times
        FROM Prices as p
            INNER JOIN UnitsSold as u ON u.product_id = p.product_id
        GROUP BY p.product_id,
            u.purchase_date,
            p.start_date,
            p.end_date
        HAVING u.purchase_date BETWEEN p.start_date AND p.end_date
    ) as r
GROUP BY r.id;
-- 1075. Project Employees I
SELECT p.project_id,
    ROUND(AVG(e.experience_years), 2) as average_years
FROM Project as p
    INNER JOIN Employee AS e ON e.employee_id = p.employee_id
GROUP BY p.project_id;
-- 1633. Percentage of Users Attended a Contest
SELECT contest_id,
    ROUND((COUNT(1) / r.users) * 100, 2) as percentage
FROM Register
    JOIN(
        SELECT COUNT(1) as users
        FROM Users
    ) as r
GROUP BY contest_id
ORDER BY percentage desc,
    contest_id ASC;