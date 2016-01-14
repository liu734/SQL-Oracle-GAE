rem Query 1
SELECT D.deptid, D.dname, COUNT (*)  FROM DEPARTMENT D, FACULTY F  WHERE D.deptid=F.deptid 
GROUP BY D.deptid, D.dname;

rem Query 2
SELECT F.fid,F.fname, F.deptid
FROM  FAUCLTY F,FAUCLTY F2,CLASS C
WHERE F.fid=C.fid AND F2.fid=C.fid
GROUP BY F.fid, F.fname, F.deptid, F2.fid,F2.fname, F2.deptid
HAVING COUNT(F.fid)>=COUNT(f2.fid);

rem Query 3
SELECT S.sname, S.deptid, S.age
FROM STUDENT S, FACULTY F, FACULTY F2, CLASS C,ENROLLED E, DEPARTMENT D
WHERE F.fid=C.fid AND F2.fid=C.fid AND S.snum=E.snum AND E.cname=C.cname AND D.dname LIKE 'Computer Sciences' AND D.deptid=F1.deptid AND D.deptid=F2.deptid
GROUP BY F.fid, F.fname, F.deptid, F2.fid,F2.fname, F2.deptid
HAVING COUNT(F.fid)>=COUNT(F2.fid);

rem Query 4
SELECT S.sname, s.deptid
FROM STUDENT S,CLASS C, ENROLLED E
WHERE S.snum=E.snum AND E.cname=C.cname
UNION
(
SELECT S.sname, s.deptid
FROM STUDENT S
WHERE S.age<=20
);


rem Query 5
SELECT DISTINCT S.snum
FROM STUDENT S, STUDENT S2, ENROLLED E, CLASS C
WHERE STUDNET S.snum=E.snum AND E.cname=C.cname AND S2.snum=E.snum AND S.snum NOT S2.snum;

rem Query 6
SELECT DISTANCT F.fid
FROM FACULTY F, CLASS C
WHERE  C.fid=F.fid
GROUP BY F.fid, C.room
COUNT (*)>1;

rem Query 7
SELECT D.deptid, AVG(S.age)
FROM DEPARTMENT D, STUDENT S
WHERE  D.dname NOT = 'Management' D.deptid=S.deptid;

rem Query 8
SELECT S1.snum, S2.sname, S.age
FROM STUDENT S, ENROLLED E, STUDENT S2
WHERE NOT EXISTS (S1.snume=E.snum  AND S2.snum=E.snum) AND S1.age<=S2.age ;

rem Query 9
SELECT S.snum
FROM STUDENT S, FACULTY F, CLASS C, DEPARTMENT D
WHERE S.deptid=D.deptid AND NOT EXISTS (F.fid==C.fid) AND D.deptid=F.deptid;

rem Query 10
SELECT FACULTY F.fname COUNT(*)
FROM STUDENT S, FACULTY F, ENROLLED E, CLASS C, STUDENT S2
WHERE S.snum = E.snum AND F.fid= C.fid AND S2.snum = E.snum AND E.cname=C.cname
GROUP BY C.cname 
HAVING COUNT(*)>=COUNT ;



