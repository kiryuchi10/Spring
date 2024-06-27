Spring MVC Web Application Procedures
Spring MVC (Model-View-Controller) is a framework for building web applications. Here's a detailed explanation of how it works, using key terms like DispatcherServlet, URI, Bean ID, LVN, Command Class, and annotations like @Controller, @Repository, @Service, and @Autowired.

Core Components and Process Flow:
web.xml:

This is the deployment descriptor for a Java web application. It defines the DispatcherServlet, which is the front controller in the Spring MVC architecture. It intercepts all incoming requests and routes them to appropriate handlers.
xml
코드 복사

![image](https://github.com/kiryuchi10/spring/assets/141597057/17270e7c-2c73-4587-aa5c-d3f33e922b3c)

<web-app>
    <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
</web-app>
DispatcherServlet:
![image](https://github.com/kiryuchi10/spring/assets/141597057/630ff2f2-90cf-48ae-91ee-fd937072f9cd)


Acts as the front controller, handling all HTTP requests and responses. It looks up handler mappings to determine which controller method to invoke based on the request URI.
Configured in web.xml, it initializes the Spring application context defined in applicationContext.xml or the corresponding Spring configuration.
applicationContext.xml (Spring Configuration):

Defines beans and their dependencies. Beans are instances of objects managed by Spring IoC (Inversion of Control) container.
This file configures services, repositories, and controllers, injecting dependencies as needed.
xml
코드 복사
<beans ...>
    <!-- Bean definitions -->
    <bean id="myService" class="com.example.MyService"/>
    <bean id="myRepository" class="com.example.MyRepository"/>
</beans>
DispatcherServlet Initialization:

On startup, DispatcherServlet reads applicationContext.xml and initializes the application context with defined beans.
URI Mapping and Request Handling:

When a request is received, DispatcherServlet uses the URI to determine the appropriate controller to handle the request.
Controllers:
![image](https://github.com/kiryuchi10/spring/assets/141597057/83623465-deaf-454c-b015-23775cd9e22a)

Annotated with @Controller, these handle web requests and return ModelAndView objects.
Methods in controllers map to specific URIs using annotations like @RequestMapping.
java
코드 복사
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public String listUsers(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "userList"; // Logical View Name (LVN)
    }
}
Services and Repositories:

@Service: Indicates a service layer component, typically containing business logic.
@Repository: Indicates a data access layer component, handling database operations.
Both annotations help Spring identify and manage these beans in the IoC container.
java
코드 복사
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }
}

@Repository
public class UserRepository {
    public List<User> findAll() {
        // Database access code
    }
}
Dependency Injection (DI) and Inversion of Control (IoC):

IoC: Spring manages the lifecycle and dependencies of objects (beans), allowing the container to control the creation and injection of dependencies.
DI: Using @Autowired, dependencies are automatically injected by Spring into beans. This promotes loose coupling and easier testing.
Command Class:

A POJO (Plain Old Java Object) used to capture form data from the client. It is used as a parameter in controller methods.
java
코드 복사
public class UserForm {
    private String name;
    private String email;
    // getters and setters
}
Logical View Name (LVN):

The string returned by controller methods that maps to a specific view template (like JSP, Thymeleaf, etc.).
View resolvers in Spring MVC convert LVNs to actual view paths.
Example Flow:
Request Initialization:

A client sends an HTTP request to /user/list.
DispatcherServlet Interception:

The request is intercepted by DispatcherServlet, configured in web.xml.
Handler Mapping:

DispatcherServlet consults handler mappings to find the appropriate controller method for /user/list.
Controller Method Invocation:

UserController.listUsers is invoked. This method uses UserService to fetch user data.
Service Layer:

UserService fetches data from UserRepository.
Model and View:

The data is added to the Model object, and the method returns the LVN userList.
View Resolution:

DispatcherServlet uses the view resolver to convert userList to an actual view path, e.g., WEB-INF/views/userList.jsp.
Response Rendering:

