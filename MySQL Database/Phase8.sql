--Samuel Pham
--Phase 8

--1.
--ALTER TABLE Agent ADD HousesListed NUMBER DEFAULT 0;
--UPDATE Agent SET HousesListed = 0; 
--DROP TRIGGER AddingHouse;
--DELETE FROM House;

CREATE OR REPLACE TRIGGER AddingHouse
AFTER INSERT ON House
FOR EACH ROW
DECLARE
	HousesListed INTEGER;
BEGIN
	DBMS_OUTPUT.PUT_LINE('Adding new house');
	
	UPDATE Agent
	SET HousesListed = HousesListed + 1
	WHERE A_ID = :new.H_AgentID;
	
	IF (HousesListed = 4) THEN
		RAISE_APPLICATION_ERROR(-20001, 'Agent is too busy!');
	END IF;
	
END;
/

--2.
--DROP TRIGGER RemovingHouse;
--DELETE FROM House WHERE ID = 'H07';

CREATE OR REPLACE TRIGGER RemovingHouse
AFTER DELETE ON House
FOR EACH ROW
BEGIN
	DBMS_OUTPUT.PUT_LINE('Removing old house');
	
	UPDATE Agent
	SET HousesListed = HousesListed - 1
	WHERE A_ID = :old.H_AgentID;

END;
/

--3.
--UPDATE House
--SET H_AgentID = 'A04'
--WHERE H_ID = 'H02';

--UPDATE House
--SET H_AgentID = 'A01'
--WHERE H_ID = 'H02';

--SELECT * FROM Agent;

CREATE OR REPLACE TRIGGER UpdatingHouse
AFTER UPDATE ON House
FOR EACH ROW
DECLARE
	HousesListed INTEGER;
BEGIN
	DBMS_OUTPUT.PUT_LINE('Changing House Agents');
	
	UPDATE Agent
	SET HousesListed = HousesListed + 1
	WHERE A_ID = :new.H_AgentID;
	
	UPDATE Agent
	SET HousesListed = HousesListed - 1
	WHERE A_ID = :old.H_AgentID;
	
	IF (HousesListed = 4) THEN
		RAISE_APPLICATION_ERROR(-20002, 'Agent is too busy!');
	END IF;

END;
/