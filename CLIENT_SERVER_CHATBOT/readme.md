# 🤖 Client-Server Chatbot

## 📌 Project Description

**Client-Server Chatbot** is a Java-based console chat application that demonstrates communication between a **client** and a **server** using socket programming.

The client connects to the server through a specific port and allows the user to send messages. The server receives messages from the client and sends responses back.

The application also stores received messages in separate text files for the client and server.

This project was developed as a personal learning project to understand Java networking, socket programming, input/output streams, file handling, and client-server architecture.

> **Note:** This is a basic console-based chat application. Responses are entered manually by the server; automated AI chatbot responses are not implemented.

---

## 🎯 Features

- Client-server communication using Java sockets.
- Console-based message exchange.
- TCP communication through port `3100`.
- Client connection using `localhost:3100`.
- Sending messages from the client to the server.
- Sending responses from the server to the client.
- Saving received messages in separate text files.
- Simple console interface for communication.
- Client-side exit command using `end`.

---

## 🏗️ Project Structure

The project contains two Java classes and two text files for message logging.

```text
CLIENT_SERVER_CHATBOT/
│
├── Client_Chat.java
├── Server_Chat.java
├── Client_Chat.txt
└── Server_Chat.txt
```

---

## 💻 Client

### `Client_Chat.java`

The client program is responsible for:

- Establishing a connection with the server.
- Sending messages to the server.
- Receiving responses from the server.
- Displaying received messages in the console.
- Saving received messages in `Client_Chat.txt`.

The client connects to the server using the hostname `localhost` and port `3100`.

Example socket creation:

```java
Socket sobj = new Socket("localhost", 3100);
```

---

## 🖥️ Server

### `Server_Chat.java`

The server program is responsible for:

- Starting the server application.
- Creating a `ServerSocket`.
- Listening for incoming client connections.
- Accepting a client connection.
- Receiving messages from the client.
- Sending responses to the client.
- Saving received messages in `Server_Chat.txt`.

The server listens on port `3100`.

Example server socket creation:

```java
ServerSocket ssobj = new ServerSocket(3100);
```

The server accepts a client connection using:

```java
Socket sobj = ssobj.accept();
```

---

## 🔄 How the Application Works

The application follows a basic client-server communication model:

```text
          SERVER
             |
             v
    ServerSocket (3100)
             |
      Waits for client
             |
             v
     Accepts connection
             |
             v
      TCP Connection
             ^
             |
           CLIENT
             |
             v
     Connects to server
             |
             v
      Sends a message
             |
             v
           SERVER
             |
             v
      Sends a response
             |
             v
           CLIENT
```

The client and server exchange messages through a TCP socket connection. Each side saves the messages it receives in its respective text file.

---

## 🔌 Client-Server Communication

The application uses **TCP socket communication**.

### Step 1: Start the Server

The server creates a `ServerSocket` on port `3100` and waits for an incoming client connection.

```java
ServerSocket ssobj = new ServerSocket(3100);
```

### Step 2: Start the Client

The client creates a socket to connect to the server.

```java
Socket sobj = new Socket("localhost", 3100);
```

### Step 3: Establish the Connection

The server accepts the incoming connection, establishing a TCP connection between the client and server.

### Step 4: Exchange Messages

The client enters a message:

```text
Enter message for server:
Hello
```

The server receives the message:

```text
client says:Hello
```

The server can then enter a response:

```text
Enter message for client:
Hello Client
```

The client receives the response:

```text
server says:Hello Client
```

The exact console prompts may vary depending on the current Java source code.

---

## 📡 Java Networking Classes Used

### `Socket`

Used by the client to establish a connection with the server.

```java
Socket sobj = new Socket("localhost", 3100);
```

### `ServerSocket`

Used by the server to listen for incoming client connections.

```java
ServerSocket ssobj = new ServerSocket(3100);
```

### `PrintStream`

Used to send data through an output stream.

```java
PrintStream pobj = new PrintStream(sobj.getOutputStream());
```

### `BufferedReader`

Used to read text from input streams, such as the socket input stream or keyboard input.

---

## 📁 Chat Logging

The application maintains separate text files for logging received messages.

### Client Log

**File:** `Client_Chat.txt`

This file stores messages received by the client from the server.

Example:

```text
server says:Hello Client
server says:How are you?
server says:I am fine.
```

### Server Log

**File:** `Server_Chat.txt`

