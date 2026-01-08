# Drift - SOAP API Backend with Thymeleaf Frontend

A modern Spring Boot application that provides SOAP web services for user management with a beautiful Thymeleaf web interface.

## 🚀 Features

- **SOAP Web Services** - RESTful-like SOAP endpoints for user management
- **Web Services Framework** - Spring Web Services (Spring-WS) for SOAP support
- **Thymeleaf Frontend** - Modern, responsive web interface for managing users
- **CRUD Operations** - Create, Read, Update, Delete users
- **WSDL Support** - Auto-generated WSDL for SOAP services
- **MySQL Integration** - Ready for database persistence
- **Maven/Gradle Build** - Gradle-based build system

## 📋 Technology Stack

- **Framework**: Spring Boot 4.0.1
- **Language**: Java 21
- **SOAP**: Spring Web Services (spring-boot-starter-webservices)
- **Web**: Spring MVC with Thymeleaf
- **Database**: MySQL (configured in application.yaml)
- **Build Tool**: Gradle

## 📁 Project Structure

```
drift/
├── src/
│   ├── main/
│   │   ├── java/com/example/drift/
│   │   │   ├── DriftApplication.java          # Main Spring Boot application
│   │   │   ├── controller/
│   │   │   │   └── UserController.java        # Web controller for Thymeleaf views
│   │   │   └── soap/
│   │   │       ├── config/
│   │   │       │   └── SoapConfig.java        # SOAP configuration
│   │   │       ├── endpoint/
│   │   │       │   └── UserEndpoint.java      # SOAP endpoint definitions
│   │   │       ├── model/
│   │   │       │   └── User.java              # User entity
│   │   │       └── service/
│   │   │           └── UserService.java       # Business logic
│   │   └── resources/
│   │       ├── application.yaml               # Application configuration
│   │       ├── static/                        # Static assets
│   │       │   ├── css/
│   │       │   │   └── styles.css             # Global stylesheet (responsive design)
│   │       │   └── js/
│   │       │       └── main.js                # JavaScript utilities & validations
│   │       ├── templates/                     # Thymeleaf templates (HTML only)
│   │       │   ├── index.html                 # User list dashboard
│   │       │   ├── add-user.html              # Create user form
│   │       │   ├── edit-user.html             # Edit user form
│   │       │   └── view-user.html             # User details page
│   │       └── xsd/
│   │           └── users.xsd                  # SOAP schema definition
│   └── test/
│       └── java/com/example/drift/
│           └── DriftApplicationTests.java
├── build.gradle                               # Gradle configuration
├── README.md                                  # This file
└── settings.gradle
```

## 🛠️ Setup & Installation

### Prerequisites

- Java 21 or higher
- MySQL Server running
- Gradle (or use gradlew)

### 1. Clone & Navigate

```bash
cd drift
```

### 2. Configure Database

Edit `src/main/resources/application.yaml`:

```yaml
spring:
  application:
    name: drift
  datasource:
    url: jdbc:mysql://localhost:3306/javadb
    username: root
    password: your_password
    driver-class-name: com.mysql.cj.jdbc.Driver
```

Create the database:

```sql
CREATE DATABASE javadb;
```

### 3. Build the Project

```bash
./gradlew build
```

## 🚀 Running the Application

```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

## 📱 Using the Application

### Web Interface (Thymeleaf)

Access the web dashboard at: **http://localhost:8080**

**Features:**
- ✅ View all users in a table format
- ✅ Click on a user name to view detailed information
- ✅ Add new users via form
- ✅ Edit existing user information
- ✅ Delete users with confirmation

**Pages:**
- `/` - Dashboard with user list
- `/add-user` - Create new user
- `/user/{id}` - View user details
- `/edit-user/{id}` - Edit user form

### SOAP Web Services

Access the WSDL at: **http://localhost:8080/ws/users.wsdl**

**SOAP Endpoint:** `http://localhost:8080/ws`

**Available Operations:**

#### 1. GetUser
Retrieve a specific user by ID

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" 
               xmlns:tns="http://example.com/drift/users">
  <soap:Body>
    <tns:GetUserRequest>
      <tns:id>1</tns:id>
    </tns:GetUserRequest>
  </soap:Body>
</soap:Envelope>
```

#### 2. GetAllUsers
Retrieve all users

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" 
               xmlns:tns="http://example.com/drift/users">
  <soap:Body>
    <tns:GetAllUsersRequest/>
  </soap:Body>
</soap:Envelope>
```

#### 3. CreateUser
Create a new user

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" 
               xmlns:tns="http://example.com/drift/users">
  <soap:Body>
    <tns:CreateUserRequest>
      <tns:name>John Doe</tns:name>
      <tns:email>john@example.com</tns:email>
      <tns:phone>123-456-7890</tns:phone>
    </tns:CreateUserRequest>
  </soap:Body>
