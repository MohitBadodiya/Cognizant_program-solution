CREATE OR REPLACE PROCEDURE ProcessMonthlyInterest
AS
BEGIN
    -- Loop through all Savings accounts
    FOR res IN (
        SELECT AccountID, Balance 
        FROM Accounts 
        WHERE AccountType = 'Savings'
    ) LOOP
        -- Update balance by adding 1% interest
        UPDATE Accounts
        SET Balance = Balance + (Balance * 0.01)
        WHERE AccountID = res.AccountID;
    END LOOP;

    -- Commit the changes
    COMMIT;

    -- Display message
    DBMS_OUTPUT.PUT_LINE('Monthly interest applied to all Savings accounts.');
END;
/
EXEC ProcessMonthlyInterest;

