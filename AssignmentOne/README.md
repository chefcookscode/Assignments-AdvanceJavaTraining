# 🎓 Student Management System (Java + MySQL)

This project demonstrates basic **CRUD operations** (Create, Read, Update, Delete) on a MySQL database using **Java JDBC**.  
It is a simple assignment for learning **Advanced Java Training** concepts.

---

## 📌 Features
- ✅ Create a database table to store student details  
- ✅ Fetch student details by `UserID`  
- ✅ Check **eligibility for branch change** (if Percentage > 80)  
- ✅ Add a new student record  
- ✅ Delete a student record  

---

## 🗂️ Database Schema

**Database:** `StudentDB`  
**Table:** `Students`

| Column        | Type        | Constraint      |
|---------------|------------|----------------|
| UserID        | INT        | PRIMARY KEY    |
| Name          | VARCHAR(50)|                |
| Percentage    | FLOAT      |                |
| JEEPercentile | FLOAT      |                |
| AdmissionYear | INT        |                |

---

## 📝 Sample Data

```sql
INSERT INTO Students (UserID, Name, Percentage, JEEPercentile, AdmissionYear)
VALUES 
(1, 'Priyanshu', 92.5, 98.2, 2023),
(2, 'Puneet', 88.3, 95.7, 2022),
(3, 'Vivek', 90.0, 97.5, 2023);
