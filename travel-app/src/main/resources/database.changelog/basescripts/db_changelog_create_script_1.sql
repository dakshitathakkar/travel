--liquibase formatted sql

-- changeset dakshita:1
-- preconditions onFail:MARK_RAN onError:HALT
-- precondition-sql-check expectedResult:0 SELECT count(*) FROM pg_type where typname='month';
CREATE TYPE month AS ENUM('JANUARY','FEBRUARY','MARCH','APRIL','MAY','JUNE','JULY','AUGUST','SEPTEMBER','OCTOBER','NOVEMBER','DECEMBER');

-- changeset dakshita:2
-- preconditions onFail:MARK_RAN onError:HALT
-- precondition-sql-check expectedResult:0 SELECT count(*) FROM INFORMATION_SCHEMA.TABLES WHERE TABLE_NAME = 'top_travel_destinations';
CREATE TABLE top_travel_destination(
        destination_id serial PRIMARY KEY,
        month month,
        country varchar(100),
        city varchar(100),
        state varchar(100),
        description text);