</soap:Envelope>
```

#### 4. UpdateUser
Update an existing user

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" 
               xmlns:tns="http://example.com/drift/users">
  <soap:Body>
    <tns:UpdateUserRequest>
      <tns:id>1</tns:id>
      <tns:name>Jane Doe</tns:name>
      <tns:email>jane@example.com</tns:email>
      <tns:phone>098-765-4321</tns:phone>
    </tns:UpdateUserRequest>
  </soap:Body>
</soap:Envelope>
```

#### 5. DeleteUser
Delete a user

```xml
<soap:Envelope xmlns:soap="http://schemas.xmlsoap.org/soap/envelope/" 
               xmlns:tns="http://example.com/drift/users">
  <soap:Body>
    <tns:DeleteUserRequest>
      <tns:id>1</tns:id>
    </tns:DeleteUserRequest>
  </soap:Body>
</soap:Envelope>
```

## 🧪 Testing SOAP Services

### Using SoapUI

1. Download [SoapUI](https://www.soapui.org/downloads/soapui/)
2. Create a new project and import WSDL from `http://localhost:8080/ws/users.wsdl`
3. Test each operation

### Using Postman

1. Create a new request
2. Set method to `POST`
3. URL: `http://localhost:8080/ws`
4. Headers: `Content-Type: text/xml`
5. Body: Use the SOAP XML examples above

### Using curl

```bash
curl -X POST http://localhost:8080/ws \
  -H "Content-Type: text/xml" \
  -d @request.xml
```

## 📦 Dependencies

Key dependencies in `build.gradle`:

```gradle
implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
implementation 'org.springframework.boot:spring-boot-starter-thymeleaf'
implementation 'org.springframework.boot:spring-boot-starter-webservices'
runtimeOnly 'com.mysql:mysql-connector-j'
compileOnly 'org.projectlombok:lombok'
```

## 🗂️ How It Works

1. **Web Request** → `UserController` processes HTTP requests and renders Thymeleaf templates
2. **SOAP Request** → `UserEndpoint` handles SOAP messages from web services clients
3. **Business Logic** → `UserService` manages user data operations
4. **Data** → Currently uses in-memory storage; can be connected to MySQL database

## 🔄 Architecture

```
Web Browser             SOAP Client
    ↓                       ↓
    └─→ UserController      └─→ UserEndpoint
         (HTTP/Web)              (SOAP/WS)
              ↓                       ↓
              └─────────┬────────────┘
                        ↓
                  UserService
                        ↓
                    User Model
```

## 🎨 UI Architecture

### File Organization
- **HTML Templates** (`src/main/resources/templates/`) - Clean, semantic markup using Thymeleaf
- **CSS Stylesheet** (`src/main/resources/static/css/styles.css`) - Global responsive styles (600+ lines)
- **JavaScript** (`src/main/resources/static/js/main.js`) - Utilities and form validation

### Frontend Features
- 📊 Modern gradient design with purple theme
- 📱 Responsive layout for mobile and desktop
- ⚡ Smooth animations and transitions (fade-in messages, hover effects)
- 🎯 Intuitive user management interface
- 💬 Auto-closing toast notifications (5-second timeout)
- ✅ Client-side form validation
- 🔐 Confirmation dialogs for destructive actions

## 📝 Sample Data

The application comes with sample data:

| ID | Name | Email | Phone |
|---|---|---|---|
| 1 | John Doe | john@example.com | 123-456-7890 |
| 2 | Jane Smith | jane@example.com | 098-765-4321 |

## 🔧 Configuration

### Application Settings
Edit `src/main/resources/application.yaml`:

```yaml
spring:
  application:
    name: drift
  datasource:
    url: jdbc:mysql://localhost:3306/javadb
    username: root
    password: aksql
    driver-class-name: com.mysql.cj.jdbc.Driver
```

### Static Resources
- CSS files served from: `/css/` (maps to `src/main/resources/static/css/`)
- JS files served from: `/js/` (maps to `src/main/resources/static/js/`)
- Templates use Thymeleaf syntax: `th:href="@{/css/styles.css}"` and `th:src="@{/js/main.js}"`

## 🐛 Troubleshooting

### Port already in use
Change port in `application.yaml`:
```yaml
server:
  port: 8081
```

### Database connection fails
- Ensure MySQL is running
- Check database credentials
- Verify JDBC driver is installed

### WSDL not loading
- Ensure Spring-WS is properly configured
- Check `SoapConfig.java` for correct namespace and schema paths

### CSS/JS not loading
- Verify files exist in `src/main/resources/static/`
- Check browser console for 404 errors
- Restart application after adding static files
- Clear browser cache if styles seem outdated

### Form validation not working
- Ensure `main.js` is loaded (check browser console)
- Verify JavaScript is enabled in browser
- Check for errors in browser Developer Tools console

## 📚 Resources

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Web Services](https://spring.io/projects/spring-ws)
- [Thymeleaf Documentation](https://www.thymeleaf.org/)
- [SOAP Web Services Tutorial](https://docs.spring.io/spring-ws/docs/current/reference/html/)

## 👤 Author

Created as a demonstration of Spring Boot SOAP services with Thymeleaf frontend.

## 📄 License

This project is open source and available for educational purposes.

---

**Happy coding! 🎉**
