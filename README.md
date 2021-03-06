# Sockets-and-Thread-Management

Objectives:
1. Understanding two communication protocols for distributed processing,
HyperText Transport Protocol - HTTP, and Sockets.
2. Exposure to multithreading.
3. Using an Integrated Development Environment (IDE)

Project Specification:
These will be individual projects. You may write the program in any language that is
supported under any Integrated Development Environment (IDE). Keep in mind that
more help may be available to you in some languages than in others. Furthermore,
available controls, objects, libraries etc. may make some of these tasks easier in one
language than in another. Finally, because of the lack of restrictions on IDEs, you will
have to have that IDE available to demo to the TA. For example, you might bring a
laptop to demo the program. Socket programming is so universal that you can probably
find major portions of this part of the program with searching on Google. Using code you
find on the Internet is fine, but be sure to document the source in the writeup and in the
program source code!
You will write a system consisting of a server and three client processes. Each client
process will connect to the server over a socket connection and register a user name at
the server. The server should be able to handle all three clients concurrently and display
the names of the connected clients in real time.
Each client will generate a random integer and upload that integer to the server. The
server thread handling that client will then pause (e.g., sleep or otherwise wait) for the
number of seconds equal to that integer. When the thread is finished waiting, it will reply
to the client with a message stating, “Server waited <#> seconds for client
<name>.” The client will print this message to the user. This sequence will be repeated
until the client is manually terminated by the user.
The server and the client should each be managed with a simple GUI. The GUI should
provide a way kill the process without using the ‘exit’ button on the window. Messages
exchanged between server and client should use HTTP formats and commands.
The HTTP tags must use, at minimum, Host, User-Agent, Content-Type,
Content-Length, and Date. If you are polling the server, use GET. If you are sending
data to the server, use POST.
The required actions are summarized as follows:
Client
The client will execute the following sequence of steps:
1. Connect to the server via a socket.
2. Provide the server with a unique user name.
a. May be a string provided by the user; or,
b. Some value associated with the process.
3. Generate a random integer between 5 and 15.
4. Upload that integer to the server.
5. Wait until response received from the server.
6. Parse the HTTP message and print response from the server in normal text.
7. Repeat at step 3 until the process is killed by the user.

Server:
The server should support three concurrently connected clients and display a list of
which clients are connected in real-time. The server will execute the following sequence
of steps:
1. Startup and listen for incoming connections.
2. Print that a client has connected and fork a thread to handle that client.
3. Print integer received from client to GUI and announce that it is waiting for that
period of time.
4. Pause (sleep or otherwise wait) for the number of seconds equal to that integer.
5. After waiting, will return a message to client stating, “Server waited <#>
seconds for client <name>.”
6. Begin at step 3 until connection is closed by the client.
  
The server must correctly handle an unexpected client disconnection without crashing.
When a client disconnected, the user must be notified in real-time. The server should
print messages both received from, and sent to, the client in unparsed HTTP so that the
grader can verify the format.
Your program must operate independently of a browser. Time on the messages
should be encoded according to HTTP.
References:
1. http://www.w3.org/Protocols/ This is the standard.
2. http://www.jmarshall.com/easy/http/ HTTP Made Really Easy.
3. http://tangentsoft.net/wskfaq/ Winsock Programmer's FAQ
4. http://www.eggheadcafe.com/articles/20020323.asp VB.net Single thread Telnet
client & server
  
  
