# 5. Найти клиента (customer), который приносит меньше
# всего прибыли компании (company) для каждой из компаний .

create temporary table tmp
SELECT companies.name, customers.id, sum(projects.cost) summ
FROM companies
JOIN projects ON projects.company_id = companies.id
JOIN customers ON customers.id = projects.customer_id
GROUP BY companies.name, customers.name;
select * from tmp;

select
tmp.name, customers.*, min(tmp.summ)
from tmp, customers, companies
WHERE tmp.name = companies.name AND customers.id = tmp.id
group by companies.name