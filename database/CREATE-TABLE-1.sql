DROP TABLE USE_TREAT;
DROP TABLE USE_EXAM;
DROP TABLE MEDICATION;
DROP TABLE TREATMENT;
DROP TABLE EXAMINATION;
DROP TABLE OUTPATIENT;
DROP TABLE INPATIENT;
DROP TABLE PATIENT;
DROP TABLE DOCTOR;
DROP TABLE NURSE;
DROP TABLE EMP_PHONE;
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;
DROP TABLE LOGIN_TABLE;

CREATE TABLE DEPARTMENT
(
    DID                     NUMBER               NOT NULL,
    DTitle                  VARCHAR(50)          NOT NULL,
    EID                     VARCHAR(5)           NOT NULL, /*Employee: Dxxxx */
    PRIMARY KEY(DID)
);

CREATE TABLE EMPLOYEE 
(
    EID                     VARCHAR(5)          NOT NULL, 
    EFname                  VARCHAR(20)         NOT NULL,
    ELname                  VARCHAR(20)         NOT NULL,
    EDoB                    DATE                        ,
    EGenre                  CHAR(1)                     ,
    ESpeciality             VARCHAR(50)                 ,
    EAddress                VARCHAR(100)                ,
    EStartDate              DATE                        ,
    DID                     NUMBER              NOT NULL,
    PRIMARY KEY(EID)
);

CREATE TABLE EMP_PHONE
(
    EID                     VARCHAR(5)          NOT NULL, /* Doctor: 1xxxxxx  Nurse: 2xxxxxx */
    EPhone                  VARCHAR(15)         NOT NULL,
    PRIMARY KEY(EID, EPhone)
);

CREATE TABLE DOCTOR
(
    EID_Doc                 VARCHAR(5)          NOT NULL, /* Doctor: Dxxxx */
    PRIMARY KEY(EID_Doc)
);

CREATE TABLE NURSE
(
    EID_Nur                 VARCHAR(5)          NOT NULL, 
    PRIMARY KEY(EID_Nur)
);

CREATE TABLE PATIENT
(
    PID                     VARCHAR(7)         NOT NULL, /* Inpatient: IPxxxxxx   Outpatient: OPxxxxx */
    PFname                  VARCHAR(20)         NOT NULL,
    PLname                  VARCHAR(20)         NOT NULL,
    PDoB                    DATE                NOT NULL,
    PGenre                  VARCHAR(1)          NOT NULL,
    PAddress                VARCHAR(100)        NOT NULL,
    PPhone                  NUMERIC(15)         NOT NULL,
    PRIMARY KEY(PID)
);

CREATE TABLE OUTPATIENT
(
    PID_Out                 VARCHAR(7)         NOT NULL, /* Outpatient: OPxxxxxx */
    EID_Doc                 VARCHAR(5)         NOT NULL, 
    PRIMARY KEY(PID_Out)
);

CREATE TABLE INPATIENT
(
    PID_In                  VARCHAR(7)         NOT NULL, /* Inpatient: IPxxxxx */
    PAdmissionDate         DATE                NOT NULL,
    PDischargeDate          DATE                NOT NULL,
    PDiagnosis              VARCHAR(100)        NOT NULL,
    PSickroom               VARCHAR(10)         NOT NULL,
    PFee                    FLOAT               NOT NULL,
    EID_Doc                 VARCHAR(5)         NOT NULL, 
    EID_Nur                 VARCHAR(5)                 , 
    PRIMARY KEY(PID_In)
);

CREATE TABLE EXAMINATION
(
    EID_Doc                 VARCHAR(5)          NOT NULL,
    PID_Out                 VARCHAR(7)          NOT NULL,
    Ex_ID                   VARCHAR(6)          NOT NULL, /*MOxxxx*/
    ExDate                  DATE                NOT NULL,
    ExFee                   FLOAT               NOT NULL,
    ExDiagnosis             VARCHAR(100)        NOT NULL,
    ExSecond_Examination_Date DATE              NOT NULL,
    PRIMARY KEY(EID_Doc, PID_Out, Ex_ID)
);

CREATE TABLE TREATMENT
(
    EID_Doc                 VARCHAR(5)           NOT NULL, 
    PID_In                  VARCHAR(7)           NOT NULL, /* Inpatient: IPxxxxx */
    TrID                    VARCHAR(7)           NOT NULL, /*TRxxxxx*/
    TrStart                 DATE                 NOT NULL,
    TrEnd                   DATE                 NOT NULL,
    TrResult                VARCHAR(100)         NOT NULL,
    PRIMARY KEY(EID_Doc, PID_In, TrID)
);

