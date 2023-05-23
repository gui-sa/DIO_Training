# Internet Protocol

## HTTP : HyperText Transfer Protocol
Defined by RFCs 1945 and 2116 <br>
Browser contains an HTTP tool embeeded <br>
In HTTP 1.1 blocks CORS (in which is blocked by default) <br>
Persistent connection: when a message is transferred the connection continues openned. <br>
***GET*** - Usually for "requesting and submiting" something from an server... It **appears** on routes (90% of WEB USAGE) <br>
***POST*** - Usually for "requesting and submiting" something to a server... It is invisible <br>
HTTP is Three-way hand-shaking (SYN/SYN-ACK/ACK) <br>
HTTP/1.1 uses just **one** connection/time in **not persistent** mode <br>
HTTP/1.1 uses just until **six** connection/time in **persistent** mode <br>
HTTP/1.1 overheading because of limitation in connection/time "HOL" problem <br>
GET, HEAD and OPTION are READ-ONLY methods: idempotent <br>
Stateless: do not save any information. <br>
HTTP/2.0 You start a main persistent connection and within it, you create more parallels connections. <br>
HTTP/2.0 You can *prioritize* the resources consumption for UI/UX increase in performance <br>
HTTP/2.0 You send a ***FRAGMENTED PACKAGES***, in which might be compressed. <br>
HTTP/2.0 your server can **PUSH** more than just required files <br>
> PUSH need to be **"manually"** setted up on client and server files (otherwise will have problems) <br>
HTTP/2.0 ***TLS*** os default (HTTPS) <br>
HTTP/2.0 is negotiated in the handshake phase.
LOAD BALANCER will usually complain about HTTP/2.0



## STRUCTURE of an HTTP:

Text in ASCII
### REQUEST:
 - **REQUEST LINE**: containing Requisition Method (GET/POST), ROUTES and HTTP/version
 - **HEADER LINE**: containing Host information: URL:PORT, connection type (close for not persistent), User-agent: browser/version (who is creating this request), others...

### RESPONSE
 - **STATUS LINE** : containing HTTP/version, status code, meaning in short of the status code, connection type(close for not persistent), date, last-modified datetime, content-length (how many byte there is inside), content-type ( text/html, plain/text, etc)
 > 200 OK (sucess!) <br>
 > 301 Moved Permanently (URL has been changed) <br>
 > 400 Bad Request (server couldn't understand you...) <br>
 > 404 Not Found (File not Found) <br>
 > 505 HTTP Version Not Supported (server don't support this version of HTTP)
(10:51)
 - **ENTITY BODY** : The valued data or information.


## TCP
No package is lost
The package loss security make it slower

## UDP
Package is not checked and might be lost <br>
Faster

## DATA
It goes over HTTP Entity Body 
> Saving, transferring and receiving <br>
> They have hierarqui... might represent an object <br>
 - XML
 > Uses TAGs <br>
 > Usually present on legacy codes.
 - JSON
 > JSON is light weighted <br>
 > Independent from language <br>
 > Key-valued

 # Cookies and Cache
 RFC 6265 <br>
 When you need to authenticate or to track some information... It saves information. <br>

 ## COOKIES:
 They are a header file used to:
  - Maintain logins activated
  - E-commerce car
  - Information

There are two types of cookies:

 - Session Cookies
 - Persistent Cookies

Some problems:
 - It needs to respect LGPD
 - HACKING problems

## CACHING

Or proxy server. <br>
If it has the information (updated), it sends you the information back instantly without asking for the final destination again. <br>
Proxy works either as Client and Server <br>
It can be used to limit network accessing (to prohibited ones), because your machine will be served by the proxy, so, it can block you research. <br>

Trades
 - For frequents researchs it will decrease substationally the amount of time.
 - For diferents researchs it will increase the amount of time needed 
 - It reduces bandwidth necessity
 - Raises security by hiding your address from internet
 > Server knows PROXY SERVER not YOU

There are webcaches more than just proxys

## HTTP SERVERS
 - APACHE (can be used with XAMPP)
 > Open Source <br>
 > "Highly Scalable" - up to 10000 connections/time <br>
 >> ***XAMPP cannot be access internet***... So its used just for development and tests <br>
 >> 35% uses Apache
 - NGINX
 > Stays between the internet and your backend <br>
 > Can handle more than 10000 connections time... overly used <br>
 > Reverse proxy <br>
 >> NGINX is the only one that can access your servers <br>
 > Load Balancer <br>
 > Mail Proxy <br>
 > HTTP Cache 
 >> 33% Uses NGINX


 # Information Security 
  - Criptography Key
    - Asymmetric: You have a private and public pair keys. The public one can confirm the data but not access it. The private key can access it.
    > SSH is a Asymmetric Key
    -Simmetric: Both sides have a key to access and cript it back
    > Cesar Hash <br>
    > Block cypher : bit-bit codec in k block <br>
    >> It creates a Table only know by both sides <br>
    >> usually it k>64 so its so hard and costy to break <br> 
    > Flux cypher : bit-bit codec with all the flux<br>
  - Digital Certificate : a Certification Authority - CA in which needs to be verified
    >> IETF - ITUX.509 and RFC 1422

## SSL - Secure Socket Layer
 TLS is third version of SSL RFC 4346
 - Reliable
 - Integrity
 - End-Point authencity
 1. HandShake (three-way)
   1. SSL Hello is sent to SSL
   2. Server sends Certification
   3. Client with Master Secret Key (EMS = CA + MS) sends an Master Secret (MS) to server
   > Master Secret (MS) is Symmetric <br>
   > EMS is Asymmetric <br>
   > PORT 443 is used
 2. Key Derivation
 3. Data Transfer

## LGPD "Lei Geral de Proteção para Dados"
Based on GDPR - General Data Protection Regulation <br>
It protects:
 - Identification Data
   - CPF
   - Credit Card
 - Sensible data
   - Ethnicity
   - Religion
   - Sexual data
   - Etc


# WEB SOCKET
Used when maintaining connection used by HTTP would overflow(overhead) bandwidth (and be inefficient) <br>
WEB SOCKET implements using API an bi-direction connections <br>
Usually to Real Time Aplications <br>
Examples: 
 - Cooperative (such google docs, trello, etc...)
 - Games 
 - Efficient applications
WEB Socket uses partially HTTP:
 - Filters
 - Proxies
 - Auth
Over 443 PORT
 1. Two-way handshake
 > Upgrade: websocket <br>
 > Uses cookies <br>
 > persistent <br>
 > There are Security Key <br>
 2. Data Transfer 

# DNS:
 1. Your computer asks an DNS SERVER ... knowing just the URL...
 2. DNS returns the IP:port
 3. Your connection knowing IP:port, access the server

# Load Balancer:
 1. Distributes connections between servers
 2. Multiplexes connections

# More links