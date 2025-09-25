-- This script sets up the initial database schema and data for the student database.
-- Database: StudentDB
-- Author: Priyanshu Kr. Pandey
-- Date: 2025-09-25

CREATE DATABASE StudentDB;

USE StudentDB;

CREATE TABLE Students (
    UserID INT PRIMARY KEY,
    Name VARCHAR(50),
    Percentage FLOAT,
    JEEPercentile FLOAT,
    AdmissionYear INT
);

INSERT INTO Students (UserID, Name, Percentage, JEEPercentile, AdmissionYear)
VALUES 
(1, 'Priyanshu', 92.5, 98.2, 2023),
(2, 'Puneet', 88.3, 95.7, 2022),
(3, 'Vivek', 90.0, 97.5, 2023);

SELECT * FROM Students;