This file stores messages received by the server from the client.

Example:

```text
client says:Hello
client says:How are you?
client says:I need some information.
```

The examples above illustrate the intended log format. Actual entries depend on the messages exchanged during execution.

---

## 🛑 Ending the Chat

The client uses the following keyword to terminate its chat loop:

```text
end
```

When the client enters `end`, the client exits and closes its connection.

The exact server behavior after the client disconnects depends on the server implementation.

---

## 🧠 Concepts Demonstrated

This project provides practical experience with:

- Java networking.
- Socket programming.
- Client-server architecture.
- TCP communication.
- `Socket` and `ServerSocket`.
- Input and output streams.
- `BufferedReader` and `PrintStream`.
- File handling.
- Console input.
- String processing.
- Exception handling, where implemented in the source code.

---

## ▶️ How to Run

### Prerequisites

- Java Development Kit (JDK) installed.
- Java compiler (`javac`) and Java runtime (`java`) available in the terminal.
- Visual Studio Code or another Java development environment.

Check your Java installation:

```bash
java -version
javac -version
```

### Step 1: Check the Package

The Java files are intended to use the following package:

```java
package CLIENT_SERVER_CHATBOT;
```

Ensure both Java files declare this package and are stored in the matching directory structure.

### Step 2: Compile the Java Files

Run the following command from the directory containing the `CLIENT_SERVER_CHATBOT` folder:

```bash
javac CLIENT_SERVER_CHATBOT/*.java
```

### Step 3: Start the Server

Open a terminal and run:

```bash
java CLIENT_SERVER_CHATBOT.Server_Chat
```

Keep the server running.

Expected output from the provided example:

```text
server application is running...
server is waiting is at port at 3100
```

### Step 4: Start the Client

Open a second terminal in the same working directory and run:

```bash
java CLIENT_SERVER_CHATBOT.Client_Chat
```

The client should connect to the server.

Expected output from the provided example:

```text
client application is running...
connection is successful with server
..........................................
................... chat client...........
..........................................
enter massage for server:
```

The sample output preserves the original console wording. If you later correct spelling in the Java source, update these examples to match.

---

## 🖥️ Sample Output

### Server

```text
server application is running...
server is waiting is at port at 3100
client request gets accepted successfully
..........................................
................... chat server...........
..........................................
client says:Hello
enter massaage for client:
```

### Client

```text
client application is running...
connection is successful with server
..........................................
................... chat client...........
..........................................
enter massage for server:
Hello
server says:Hello Client
enter massage for server:
```

These examples represent the expected interaction. The exact prompts and messages depend on the current program output.

---

## 🔐 Communication Model

The project follows a simple **client-server model**.

```text
       CLIENT                       SERVER
          |                            |
          |------ Connection Request ->|
          |                            |
          |<----- Connection Accepted -|
          |                            |
          |-------- Message ---------->|
          |                            |
          |<-------- Response ---------|
          |                            |
          |-------- Message ---------->|
          |                            |
          |<-------- Response ---------|
          |                            |
          |------ Connection Close --->|
```

The client initiates the connection, and the server accepts it. Messages and responses are exchanged through the established TCP connection.

---

## ⚠️ Current Limitations

The current version is a basic console-based chat application.

- The tested setup runs the client and server on the same laptop.
- The application does not include a graphical user interface.
- No database integration is documented in the current implementation.
- Server responses are entered manually.
- Authentication and encryption are not documented as implemented.
- Support for multiple simultaneous clients has not been verified.

---

## 🚀 Future Enhancements

Possible improvements for future versions include:

- Support for multiple clients.
- A graphical user interface (GUI).
- Automated chatbot responses.
- Database integration for message storage.
- User authentication.
- Message timestamps.
- Online/offline status.
- Improved chat history management.
- Secure communication through encryption.
- Multithreading for handling concurrent clients.
- Communication between computers on a network.
- Integration with an AI-powered chatbot.

These are proposed enhancements and are not claimed as existing features.

---

## 🎓 Project Objective

The main objective of this project is to understand how two Java applications communicate using sockets and TCP.

It provides hands-on practice with networking fundamentals, client-server architecture, input/output streams, and file handling.

---

## 👨‍💻 Author

**Nageshwar Bharat Bagul**

- **Project:** Client-Server Chatbot
- **Technology:** Java
- **Type:** Console-Based Networking Application
- **Purpose:** Personal Learning Project

