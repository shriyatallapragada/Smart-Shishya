# Smart Shishya - Integrated Student Management Tool

**Smart Shishya** is a Java Swing-based desktop application designed to streamline student productivity. It integrates a resource library, a task manager, and an automated scheduler into a single unified interface.

## 🚀 Features
* [cite_start]**Integrated Dashboard**: A centralized home screen showing upcoming reminders for the next 7 days [cite: 18-19, 24].
* [cite_start]**B.Tech Resource Library**: Direct access to JNTUH-specific course materials for I and II B.Tech semesters (Computer Science) via Google Drive integration[cite: 102, 172, 247, 325].
* [cite_start]**Smart To-Do List**: A task manager that tracks descriptions, deadlines, and priorities [cite: 492-496].
* [cite_start]**Automated Scheduler**: A calendar view that automatically syncs with the To-Do list to display exams, assignments, and holidays[cite: 433, 438, 445].

## 🛠️ Technical Integration
The project demonstrates core Java concepts including:
* [cite_start]**Object-Oriented Programming**: Clear package separation (`proj.lib`, `proj.main`, `proj.org`, `proj.todo`)[cite: 4, 92, 403, 480].
* [cite_start]**Event-Driven GUI**: Built using Java Swing and `JTabbedPane` for seamless navigation between modules [cite: 10, 33-37].
* [cite_start]**File I/O & Persistence**: Data is stored and retrieved from local `.txt` files using `BufferedReader` and `BufferedWriter`[cite: 5, 54, 413, 643].
* [cite_start]**Module Communication**: The To-Do module is integrated with the Scheduler instance, allowing real-time updates to the calendar when a new task is added [cite: 512, 593-594].

## 📂 Project Structure
- [cite_start]`src/proj/main/`: Main application entry point (`MenuApp.java`) [cite: 14-15].
- [cite_start]`src/proj/lib/`: Library module for course links (`Lib.java`)[cite: 96].
- [cite_start]`src/proj/org/`: Scheduler and Calendar logic (`SchedulePanel.java`)[cite: 407].
- [cite_start]`src/proj/todo/`: Task management logic (`TodoGUI_CheckboxFirst.java`)[cite: 507].
- [cite_start]`data/`: Backend storage for reminders and tasks [cite: 24, 437, 441, 447, 509-511].

## 👥 Contributors
* **Shriya Tallapragada**: Project Integration and Library Module.
* **Supraja Tatikonda**: To-Do List Module creation.
* **Jahnavi Yenumula**: Scheduler/Calendar Module.
