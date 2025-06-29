-- Create Customers table
CREATE TABLE Customers (
  CustomerID NUMBER PRIMARY KEY,
  Name VARCHAR2(50),
  Age NUMBER,
  Balance NUMBER,
  LoanInterestRate NUMBER,
  IsVIP VARCHAR2(10)
);

-- Create Loans table
CREATE TABLE Loans (
  LoanID NUMBER PRIMARY KEY,
  CustomerID NUMBER,
  DueDate DATE,
  FOREIGN KEY (CustomerID) REFERENCES Customers(CustomerID)
);
-- Insert into Customers
INSERT INTO Customers VALUES (1, 'Alice', 65, 12000, 10.5, 'FALSE');
INSERT INTO Customers VALUES (2, 'Bob', 45, 8000, 11.0, 'FALSE');
INSERT INTO Customers VALUES (3, 'Charlie', 70, 15000, 9.0, 'FALSE');

-- Insert into Loans
INSERT INTO Loans VALUES (101, 1, SYSDATE + 10);
INSERT INTO Loans VALUES (102, 2, SYSDATE + 40);
INSERT INTO Loans VALUES (103, 3, SYSDATE + 5);

COMMIT;

BEGIN
  -- Scenario 1: Apply 1% interest discount for customers above 60
  FOR cust IN (SELECT CustomerID, Age FROM Customers) LOOP
    IF cust.Age > 60 THEN
      UPDATE Customers
      SET LoanInterestRate = LoanInterestRate - 1
      WHERE CustomerID = cust.CustomerID;
      
      DBMS_OUTPUT.PUT_LINE('Interest rate discount applied for Customer ID: ' || cust.CustomerID);
    END IF;
  END LOOP;

  -- Scenario 2: Promote to VIP if balance > 10000
  FOR cust IN (SELECT CustomerID, Balance FROM Customers) LOOP
    IF cust.Balance > 10000 THEN
      UPDATE Customers
      SET IsVIP = 'TRUE'
      WHERE CustomerID = cust.CustomerID;

      DBMS_OUTPUT.PUT_LINE('Customer ID: ' || cust.CustomerID || ' promoted to VIP.');
    END IF;
  END LOOP;

  -- Scenario 3: Print loan reminders due within 30 days
  FOR loan IN (
    SELECT l.LoanID, l.CustomerID, l.DueDate, c.Name
    FROM Loans l
    JOIN Customers c ON l.CustomerID = c.CustomerID
    WHERE l.DueDate BETWEEN SYSDATE AND SYSDATE + 30
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Reminder: Loan ' || loan.LoanID || ' for customer ' || loan.Name || 
                         ' is due on ' || TO_CHAR(loan.DueDate, 'DD-MON-YYYY'));
  END LOOP;

  COMMIT;
END;