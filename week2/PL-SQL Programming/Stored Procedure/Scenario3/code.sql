
CREATE OR REPLACE PROCEDURE TransferFunds(
    p_fromAccountID IN NUMBER,
    p_toAccountID   IN NUMBER,
    p_amount        IN NUMBER
)
AS
    v_fromBalance NUMBER;
BEGIN
    -- Get balance of source account
    SELECT Balance INTO v_fromBalance
    FROM Accounts
    WHERE AccountID = p_fromAccountID;

    -- Check for sufficient balance
    IF v_fromBalance < p_amount THEN
        RAISE_APPLICATION_ERROR(-20001, 'Insufficient funds in source account.');
    END IF;

    -- Deduct amount from source account
    UPDATE Accounts
    SET Balance = Balance - p_amount
    WHERE AccountID = p_fromAccountID;

    -- Add amount to destination account
    UPDATE Accounts
    SET Balance = Balance + p_amount
    WHERE AccountID = p_toAccountID;

    -- Commit the changes
    COMMIT;

    -- Success message
    DBMS_OUTPUT.PUT_LINE('Funds transferred successfully.');

EXCEPTION
    WHEN OTHERS THEN
        ROLLBACK;
        DBMS_OUTPUT.PUT_LINE('Error occurred: ' || SQLERRM);
END;
/
EXEC TransferFunds(1, 2, 500);
