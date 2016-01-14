CREATE VIEW VIEWA AS
SELECT F.fname, COUNT(*)
FROM FACULTY F, CLASS C
WHERE F.fid = C.fid 
GROUP BY F.fid

CREATE VIEW VIEWB AS
SELECT S.sname, C.room, C.meets_at 
FROM STUDENT S, ENROLLED E, CLASS C
WHERE S.snum=E.snum AND E.cname= C.cname  
UNION 
(
SELECT F.fname , C.room, C.meets_at
FORM FACULTY F, CLASS C
WHERE F.fid = C.fid
)