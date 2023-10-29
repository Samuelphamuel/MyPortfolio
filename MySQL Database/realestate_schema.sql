DROP TABLE Seller;
DROP TABLE Agent;
DROP TABLE House;
DROP TABLE Buyer;
DROP TABLE Dependent;

CREATE TABLE Seller(
	S_SSN CHAR(11),
	S_Name VARCHAR(30),
	S_Phone CHAR(12),
	
	CONSTRAINT SellerPK PRIMARY KEY (S_SSN)
	
);


CREATE TABLE Agent(
	A_ID CHAR(3),
	A_Name VARCHAR(30),
	A_Phone CHAR(12),
	A_AssistantID CHAR(3),
	
	CONSTRAINT AgentPK PRIMARY KEY (A_ID),
	CONSTRAINT AgentFK FOREIGN KEY (A_AssistantID)
		REFERENCES Agent(A_ID)
);


CREATE TABLE House(
	H_ID CHAR(3),
	H_Address VARCHAR(30),
	H_Neighborhood VARCHAR(30),
	H_Price NUMBER(9),
	H_SquareFeet NUMBER(9),
	H_SellerSSN CHAR(11),
	H_AgentID CHAR(3),
	
	CONSTRAINT HousePK PRIMARY KEY (H_ID),
	CONSTRAINT HouseFK FOREIGN KEY (H_SellerSSN)
		REFERENCES Seller(S_SSN),
	CONSTRAINT HouseFK2 FOREIGN KEY (H_AgentID)
		REFERENCES Agent(A_ID)
);


CREATE TABLE Buyer(
	B_SSN CHAR(11),
	B_Name VARCHAR(30),
	B_LowerPrice NUMBER(9),
	B_UpperPrice NUMBER(9),
	B_AgentID CHAR(3),
	
	CONSTRAINT BuyerPK PRIMARY KEY (B_SSN),
	CONSTRAINT BuyerFK FOREIGN KEY (B_AGENTID)
		REFERENCES Agent(A_ID)
);


CREATE TABLE Dependent(
	D_BuyerSSN CHAR(11),
	D_Name VARCHAR(30),
	D_Age NUMBER (3),

	CONSTRAINT DependentPK PRIMARY KEY (D_BuyerSSN, D_Name),
	CONSTRAINT DependentFK FOREIGN KEY (D_BuyerSSN)
		REFERENCES Buyer(B_SSN)
);
