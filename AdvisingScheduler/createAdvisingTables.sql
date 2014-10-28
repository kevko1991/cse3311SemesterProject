CREATE TABLE "APPOINTMENT"(   "ApptID" INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    "ApptDate" DATE NOT NULL,
    "ApptStartHour" INTEGER NOT NULL,
    "ApptStartMin" INTEGER NOT NULL,
    "ApptEndHour" INTEGER NOT NULL,
    "ApptEndMin" INTEGER NOT NULL,
    "ApptType" VARCHAR(20),
    "Description" VARCHAR(100),
    "StudentID" CHAR(10) NOT NULL,
    "StudentName" VARCHAR(20),
    "AdvisorName" VARCHAR(20) NOT NULL
);


CREATE TABLE "SLOT"(   "SlotID" INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),
    "SlotDate" DATE NOT NULL,
    "SlotStartHour" INTEGER NOT NULL,
    "SlotStartMin" INTEGER NOT NULL
);

CREATE VIEW "APPTFW" AS
SELECT "ApptID", "ApptDate", "ApptStartHour", "ApptStartMin", "ApptEndHour", "ApptEndMin"
From APPOINTMENT
ORDER BY "ApptDate";

CREATE VIEW "APPTSLOT" AS
SELECT SLOT.*, APPTFW."ApptID"
FROM SLOT, APPTFW
WHERE(SLOT."SlotDate" = APPTFW."ApptDate" AND SLOT."SlotStartHour" = APPTFW."ApptStartHour" AND SLOT."SlotStartMin" >= APPTFW."ApptStartMin")
OR (SLOT."SlotDate" = APPTFW."ApptDate" AND SLOT."SlotStartHour" > APPTFW."ApptStartHour" AND SLOT."SlotStartHour" < APPTFW."ApptEndHour")
OR (SLOT."SlotDate" = APPTFW."ApptDate" AND SLOT."SlotStartHour" = APPTFW."ApptEndHour" AND SLOT."SlotStartMin" < APPTFW."ApptEndMin");

CREATE VIEW "AVAILSLOT" AS 
SELECT * FROM SLOT
EXCEPT SELECT "SlotID", "SlotDate", "SlotStartHour", "SlotStartMin" FROM APPTSLOT;