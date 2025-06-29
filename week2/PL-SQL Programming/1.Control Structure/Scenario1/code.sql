BEGIN
    FOR res IN (
        SELECT c.name, c.customerID, l.loanId, l.interestRate
        FROM loans l
        JOIN customers c ON l.customerid = c.customerid
        WHERE TRUNC(MONTHS_BETWEEN(SYSDATE, c.dob) / 12) > 60
    ) LOOP
        UPDATE loans
        SET interestRate = res.interestRate - 1
        WHERE loanID = res.loanID;
    END LOOP;

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Interest rates updated for customers above 60.');
END;
/


SELECT
    loans.*,
    loans.loanid       AS loanid1,
    loans.customerid   AS customerid1,
    loans.loanamount   AS loanamount1,
    loans.interestrate AS interestrate1,
    loans.startdate    AS startdate1,
    loans.enddate      AS enddate1
FROM
    loans
