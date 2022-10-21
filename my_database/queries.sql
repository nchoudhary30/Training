-- 11
select user_name from users where user_id in (select user_id from transactions where status='failed');

-- 10
select user_name from users where user_id not in (select user_id from orders);

-- 6
select * from coupons where expiry > NOW();

-- 1
select user_name from users where user_id=(select user_id from orders group by user_id order by count(*) desc limit 1);

-- 4
select * from transactions where status='failed' and user_id=2881;

-- 7
select * from products where product_id=(select product_id from "product review" group by product_id order by max(rating) desc limit 1);
select product_id, max(rating)  from "product review" group by product_id order by min(rating);

-- 2
select user_id, user_name from users where user_id in (select user_id from transactions group by user_id order by sum(amount) desc limit 1);
select user_id, user_name from users where user_id in (select user_id from transactions group by user_id order by sum(amount) asc limit 1);

-- 8
select * from orders where order_id in (select order_id from items where quantity>2);

-- 12
select * from users where date_part('day', user_dob) = date_part('day', CURRENT_DATE) and date_part('month', user_dob) = date_part('month', CURRENT_DATE);