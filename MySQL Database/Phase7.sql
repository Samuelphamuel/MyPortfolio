--Samuel Pham
--Phase 7

--1
SELECT A_Name
FROM Agent
WHERE A_AssistantID = 'A10';

--2
SELECT *
FROM House, Buyer
WHERE H_Price >= B_LowerPrice
AND H_Price <= B_UpperPrice
AND B_Name = 'Will Smith';

--3
SELECT DISTINCT A_Name --I noticed John Nicklow would appear twice so I made it Distinct for easier readability
FROM Agent, House, Buyer
WHERE H_Price >= B_LowerPrice
AND H_Price <= B_UpperPrice 
AND B_Name = 'Will Smith'
AND H_AgentID = A_ID;

--4
SELECT DISTINCT H_Neighborhood, COUNT(*), COUNT(DISTINCT H_AgentID)
FROM House
GROUP BY H_Neighborhood, H_AgentID;

--5
SELECT B_Name, COUNT(*)
FROM Buyer, Dependent
GROUP BY B_Name
WHERE B_SSN = D_BuyerSSN;
HAVING COUNT(*) >= 2;
--I couldn't figure out what to do but I feel like it was something with these

--6
SELECT DISTINCT S_SSN, SUM(H_Price)
FROM Seller, House
WHERE S_SSN = H_SellerSSN
GROUP BY S_SSN
HAVING SUM(H_Price) > 500000;

--7
SELECT H_Address
FROM House
WHERE REGEXP_LIKE(H_Address, '[0-9]{2}[02468]\s.*');
--I couldn't figure out how to separate the three digit addresses from the four digit ones



commit;