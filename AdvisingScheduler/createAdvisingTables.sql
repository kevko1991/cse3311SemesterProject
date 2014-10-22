DROP VIEW APPOINTMENTFLYWEIGHT;
DROP TABLE APPOINTMENT;
DROP TABLE SLOT;
CREATE TABLE "APPOINTMENT"(   "ApptID" INTEGER NOT NULL PRIMARY KEY,
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


CREATE TABLE "SLOT"(   "SlotID" INTEGER NOT NULL PRIMARY KEY,
    "SlotDate" DATE NOT NULL,
    "SlotStartHour" INTEGER NOT NULL,
    "SlotStartMin" INTEGER NOT NULL,
    "SlotEndHour" INTEGER NOT NULL,
    "SlotEndMin" INTEGER NOT NULL
);

CREATE VIEW "APPOINTMENTFLYWEIGHT" AS
SELECT "ApptDate", "ApptStartHour", "ApptStartMin", "ApptEndHour", "ApptEndMin"
From APPOINTMENT
ORDER BY "ApptDate";
