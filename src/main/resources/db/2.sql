#2. Найти самый дорогой проект (исходя из ЗП разработчиков).

SELECT projects.id,projects.name, sum(developers.salary) sum_salary FROM developers
JOIN projects on projects.id = developers.project_id
group by projects.name ORDER by sum_salary DESC LIMIT 1;

