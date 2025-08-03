-- ================================
-- Create Supporting Table
-- ================================
CREATE TABLE Accounts (
  AccountId NUMBER PRIMARY KEY,
  Balance NUMBER
);

-- Insert sample data
INSERT INTO Accounts VALUES (101, 1500);
INSERT INTO Accounts VALUES (102, 500);

-- ================================
-- Function 1: CalculateAge
-- ================================
CREATE OR REPLACE FUNCTION CalculateAge (dob DATE)
RETURN NUMBER
IS
  age NUMBER;
BEGIN
  age := TRUNC(MONTHS_BETWEEN(SYSDATE, dob) / 12);
  RETURN age;
END;
/

-- ================================
-- Function 2: CalculateMonthlyInstallment
-- ================================
CREATE OR REPLACE FUNCTION CalculateMonthlyInstallment (
  loan_amount NUMBER,
  annual_interest_rate NUMBER,
  duration_years NUMBER
) RETURN NUMBER
IS
  monthly_rate NUMBER := annual_interest_rate / 12 / 100;
  months NUMBER := duration_years * 12;
  emi NUMBER;
BEGIN
  IF monthly_rate = 0 THEN
    emi := loan_amount / months;
  ELSE
    emi := loan_amount * monthly_rate / (1 - POWER(1 + monthly_rate, -months));
  END IF;
  RETURN ROUND(emi, 2);
END;
/

-- ================================
-- Function 3: HasSufficientBalance
-- ================================
CREATE OR REPLACE FUNCTION HasSufficientBalance (
  p_account_id NUMBER,
  p_amount NUMBER
) RETURN BOOLEAN
IS
  current_balance NUMBER;
BEGIN
  SELECT Balance INTO current_balance
  FROM Accounts
  WHERE AccountId = p_account_id;

  RETURN current_balance >= p_amount;
EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN FALSE;
END;
/

-- ================================
-- Testing the Functions
-- ================================
-- Enable output
SET SERVEROUTPUT ON;

BEGIN
  -- Test CalculateAge
  DBMS_OUTPUT.PUT_LINE('Age for DOB 1990-01-01: ' || CalculateAge(TO_DATE('1990-01-01', 'YYYY-MM-DD')));

  -- Test CalculateMonthlyInstallment
  DBMS_OUTPUT.PUT_LINE('Monthly EMI for 500000 @ 7.5% for 10 years: ' || CalculateMonthlyInstallment(500000, 7.5, 10));

  -- Test HasSufficientBalance
  IF HasSufficientBalance(101, 1000) THEN
    DBMS_OUTPUT.PUT_LINE('Account 101: Sufficient Balance');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Account 101: Insufficient Balance');
  END IF;

  IF HasSufficientBalance(102, 1000) THEN
    DBMS_OUTPUT.PUT_LINE('Account 102: Sufficient Balance');
  ELSE
    DBMS_OUTPUT.PUT_LINE('Account 102: Insufficient Balance');
  END IF;
END;
/