The view is rendered and returned as an HTTP response to the client.
Maven (pom.xml):
Manages project dependencies, build configurations, and plugins.
xml
![image](https://github.com/kiryuchi10/spring/assets/141597057/0d31556b-3a9c-46b9-bcba-847cc52cd5dc)

코드 복사
<project ...>
    <dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.8</version>
        </dependency>
        <!-- Other dependencies -->
    </dependencies>
</project>
Summary:
DispatcherServlet: Front controller that handles requests and forwards them to appropriate handlers.
URI: Path used to map requests to controller methods.
Bean ID: Identifier for beans managed by the Spring IoC container.
LVN: Logical View Name that maps to view templates.
Command Class: Object to capture form data in controllers.
Annotations:
@Controller: Marks a class as a Spring MVC controller.
@Service: Marks a class as a service layer component.
@Repository: Marks a class as a data access component.
@Autowired: Injects dependencies automatically.
IoC and DI: Core concepts where Spring manages the lifecycle and dependencies of beans, promoting loose coupling and easier testing.


Concepts in Spring MVC Web Application
1. DispatcherServlet
Role: Acts as the front controller in the Spring MVC architecture. It intercepts all incoming requests and routes them to appropriate handlers (controllers).
2. URI Mapping
Role: Determines which controller and method will handle a specific request based on the URI.
3. Beans and Dependency Injection
Bean: An object that is managed by the Spring IoC (Inversion of Control) container.
Dependency Injection (DI): A design pattern where the dependencies (services, repositories, etc.) are injected into a class rather than the class creating the dependencies itself.
Autowired: A Spring annotation used to automatically inject dependencies.
4. Command Class
Role: A POJO (Plain Old Java Object) used to capture form data from the client. It is used as a parameter in controller methods to bind form data automatically.
5. Business Logic (Service Layer)
Role: Contains business logic. Annotated with @Service to indicate a service layer component.
6. Persistence Logic (DAO Layer)
Role: Handles database operations. Annotated with @Repository to indicate a data access layer component.
7. Logical View Name (LVN)
Role: The string returned by controller methods that maps to a specific view template (like JSP, Thymeleaf, etc.).
Flowchart of Spring MVC Web Application Procedures
mermaid
코드 복사
graph LR
A[Client] --> B[DispatcherServlet]
B --> C[Handler Mapping]
C --> D[Controller]
D --> E[Service Layer (Business Logic)]
E --> F[Repository Layer (Persistence Logic)]
F --> E
E --> D
D --> G[Model and View]
G --> B
B --> H[View Resolver]
H --> I[View (e.g., JSP, Thymeleaf)]
I --> A
Detailed Explanation of the Procedures
Request Initialization:

A client sends an HTTP request to the server.
DispatcherServlet Interception:

The request is intercepted by the DispatcherServlet, configured in web.xml.
Handler Mapping:

DispatcherServlet consults handler mappings to find the appropriate controller method for the given URI.
Controller Method Invocation:

The controller method is invoked. It uses the service layer to perform business logic operations.
Service Layer:

The service layer, annotated with @Service, contains business logic. It interacts with the repository layer to perform CRUD operations.
Repository (DAO) Layer:

The repository layer, annotated with @Repository, handles database operations.
Model and View:

Data is added to the Model object, and the controller method returns the Logical View Name (LVN).
View Resolution:

DispatcherServlet uses the view resolver to convert the LVN to an actual view path.
Response Rendering:

The view is rendered and returned as an HTTP response to the client.
Dependency Injection (DI) and Autowiring
Dependency Injection: In Spring, dependencies are injected rather than being created by the class itself. This is achieved through DI, where the Spring IoC container manages the lifecycle and injection of beans.
Autowiring: The @Autowired annotation is used to automatically inject dependencies by type. It simplifies the process of manual dependency injection.
java
코드 복사
@Autowired
private UserService userService;
super() vs. Autowiring: super() is used in a class constructor to call a constructor in the superclass. Autowiring, on the other hand, is used for injecting dependencies into a class. They serve different purposes; super() deals with inheritance, while autowiring deals with dependency management.
Persistence Logic
Persistence Logic: Refers to the operations related to saving, updating, deleting, and retrieving data from the database. This logic resides in the DAO (Repository) layer.
Command Class
Role: Command classes capture and bind form data from the client. They are used in controller methods to facilitate data binding and validation.
java
코드 복사
public class UserForm {
    private String name;
    private String email;
    // getters and setters
}
Usage: Command classes are used to store form data temporarily before processing it in the controller methods. They help in separating the view data from the controller logic.
Key Components in Configuration
web.xml: Defines the DispatcherServlet and its mapping.
applicationContext.xml: Defines beans and their dependencies.
Spring MVC Configuration: Specifies how to resolve views and handle other MVC-related configurations.
Summary
The process flow in a Spring MVC web application involves the DispatcherServlet intercepting requests, routing them to the appropriate controllers, which use the service layer to process business logic, and the repository layer to handle persistence logic. Dependency injection and autowiring facilitate the management of dependencies, promoting loose coupling and easier testing. The command class is used to capture and bind form data, separating view data from controller logic.
