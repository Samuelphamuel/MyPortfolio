--Samuel Pham
--Phase 6

--1
SELECT DISTINCT A_Name
FROM Agent, House
WHERE H_AgentID = A_ID;


--2
SELECT DISTINCT H_Neighborhood, AVG(H_Price)
FROM House
WHERE H_Neighborhood = H_Neighborhood
GROUP BY H_Neighborhood;

--3
SELECT DISTINCT A_Name
FROM Agent LEFT OUTER JOIN House
ON H_AgentID = A_ID
WHERE H_AgentID IS NULL;

--Or WHERE A_ID NOT IN (SELECT H_AgentID FROM House)

--4
SELECT AVG(H_Price)
FROM House, Seller
WHERE S_Name = 'Katy Perry';



commit;