CREATE TABLE MEDICATION
(
    MID                     VARCHAR(8)          NOT NULL, /*MExxxxxx*/
    MName                   VARCHAR(20)         NOT NULL,
    MEffects                VARCHAR(100)        NOT NULL,
    MPrice                  FLOAT               NOT NULL,
    PRIMARY KEY(MID)
);

CREATE TABLE Use_Exam
(
    EID_Doc                 VARCHAR(5)         NOT NULL, 
    PID_Out                 VARCHAR(7)         NOT NULL, /* Outpatient: OPxxxxx */
    ExID                    VARCHAR(6)         NOT NULL,
    MID                     VARCHAR(8)         NOT NULL,
    PRIMARY KEY(EID_Doc, PID_Out, ExID, MID)
);

CREATE TABLE Use_Treat
(
    EID_Doc                 VARCHAR(5)         NOT NULL, /* Doctor: D**** */
    PID_In                  VARCHAR(7)         NOT NULL, /* Inpatient: IPxxxxx*/
    TrID                    VARCHAR(7)         NOT NULL,
    MID                     VARCHAR(8)         NOT NULL,
    PRIMARY KEY(EID_Doc, PID_In, TrID, MID)
);

CREATE TABLE LOGIN_TABLE
(
    USERNAME                VARCHAR(20)        NOT NULL,
    PASSWORD                VARCHAR(20)        NOT NULL,
    PRIMARY KEY(USERNAME,PASSWORD)
);



ALTER TABLE EMPLOYEE
ADD FOREIGN KEY(DID) REFERENCES DEPARTMENT(DID) ON DELETE SET NULL;

ALTER TABLE EMP_PHONE
ADD FOREIGN KEY(EID) REFERENCES EMPLOYEE(EID) ON DELETE CASCADE;

ALTER TABLE DOCTOR
ADD FOREIGN KEY(EID_Doc) REFERENCES EMPLOYEE(EID) ON DELETE CASCADE;

ALTER TABLE NURSE
ADD FOREIGN KEY(EID_Nur) REFERENCES EMPLOYEE(EID) ON DELETE CASCADE;

ALTER TABLE OUTPATIENT
ADD FOREIGN KEY(PID_OUT) REFERENCES PATIENT(PID) ON DELETE CASCADE;

ALTER TABLE OUTPATIENT
ADD FOREIGN KEY(EID_DOC) REFERENCES DOCTOR(EID_DOC) ON DELETE CASCADE;

ALTER TABLE INPATIENT
ADD FOREIGN KEY(PID_IN) REFERENCES PATIENT(PID) ON DELETE CASCADE;

ALTER TABLE INPATIENT
ADD FOREIGN KEY(EID_DOC) REFERENCES DOCTOR(EID_DOC) ON DELETE CASCADE;

ALTER TABLE INPATIENT
ADD FOREIGN KEY(EID_NUR) REFERENCES NURSE(EID_NUR) ON DELETE SET NULL;

ALTER TABLE EXAMINATION
ADD FOREIGN KEY(EID_DOC) REFERENCES DOCTOR(EID_DOC) ON DELETE CASCADE;

ALTER TABLE EXAMINATION
ADD FOREIGN KEY(PID_OUT) REFERENCES OUTPATIENT(PID_OUT) ON DELETE CASCADE;

ALTER TABLE TREATMENT
ADD FOREIGN KEY(EID_DOC) REFERENCES DOCTOR(EID_DOC) ON DELETE CASCADE;

ALTER TABLE TREATMENT
ADD FOREIGN KEY(PID_IN) REFERENCES INPATIENT(PID_IN) ON DELETE CASCADE;

ALTER TABLE USE_EXAM
ADD FOREIGN KEY(EID_DOC,PID_OUT,EXID) REFERENCES EXAMINATION(EID_DOC,PID_OUT,EX_ID) ON DELETE CASCADE;

ALTER TABLE USE_EXAM
ADD FOREIGN KEY(MID) REFERENCES MEDICATION(MID) ON DELETE SET NULL;

ALTER TABLE USE_TREAT
ADD FOREIGN KEY(EID_DOC,PID_IN,TRID) REFERENCES TREATMENT(EID_DOC,PID_IN,TRID) ON DELETE CASCADE;

ALTER TABLE USE_TREAT
ADD FOREIGN KEY(MID) REFERENCES MEDICATION(MID) ON DELETE SET NULL;

