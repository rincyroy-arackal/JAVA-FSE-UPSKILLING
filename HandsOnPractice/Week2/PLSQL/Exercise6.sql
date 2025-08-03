-- =====================================
-- Setup: Tables for all scenarios
-- =====================================

-- Transactions Table

CREATE TABLE Transactions (
  TransactionId NUMBER PRIMARY KEY,
  CustomerId NUMBER,
  Amount NUMBER,
  Type VARCHAR2(20),
  TransactionDate DATE
);

-- Sample transactions for current month
INSERT INTO Transactions VALUES (1, 101, 200, 'deposit', SYSDATE - 1);
INSERT INTO Transactions VALUES (2, 102, 100, 'withdrawal', SYSDATE - 2);
INSERT INTO Transactions VALUES (3, 101, 300, 'deposit', SYSDATE - 10);

-- Accounts Table

CREATE TABLE Accounts (
  AccountId NUMBER PRIMARY KEY,
  CustomerId NUMBER,
  Balance NUMBER
);

-- Sample accounts
INSERT INTO Accounts VALUES (201, 101, 1000);
INSERT INTO Accounts VALUES (202, 102, 1500);

-- Loans Table

CREATE TABLE Loans (
  LoanId NUMBER PRIMARY KEY,
  CustomerId NUMBER,
  Amount NUMBER,
  InterestRate NUMBER
);

-- Sample loans
INSERT INTO Loans VALUES (301, 101, 10000, 7.5);
INSERT INTO Loans VALUES (302, 102, 20000, 8.0);

COMMIT;

-- =====================================
-- Scenario 1: GenerateMonthlyStatements
-- =====================================
BEGIN
  DBMS_OUTPUT.PUT_LINE('--- Monthly Customer Statements ---');

  FOR txn_rec IN (
    SELECT CustomerId, Amount, Type, TransactionDate
    FROM Transactions
    WHERE TRUNC(TransactionDate, 'MM') = TRUNC(SYSDATE, 'MM')
    ORDER BY CustomerId
  ) LOOP
    DBMS_OUTPUT.PUT_LINE('Customer ID: ' || txn_rec.CustomerId ||
                         ' | Amount: ' || txn_rec.Amount ||
                         ' | Type: ' || txn_rec.Type ||
                         ' | Date: ' || txn_rec.TransactionDate);
  END LOOP;

END;
/

-- =====================================
-- Scenario 2: ApplyAnnualFee
-- =====================================
DECLARE
  CURSOR acc_cursor IS
    SELECT AccountId, Balance FROM Accounts;

  v_fee NUMBER := 100; -- annual maintenance fee

BEGIN
  FOR acc_rec IN acc_cursor LOOP
    UPDATE Accounts
    SET Balance = Balance - v_fee
    WHERE AccountId = acc_rec.AccountId;

    DBMS_OUTPUT.PUT_LINE('Fee applied to Account ID: ' || acc_rec.AccountId ||
                         ' | New Balance: ' || (acc_rec.Balance - v_fee));
  END LOOP;

  COMMIT;
END;
/

-- =====================================
-- Scenario 3: UpdateLoanInterestRates
-- =====================================
DECLARE
  CURSOR loan_cursor IS
    SELECT LoanId, InterestRate FROM Loans;

  v_new_rate NUMBER;

BEGIN
  FOR loan_rec IN loan_cursor LOOP
    -- Sample policy: increase interest rate by 0.5% if below 8%
    IF loan_rec.InterestRate < 8 THEN
      v_new_rate := loan_rec.InterestRate + 0.5;
    ELSE
      v_new_rate := loan_rec.InterestRate; -- no change
    END IF;

    UPDATE Loans
    SET InterestRate = v_new_rate
    WHERE LoanId = loan_rec.LoanId;

    DBMS_OUTPUT.PUT_LINE('Loan ID: ' || loan_rec.LoanId ||
                         ' | Old Rate: ' || loan_rec.InterestRate ||
                         ' | New Rate: ' || v_new_rate);
  END LOOP;

  COMMIT;
END;
/

-- =====================================
-- Check Final Results
-- =====================================
SELECT * FROM Accounts;
SELECT * FROM Loans;
