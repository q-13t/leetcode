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
-- 1211. Queries Quality and Percentage
SELECT query_name,
    ROUND(AVG(rating / position), 2) AS quality,
    ROUND(SUM(rating < 3) / COUNT(query_name) * 100, 2) as poor_query_percentage
FROM queries
GROUP BY query_name;
-- 1193. Monthly Transactions I
SELECT DATE_FORMAT(trans_date, '%Y-%m') as month,
    country,
    COUNT(state) as trans_count,
    SUM(IF(state = 'approved', 1, 0)) as approved_count,
    SUM(amount) as trans_total_amount,
    SUM(IF(state = 'approved', amount, 0)) as approved_total_amount
FROM Transactions
GROUP BY EXTRACT(
        MONTH
        FROM trans_date
    ),
    country;
-- 1174. Immediate Food Delivery II
SELECT ROUND(
        SUM(
            IF(order_date = customer_pref_delivery_date, 1, 0)
        ) / COUNT(1) * 100,
        2
    ) as immediate_percentage
FROM Delivery
WHERE (customer_id, order_date) IN(
        SELECT customer_id,
            MIN(order_date) as order_date
        FROM Delivery
        GROUP BY customer_id
    );
-- 550. Game Play Analysis IV
SELECT ROUND(j.consecutive / COUNT(DISTINCT a.player_id), 2) as fraction
FROM Activity a
    JOIN(
        SELECT count(a1.player_id) as consecutive
        FROM (
                SELECT player_id,
                    MIN(event_date) as event_date
                FROM Activity
                GROUP BY player_id
            ) as a1
            JOIN Activity a2 ON a2.event_date = DATE_ADD(a1.event_date, INTERVAL 1 DAY)
            AND a1.player_id = a2.player_id
    ) as j;
-- 2356. Number of Unique Subjects Taught by Each Teacher
SELECT teacher_id,
    COUNT(DISTINCT subject_id) as cnt
FROM Teacher
GROUP BY teacher_id;
-- 1141. User Activity for the Past 30 Days I
SELECT activity_date as day,
    COUNT(DISTINCT user_id) as active_users
FROM Activity
WHERE activity_date <= '2019-07-27'
    AND ABS(DATEDIFF('2019-07-27', activity_date)) < 30
GROUP BY activity_date;
-- 1070.Product Sales Analysis III
SELECT product_id,
    year as first_year,
    quantity,
    price
FROM Sales
WHERE (product_id, year) IN(
        SELECT product_id,
            MIN(YEAR)
        FROM Sales
        GROUP BY product_id
    );
-- 596. Classes More Than 5 Students
SELECT class
FROM Courses
GROUP BY class
HAVING COUNT(1) >= 5;
-- 1729. Find Followers Count
SELECT user_id,
    COUNT(follower_id) as followers_count
FROM Followers
GROUP BY user_id
ORDER BY user_id ASC;
-- 619. Biggest Single Number
SELECT MAX(r.num) as num
FROM (
        SELECT num as num
        FROM MyNumbers
        GROUP BY num
        HAVING COUNT(1) = 1
    ) r;
-- 1045.Customers Who Bought All Products
SELECT b.customer_id
FROM(
        SELECT customer_id,
            COUNT(DISTINCT product_key) as bought
        FROM Customer
        GROUP BY customer_id
    ) as b
    JOIN(
        SELECT COUNT(1) as product_count
        FROM Product
    ) as c
WHERE b.bought IN (c.product_count);
-- 1731. The Number of Employees Which Report to Each Employee
SELECT e.employee_id,
    e.name,
    COUNT(r.employee_id) as reports_count,
    ROUND(AVG(r.age), 0) as average_age
FROM Employees as e
    JOIN(
        SELECT employee_id,
            reports_to,
            age
        FROM Employees
    ) as r ON e.employee_id = r.reports_to
GROUP BY e.employee_id
ORDER BY e.employee_id;
-- 1789. Primary Department for Each Employee
SELECT employee_id,
    department_id
FROM Employee
WHERE employee_id NOT IN(
        SELECT employee_id
        FROM Employee
        WHERE primary_flag = 'Y'
    )
    OR primary_flag = 'Y';
-- 610. Triangle Judgement
SELECT *,
    IF(
        x + y > z
        AND x + z > y
        AND z + y > x,
        'Yes',
        'No'
    ) as triangle
FROM Triangle;
-- 180. Consecutive Numbers
SELECT DISTINCT a.num as ConsecutiveNums
FROM Logs as a
    INNER JOIN Logs as b
    INNER JOIN Logs as c
WHERE a.num = b.num
    AND a.num = c.num
    AND a.id = b.id - 1
    AND a.id = c.id - 2;
-- 1164. Product Price at a Given Date
SELECT product_id,
    IFNULL(k.price, 10) as price
FROM (
        SELECT DISTINCT product_id
        FROM Products
    ) as p
    LEFT JOIN(
        SELECT DISTINCT product_id,
            FIRST_VALUE (new_price) OVER (
                PARTITION BY product_id
                ORDER BY change_date DESC
            ) AS price
        FROM Products
        WHERE change_date <= '2019-08-16'
    ) as k USING (product_id);
-- 1204. Last Person to Fit in the Bus
select person_name
from (
        select *,
            sum(weight) over (
                order by Turn
            ) as total_sum
        from queue
    ) t
where total_sum <= 1000
order by turn desc
limit 1;
-- 1907. Count Salary Categories
SELECT 'Low Salary' as category,
    COUNT(1) as accounts_count
