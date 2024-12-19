Signup
User provides:
email: user@example.com
Other details like name, phone number, etc.
A password (ABC123) is randomly generated and saved to the database.


Log in 
User provides:
email: user@example.com
password: ABC123
The application:
Retrieves the PersonEntity for user@example.com.
Compares the provided password (ABC123) with the stored password.
If they match, login is successful.

Summary
The user's email and generated password match because:
During signup, the password is generated and stored in the database along with the email.
During login, the email is used to fetch the record, and the password is compared with the stored one.
