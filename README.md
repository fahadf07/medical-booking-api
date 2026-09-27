# Secure Medical Appointment Scheduling REST API

An enterprise-grade, high-performance web API built using Spring Boot to automate patient scheduling architectures, streamline calendar queues, and expose clean RESTful schemas.

## 🛠️ System Endpoints
* `POST /api/appointments` - Ingests JSON scheduling payloads, assigns a secure UUID, and registers confirmation events.
* `GET /api/appointments` - Returns a real-time list of all active calendar bookings.
* `GET /api/appointments/{id}` - Executes lookups to extract metadata details for a specific unique identifier.

## 💻 Tech Stack
* **Framework:** Spring Boot 4.x / Spring Web
* **Language:** Java 27 / OpenJDK
* **Build Architecture:** Maven
* **Core Concepts:** Dependency Injection, Web MVC Routing, Multi-Threaded Concurrent Collections
