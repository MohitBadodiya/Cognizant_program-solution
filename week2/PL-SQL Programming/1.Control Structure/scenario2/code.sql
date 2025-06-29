ALTER TABLE Customers ADD IsVIP VARCHAR2(5);


BEGIN
    -- Loop through customers with balance > 10000
    FOR res IN (
        SELECT CustomerID, Name, Balance 
        FROM Customers 
        WHERE Balance > 10000
    ) LOOP
        -- Update IsVIP flag to 'TRUE'
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = res.CustomerID;
    END LOOP;

    COMMIT;

    DBMS_OUTPUT.PUT_LINE('VIP status updated for customers with balance over $10,000.');
END;
/

SELECT CustomerID, Name, Balance, IsVIP FROM Customers;

