# Expense Tracker 💰

## Introduction
A console-based Expense Tracker developed using Java to manage daily expenses. It supports expense management, category-based filtering, and monthly expense calculations. File handling is used to store expense records.

## Features
- Add, view, search, update, and delete expenses.
- Filter expenses by category and date.
- Sort expenses by amount.
- Calculate total and monthly expenses.
- Save and load expense records using file handling.

## Project Structure
```text
Expense_Tracker/
├── Main.java
├── Expense.java
├── ExpenseManager.java
├── Category.java
├── FileManager.java
├── expenses.txt
├── .gitignore
└── README.md
```

## Class Description

| Class | Description |
|---|---|
| `Main` | Handles the menu and user input. |
| `Expense` | Stores expense details. |
| `ExpenseManager` | Manages expense operations and calculations. |
| `Category` | Defines expense categories using an enum. |
| `FileManager` | Saves and loads expenses from a text file. |
