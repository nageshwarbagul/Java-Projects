# 🤖 Client-Server Chatbot

## 📌 Project Description

**Client-Server Chatbot** is a Java-based console chat application that demonstrates communication between a **Client** and a **Server** using **Socket Programming**.

The client connects to the server through a specific port and allows the user to send messages. The server receives the client's messages and sends a response back to the client.

The project also records the conversation into separate text files for both the client and server.

This project demonstrates important concepts of **Java Networking, Socket Programming, Input/Output Streams, File Handling, and Client-Server Architecture**.

---

## 🎯 Features

* Client-Server communication using Java Sockets
* Real-time message exchange through the console
* Server listens on port `3100`
* Client connects to `localhost:3100`
* Client can send messages to the server
* Server can respond to client messages
* Client-side conversation is stored in `Client_Chat.txt`
* Server-side conversation is stored in `Server_Chat.txt`
* Simple console-based interface
* Demonstrates TCP communication

---

## 🏗️ Project Structure

The project contains two Java classes:

```text id="8f7x3a"
CLIENT_SERVER_CHATBOT
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

* Creating a connection with the server
* Sending messages to the server
* Receiving responses from the server
* Displaying server messages
* Saving received messages into `Client_Chat.txt`

The client connects to:

```java id="7ik8b5"
localhost
```

on port:

```text id="m3ql0j"
3100
```

The connection is established using:

```java id="xj5jhm"
Socket sobj = new Socket("localhost", 3100);
```

---

## 🖥️ Server

### `Server_Chat.java`

The server program is responsible for:

* Starting the server
* Creating a `ServerSocket`
* Listening for client connections
* Accepting a client request
* Receiving messages from the client
* Sending responses to the client
* Saving received messages into `Server_Chat.txt`

The server listens on port:

```text id="0m3k4x"
3100
```

The server creates the listening socket using:

```java id="8t4p3v"
ServerSocket ssobj = new ServerSocket(3100);
```

It waits for a client using:

```java id="qgub9j"
Socket sobj = ssobj.accept();
```

---

## 🔄 How the Application Works

The communication follows this sequence:

```text id="h2o8p3"
             SERVER
                |
                |  Waiting on Port 3100
                |
                v
          ServerSocket
                |
                |
             CLIENT
                |
                | Connects to localhost:3100
                v
              Socket
                |
                |
        +-------+-------+
        |               |
        v               v
   Send Message    Receive Response
        |               |
        v               v
      Server <------ Client
```

---

## 🔌 Client-Server Communication

The application uses **TCP socket communication**.

### Step 1: Start the Server

The server creates a `ServerSocket` on port `3100`.

```text id="0o5ykh"
Server
  |
  v
ServerSocket(3100)
  |
  v
Waiting for client...
```

### Step 2: Start the Client

The client creates a socket and attempts to connect to the server.

```text id="k4m1t0"
Client
  |
  v
Socket("localhost", 3100)
  |
  v
Server
```

### Step 3: Connection Established

The server accepts the client request.

```text id="6k0k0k"
Client <========== TCP Connection ==========> Server
```

### Step 4: Message Exchange

The client enters a message:

```text id="8k8wup"
Enter message for server:
Hello
```

The client sends:

```text id="j6i4am"
Hello
```

The server receives:

```text id="o5o9be"
client says:Hello
```

The server then enters a response:

```text id="j3v3ks"
Enter message for client:
Hello Client
```

The client receives:

```text id="l1l5ba"
server says:Hello Client
```

---

## 📡 Java Networking Classes Used

### `Socket`

Used by the client to establish a connection with the server.

```java id="l9v3is"
Socket sobj = new Socket("localhost", 3100);
```

### `ServerSocket`

Used by the server to listen for incoming client connections.

```java id="8iv7eo"
ServerSocket ssobj = new ServerSocket(3100);
```

### `PrintStream`

Used to send messages through the socket output stream.

```java id="b8j6b8"
PrintStream pobj = new PrintStream(sobj.getOutputStream());
```

### `BufferedReader`

Used to read messages from:

* Socket input stream
* Keyboard input

---

## 📁 Chat Logging

The project maintains separate files for conversation logging.

### Client Log

```text id="x0g2u4"
Client_Chat.txt
```

The client stores messages received from the server.

Example:

```text id="n6h6tu"
server says:Hello Client
server says:How are you?
server says:I am fine.
```

### Server Log

```text id="8thqap"
Server_Chat.txt
```

The server stores messages received from the client.

Example:

```text id="tw0h5h"
client says:Hello
client says:How are you?
client says:I need some information.
```

---

## 🛑 Ending the Chat

The client uses:

```text id="u9v6ps"
end
```

as the termination keyword.

When the client enters `end`, the client stops sending messages and closes the socket and file.

---

## 🧠 Concepts Demonstrated

This project demonstrates:

* Java Networking
* Socket Programming
* Client-Server Architecture
* TCP Communication
* `Socket`
* `ServerSocket`
* Input Streams
* Output Streams
* `BufferedReader`
* `PrintStream`
* File Handling
* `FileWriter`
* Exception Handling
* Console Input
* String Processing

---

## ▶️ How to Run

### Step 1: Create the Package

The source files belong to:

```text id="gq2jfz"
CLIENT_SERVER_CHATBOT
```

Make sure both Java files are inside the appropriate package directory.

### Step 2: Compile

From the directory containing the package:

```bash id="r5pk8w"
javac CLIENT_SERVER_CHATBOT/*.java
```

### Step 3: Start the Server First

Run:

```bash id="0q0kns"
java CLIENT_SERVER_CHATBOT.Server_Chat
```

The server will display:

```text id="4j9x8p"
server application is running...
server is waiting is at port at 3100
```

### Step 4: Start the Client

Open another terminal and run:

```bash id="1n1v1f"
java CLIENT_SERVER_CHATBOT.Client_Chat
```

The client will connect to the server.

---

## 🖥️ Sample Output

### Server

```text id="6qv2hv"
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

```text id="2j7z0q"
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

---

## 🔐 Communication Model

The project follows a simple **Client-Server Model**:

```text id="2z7y9d"
       CLIENT                         SERVER
         |                              |
         |------ Connection Request --->|
         |                              |
         |<----- Connection Accepted ---|
         |                              |
         |-------- Message ------------>|
         |                              |
         |<-------- Response -----------|
         |                              |
         |-------- Message ------------>|
         |                              |
         |<-------- Response -----------|
         |                              |
         |---------- Close ------------>|
```

---

## ⚠️ Current Limitations

The current version is a simple console-based chatbot.

Limitations include:

* Supports one client connection at a time
* No graphical user interface
* No database
* Messages are exchanged sequentially
* Server responses are manually entered
* No authentication
* No encryption
* Client and server must run on the same machine when using `localhost`

---

## 🚀 Future Enhancements

The project can be improved by adding:

* Multiple client support
* GUI-based chat application
* Automated chatbot responses
* Database storage
* User authentication
* Message timestamps
* Online/offline status
* Chat history
* Encryption
* Multi-threading
* Network-based communication between different computers
* AI-powered chatbot responses

---

## 🎓 Project Objective

The main objective of the **Client-Server Chatbot** project is to understand how two Java applications can communicate with each other over a network.

The project provides practical experience with **Socket Programming, TCP communication, Client-Server Architecture, Input/Output Streams, and File Handling**.

---

## 👨‍💻 Author

**Shubham Suresh Isai**

**Project:** Client-Server Chatbot
**Technology:** Java
**Type:** Console-Based Networking Application
**Purpose:** Educational and Learning Project
