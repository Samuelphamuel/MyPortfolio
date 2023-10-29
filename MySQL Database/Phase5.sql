--Samuel Pham
--Phase 5

--1
SELECT *
FROM House
WHERE H_Price > 340000;

--2
SELECT *
FROM House
WHERE H_Neighborhood = 'French Quarter'
ORDER BY H_Price;

--3
SELECT *
FROM House
WHERE H_Address LIKE '%Bourbon';

--4
SELECT *
FROM Agent
WHERE A_AssistantID IS NULL;

--5
SELECT *
FROM Buyer
WHERE B_UpperPrice BETWEEN 325000 AND 350000;

--6
SELECT *
FROM Buyer
WHERE B_AgentID = 'A01';

--7
SELECT MIN(H_Price), MAX(H_PRICE) FROM House;

--8
SELECT AVG(H_Price)
FROM House;

--9
SELECT *
FROM House
WHERE H_Price = (SELECT MAX(H_Price) FROM House);

--10
SELECT AVG(H_Price)*1.2 --To find the Average House Price + 20%
FROM House;

SELECT *
FROM House
WHERE H_Price < (SELECT (AVG(H_Price)*1.2) FROM House);




commit;