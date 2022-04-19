## Simple Bank System

This application handles some of the basics operations of a bank, such as customer's deposit and withdraw, money transferences, and fixed income calculations (Interest Rate or Bonds calculations). Still in development, feel free to contribute!


### Creating Project Modules: 
Core  

0. User login  
1. Create accounts  
2. Edit accounts  
3. Accounts block(delete)  

Payment service  

4. Transfer payments from one user to another  
5. Change of funds  

Analytics service  

6. How many payments per day, week, month, year  
7. How many users in the system (blocked, active)  
8. Metrics  

Loan service  

9. A person requests a loan amount  
10. Loan approval (scoring)  
11. Notification of the result (email)  



### Connect to h2 console  
Go to http://localhost:8080/api/h2  
JDBC URL: jdbc:h2:mem:bankdb  
