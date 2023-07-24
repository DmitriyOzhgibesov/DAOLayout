SELECT product_name FROM orders
                             join customers on customers.id = orders.customer_id
WHERE customers.name = :name