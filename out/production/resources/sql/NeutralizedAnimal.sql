-- Programmers
-- SQL - Level4
-- 보호소에서 중성화한 동물
SELECT
    AI.ANIMAL_ID, AI.ANIMAL_TYPE, AI.NAME
FROM
    ANIMAL_INS AS AI
INNER JOIN
    ANIMAL_OUTS AS AO
ON
    AI.ANIMAL_ID = AO.ANIMAL_ID
WHERE
    AO.SEX_UPON_OUTCOME IN ("Neutered Male", "Spayed Female")
AND
    AI.SEX_UPON_INTAKE IN ("Intact Male", "Intact Female");
