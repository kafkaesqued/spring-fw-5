
/*
Create a Node.js API with the following OpenAPI Specification requirements:

- Use OpenAPI Specification 3.0.0
- Develop a markdown editor API with endpoints for:
  - Creating new markdown documents
  - Retrieving markdown documents
  - Updating existing markdown documents

- Include comprehensive error handling
- Define schemas for markdown document input and output
- Implement basic authentication
- Support markdown syntax validation
*/
Creating an OpenAPI Specification (OAS) for a Node.js project involves defining your API’s endpoints, request/response schemas, authentication, and other details. Below are some sample prompts you can use to generate a detailed OAS specification.


---

1. Basic OpenAPI Template for a Node.js API

Prompt:

> Generate an OpenAPI 3.0 specification for a Node.js REST API that manages users and tasks. The API should support JSON requests and responses, use JWT authentication, and have two primary endpoints:

/users: CRUD operations for user management (Create, Read, Update, Delete).

/tasks: CRUD operations for task management, each task belonging to a user.


Include request/response schemas, authentication, status codes, and examples.




---

2. OAS with Express and JWT Authentication

Prompt:

> Create an OpenAPI 3.0 specification for an Express-based Node.js API that supports JWT authentication. The API should include:

A POST /auth/login endpoint to authenticate users and return a JWT token.

A GET /users/me endpoint that requires a valid JWT token to retrieve user details.

A POST /tasks endpoint for creating tasks, where each task has a title, description, status, and due date.

Use bearer token authentication and specify security requirements.





---

3. OAS with Query Parameters and Pagination

Prompt:

> Generate an OpenAPI 3.0 specification for a Node.js API that allows retrieving paginated user data. The API should have:

A GET /users endpoint that supports pagination (page and limit query parameters).

Sorting by name and createdAt.

Filtering users by status (active/inactive).

Response schema showing metadata like total records and current page.





---

4. OAS with WebSockets Support

Prompt:

> Create an OpenAPI 3.0 specification for a Node.js API that supports both RESTful operations and WebSocket communication. The API should include:

A POST /messages endpoint to send a message.

A WebSocket /ws/messages endpoint to receive real-time messages.

Request and response schemas for messages, including sender, receiver, timestamp, and message content.





---

5. OAS with Middleware for Validation & Rate Limiting

Prompt:

> Write an OpenAPI 3.0 specification for a Node.js API that includes middleware for request validation and rate limiting. The API should:

Use express-validator to validate incoming requests.

Use express-rate-limit to prevent abuse.

Provide structured error responses when validation or rate limits are exceeded.

Define a POST /register endpoint for user registration, requiring a valid email and strong password.





---

6. OAS for Microservices with Async API Support

Prompt:

> Generate an OpenAPI 3.0 specification for a Node.js microservices-based API that communicates via REST and RabbitMQ. The API should:

Provide a POST /orders endpoint to create a new order.

Publish an event to RabbitMQ when a new order is created.

Define the event schema for order creation, including order ID, user ID, total amount, and order status.

Include error handling for failed message delivery.





---

7. OAS with File Upload Support

Prompt:

> Create an OpenAPI 3.0 specification for a Node.js API that allows users to upload and retrieve files. The API should include:

A POST /upload endpoint supporting file uploads (multipart/form-data).

A GET /files/{fileId} endpoint to retrieve uploaded files by ID.

Define schemas for file metadata including filename, size, type, and uploadTimestamp.





---

8. OAS for GraphQL Integration

Prompt:

> Generate an OpenAPI 3.0 specification for a Node.js API that supports both REST and GraphQL. The API should:

Have a POST /graphql endpoint for handling GraphQL queries.

Provide a GET /users/{id} REST endpoint as an alternative to GraphQL.

Define schemas for GraphQL queries and mutations related to users and tasks.





---

Would you like a full OAS YAML/JSON output for any of these?