FROM Accounts
WHERE income < 20000
UNION
SELECT 'Average Salary' as category,
    COUNT(1) as accounts_count
FROM Accounts
WHERE income BETWEEN 20000 AND 50000
UNION
SELECT 'High Salary' as category,
    COUNT(1) as accounts_count
FROM Accounts
WHERE income > 50000;
-- 1978. Employees Whose Manager Left the Company
SELECT employee_id
FROM Employees
WHERE salary < 30000
    AND manager_id NOT IN (
        SELECT employee_id
        FROM Employees
    )
ORDER BY employee_id;
-- 626. Exchange Seats
SELECT id,
    IF(
        SUM(1) OVER(
            ORDER BY id
        ) %2 = 0,
        LAG(student) OVER (
            ORDER BY id
        ),
        IFNULL(
            LEAD(student) OVER (
                ORDER BY id
            ),
            student
        )
    ) as student
FROM SEAT;
-- 1341. Movie Rating
(
    SELECT u.name as results
    FROM MovieRating as mr
        INNER JOIN Users as u ON (mr.user_id = u.user_id)
    GROUP BY u.name
    ORDER BY count(1) DESC,
        u.name
    LIMIT 1
)
UNION ALL
(
    SELECT m.title as results
    FROM MovieRating mr
        INNER JOIN Movies as m ON(mr.movie_id = m.movie_id)
    WHERE EXTRACT(
            YEAR_MONTH
            FROM created_at
        ) = '202002'
    GROUP BY m.title
    ORDER BY AVG(mr.rating) DESC,
        m.title
    LIMIT 1
);
-- 1321. Restaurant Growth
SELECT DISTINCT customer.visited_on,
    sum(c.amount) amount,
    round(sum(c.amount) / 7, 2) average_amount
FROM Customer
    JOIN Customer c ON c.visited_on BETWEEN DATE_SUB(customer.visited_on, INTERVAL 6 DAY)
    AND customer.visited_on
WHERE customer.visited_on >= DATE_ADD(
        (
            SELECT MIN(visited_on)
            FROM Customer
        ),
        INTERVAL 6 DAY
    )
GROUP BY customer.visited_on,
    customer.customer_id
ORDER BY customer.visited_on;
-- 602. Friend Requests II: Who Has the Most Friends
SELECT user_id AS id,
    COUNT(*) AS num
FROM (
        SELECT requester_id AS user_id
        FROM RequestAccepted
        UNION ALL
        SELECT accepter_id AS user_id
        FROM RequestAccepted
    ) AS all_users
GROUP BY user_id
HAVING num = (
        SELECT COUNT(*) AS max_friends
        FROM (
                SELECT requester_id AS user_id
                FROM RequestAccepted
                UNION ALL
                SELECT accepter_id AS user_id
                FROM RequestAccepted
            ) AS all_users
        GROUP BY user_id
        ORDER BY max_friends DESC
        LIMIT 1
    );
-- 585. Investments in 2016
SELECT ROUND(SUM(tiv_2016), 2) as tiv_2016
FROM Insurance
WHERE tiv_2015 IN (
        SELECT tiv_2015
        FROM Insurance
        GROUP BY tiv_2015
        HAVING COUNT(1) > 1
    )
    AND (lat, lon) IN (
        SELECT lat,
            lon
        FROM Insurance
        GROUP BY lat,
            lon
        HAVING COUNT(1) = 1
    );
-- 185. Department Top Three Salaries
SELECT D.name AS Department,
    E.name AS Employee,
    E.salary AS Salary
FROM Employee AS E
    JOIN Department AS D ON E.departmentId = D.id,
    (
        SELECT E1.id,
            DENSE_RANK() OVER(
                PARTITION BY E1.departmentId
                ORDER BY E1.salary DESC
            ) AS ranking
        FROM Employee AS E1
    ) AS R
WHERE R.ranking <= 3
    AND R.id = E.id;
-- 1667. Fix Names in a Table
SELECT user_id,
    CONCAT(UCASE(LEFT(name, 1)), LCASE(SUBSTRING(name, 2))) as name
FROM Users
ORDER BY user_id;
-- 1527. Patients With a Condition
SELECT *
FROM Patients
WHERE conditions REGEXP '^DIAB1|[ ]+DIAB1';
-- 196. Delete Duplicate Emails
DELETE p1
FROM Person p1,
    Person p2
WHERE p1.email = p2.email
    AND p1.id > p2.id;
-- 176. Second Highest Salary
(
    SELECT salary as SecondHighestSalary
    FROM Employee
    GROUP BY salary
)
UNION
(
    SELECT NULL
)
ORDER BY SecondHighestSalary DESC
LIMIT 1 OFFSET 1;
-- 1484. Group Sold Products By The Date
SELECT a.sell_date,
    COUNT(DISTINCT a.product) as num_sold,
    GROUP_CONCAT(
        DISTINCT a.product
        ORDER BY a.product SEPARATOR ','
    ) as products
FROM Activities as a
GROUP BY sell_date
ORDER BY sell_date;
-- 1327. List the Products Ordered in a Period
SELECT p.product_name,
    SUM(o.unit) as unit
FROM Orders as o
    INNER JOIN Products as p ON(p.product_id = o.product_id)
WHERE YEAR(o.order_date) = 2020
    AND MONTH(o.order_date) = 02
GROUP BY o.product_id
HAVING SUM(o.unit) >= 100;
-- 1517. Find Users With Valid E-Mails
SELECT *
FROM Users
WHERE mail REGEXP '^[A-Za-z][A-Za-z0-9_\.-]*@leetcode\.com'
    AND mail NOT LIKE '%?%';