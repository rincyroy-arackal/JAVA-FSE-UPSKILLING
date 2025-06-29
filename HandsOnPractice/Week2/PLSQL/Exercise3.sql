-- Enable output
SET SERVEROUTPUT ON;

-- Drop tables if they already exist (ignore errors)
BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Accounts';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

BEGIN
  EXECUTE IMMEDIATE 'DROP TABLE Employees';
EXCEPTION WHEN OTHERS THEN NULL;
END;
/

-- Create Accounts table
CREATE TABLE Accounts (
  AccountID NUMBER PRIMARY KEY,
  AccountType VARCHAR2(20),
  Balance NUMBER
);

-- Create Employees table
CREATE TABLE Employees (
  EmployeeID NUMBER PRIMARY KEY,
  Name VARCHAR2(50),
  Salary NUMBER,
  DepartmentID NUMBER
);

-- Insert sample data into Accounts
INSERT INTO Accounts VALUES (1, 'SAVINGS', 10000);
INSERT INTO Accounts VALUES (2, 'CURRENT', 15000);
INSERT INTO Accounts VALUES (3, 'SAVINGS', 20000);
INSERT INTO Accounts VALUES (4, 'CURRENT', 8000);

-- Insert sample data into Employees
INSERT INTO Employees VALUES (101, 'Alice', 50000, 10);
INSERT INTO Employees VALUES (102, 'Bob', 60000, 20);
INSERT INTO Employees VALUES (103, 'Charlie', 55000, 10);
INSERT INTO Employees VALUES (104, 'Diana', 65000, 30);

COMMIT;

-- Procedure 1: Process monthly interest for savings accounts
CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest IS
BEGIN
  FOR acc IN (SELECT AccountID, Balance FROM Accounts WHERE AccountType = 'SAVINGS') LOOP
    UPDATE Accounts
    SET Balance = Balance + (acc.Balance * 0.01)
    WHERE AccountID = acc.AccountID;

    DBMS_OUTPUT.PUT_LINE('Interest added to Account ID: ' || acc.AccountID);
  END LOOP;

  COMMIT;
END;
/

-- Procedure 2: Update employee bonus
CREATE OR REPLACE PROCEDURE UpdateEmployeeBonus (
  p_DepartmentID IN NUMBER,
  p_BonusPercent IN NUMBER
) IS
BEGIN
  FOR emp IN (SELECT EmployeeID, Salary FROM Employees WHERE DepartmentID = p_DepartmentID) LOOP
    UPDATE Employees
    SET Salary = Salary + (emp.Salary * p_BonusPercent / 100)
    WHERE EmployeeID = emp.EmployeeID;

    DBMS_OUTPUT.PUT_LINE('Bonus applied to Employee ID: ' || emp.EmployeeID);
  END LOOP;

  COMMIT;
END;
/

-- Procedure 3: Transfer funds
CREATE OR REPLACE PROCEDURE TransferFunds (
  p_SourceAccountID IN NUMBER,
  p_TargetAccountID IN NUMBER,
  p_Amount IN NUMBER
) IS
  v_SourceBalance NUMBER;
BEGIN
  SELECT Balance INTO v_SourceBalance
  FROM Accounts
  WHERE AccountID = p_SourceAccountID
  FOR UPDATE;

  IF v_SourceBalance < p_Amount THEN
    RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
  END IF;

  UPDATE Accounts
  SET Balance = Balance - p_Amount
  WHERE AccountID = p_SourceAccountID;

  UPDATE Accounts
  SET Balance = Balance + p_Amount
  WHERE AccountID = p_TargetAccountID;

  DBMS_OUTPUT.PUT_LINE('Transferred ' || p_Amount || ' from Account ' || p_SourceAccountID || ' to Account ' || p_TargetAccountID);

  COMMIT;
END;
/

-- === Call all procedures ===
BEGIN
  ProcessMonthlyInterest;
  UpdateEmployeeBonus(10, 10); -- 10% bonus for dept 10
  TransferFunds(1, 2, 2000);   -- Transfer ₹2000 from Account 1 to 2
END;
/

-- === View updated data ===
SELECT * FROM Accounts;
SELECT * FROM Employees;
