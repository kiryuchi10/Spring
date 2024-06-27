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
