-- Accounts Table
CREATE TABLE Accounts (
    AccountId NUMBER PRIMARY KEY,
    Balance NUMBER
);

-- Employees Table
CREATE TABLE Employees (
    EmployeeId NUMBER PRIMARY KEY,
    Name VARCHAR2(50),
    Salary NUMBER
);

-- Customers Table
CREATE TABLE Customers (
    CustomerId NUMBER PRIMARY KEY,
    CustomerName VARCHAR2(50),
    Email VARCHAR2(100)
);

-- Error Log Table
CREATE TABLE ErrorLog (
    ErrorTime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    ErrorMessage VARCHAR2(4000)
);
-- Sample data
INSERT INTO Accounts VALUES (101, 1000);
INSERT INTO Accounts VALUES (102, 500);

INSERT INTO Employees VALUES (1, 'Alice', 30000);
INSERT INTO Employees VALUES (2, 'Bob', 25000);

INSERT INTO Customers VALUES (201, 'Charlie', 'charlie@email.com');
CREATE OR REPLACE PROCEDURE SafeTransferFunds(
    fromAccount IN NUMBER,
    toAccount IN NUMBER,
    amount IN NUMBER
) IS
    insufficient_funds EXCEPTION;
BEGIN
    -- Check if sufficient balance
    DECLARE current_balance NUMBER;
    BEGIN
        SELECT Balance INTO current_balance FROM Accounts WHERE AccountId = fromAccount;

        IF current_balance < amount THEN
            RAISE insufficient_funds;
        END IF;

        -- Transfer
        UPDATE Accounts SET Balance = Balance - amount WHERE AccountId = fromAccount;
        UPDATE Accounts SET Balance = Balance + amount WHERE AccountId = toAccount;

        COMMIT;
    END;

EXCEPTION
    WHEN insufficient_funds THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Transfer failed: Insufficient funds');
    WHEN OTHERS THEN
        ROLLBACK;
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Transfer failed: ' || SQLERRM);
END;
/
CREATE OR REPLACE PROCEDURE UpdateSalary(
    empId IN NUMBER,
    percentage IN NUMBER
) IS
    emp_not_found EXCEPTION;
    PRAGMA EXCEPTION_INIT(emp_not_found, -01403); -- No data found
BEGIN
    UPDATE Employees
    SET Salary = Salary + (Salary * percentage / 100)
    WHERE EmployeeId = empId;

    IF SQL%NOTFOUND THEN
        RAISE emp_not_found;
    END IF;

    COMMIT;
EXCEPTION
    WHEN emp_not_found THEN
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Salary update failed: Employee not found');
    WHEN OTHERS THEN
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Salary update failed: ' || SQLERRM);
END;
/
CREATE OR REPLACE PROCEDURE AddNewCustomer(
    customerId IN NUMBER,
    customerName IN VARCHAR2,
    email IN VARCHAR2
) IS
    duplicate_customer EXCEPTION;
    PRAGMA EXCEPTION_INIT(duplicate_customer, -00001); -- Unique constraint violation
BEGIN
    INSERT INTO Customers (CustomerId, CustomerName, Email)
    VALUES (customerId, customerName, email);
    COMMIT;
EXCEPTION
    WHEN duplicate_customer THEN
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Insert failed: Customer already exists');
    WHEN OTHERS THEN
        INSERT INTO ErrorLog (ErrorMessage) VALUES ('Insert failed: ' || SQLERRM);
END;
/

