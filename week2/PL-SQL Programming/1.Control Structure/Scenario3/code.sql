BEGIN
    FOR res IN (
        SELECT c.Name, l.LoanAmount, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30
    ) LOOP
        DBMS_OUTPUT.PUT_LINE(
            'Reminder: ' || res.Name || 
            ', your loan of $' || res.LoanAmount || 
            ' is due on ' || TO_CHAR(res.EndDate, 'DD-MON-YYYY')
        );
    END LOOP;
END;
/

