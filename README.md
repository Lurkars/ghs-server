# Gloomhaven Secretary Server (ghs-server)

This is a server component for [Gloomhaven Secretary](https://gloomhaven-secretaryde.) ([Source](https://github.com/Lurkars/gloomhavensecretary)). It synchronizes the game state between all clients via websockets. Access is controlled by providing a password in all messages.

It's a java application to run on most systems the old [Gloomhaven Helper](http://esotericsoftware.com/gloomhaven-helper) (by [Esoteric Software®](http://esotericsoftware.com)) Desktop version run. Besides an headless mode is integrated.

A public server is available under `gloomhaven-secretary.de` port `8443` with `secure` option.

## Support

☕ [Buy me a coffee?](https://ko-fi.com/lurkars)

## How to run

Prerequisite:

- Java 11 (or higher) Runtime Environment

Download the corresponding latest `jar`-executable from the [latest release](https://github.com/Lurkars/ghs-server/releases/latest) assets.

Execute the `jar`-file with your Java Runtime Environment or run `java -jar ghs-server-*.jar` in your terminal.

### Build and run using Docker

If you want to use docker for running on port 8080 execute following:

```shell
docker build -t ghs-server .
docker run --rm -p 8080:8080 ghs-server
```

For usage with docker compose, simple run `docker compose up -d`.

### Serve client

The server is also capable of serving the client. Simple click the "Install latest Client" button in GUI. If you run headless, just download zip file (NOT source code!) of [Gloomhaven Secretary Release](https://github.com/Lurkars/gloomhavensecretary/releases) and extract in folder `<your-home-folder>/.ghs/gloomhavensecretary`. Afterwards GHS is accessible under `http://{your-ip}:{server-port}/index.html` (`http://localhost:8080/index.html` with default values). To automatic install latest client on startup, edit the `application.properties`-file in GHS server config folder `<your-home-folder>/.ghs` and add the following line: `ghs-server.lastestClientOnStartup=true`.

### Run headless

To run the server in headless mode, just set `-Djava.awt.headless=true` parameter for execution. For example  `java -jar ghs-server-*.jar -Djava.awt.headless=true`.

### Change port

To run the server on a different port (default: 8080), edit the `application.properties`-file in GHS server config folder `<your-home-folder>/.ghs` and add the following line: `server.port=<NEW PORT>`.

Replace `<NEW PORT>` with the port of your choice.

### Run public

A public server accepts any password and creates a game for it. So the password is more an identifier for an individual game than a protection. To make a public server edit the `application.properties`-file in GHS server config folder `<your-home-folder>/.ghs` and add the following line: `ghs-server.public=true`.

### Enable SSL

If you want to connect to the server from a client using HTTPS the websocket connection is upgraded to wss by any modern browser. Therefore a connection to a server in local network is only possible when enabling SSL. A self-signed certificate is already shipped within (yes, inlcuding hardcoded password visible for everyone). So to simple enable SSL, just edit the `application.properties`-file in GHS server config folder `<your-home-folder>/.ghs` and add the following line: `server.ssl.enabled=true`. Because self-signed certificate is used, it is untrusted by all modern browsers. To be able to connect, just call `https://{your-ip}:{server-port}` (`https://localhost:8080` with default values) and accept the security warnings. Afterwards you should be able to connect via SSL. (This has to be done for each client.)

To serve with your own certificate, overwrite the following properties in your `application.properties`-file:

```
server.ssl.key-store-type=
server.ssl.key-store=
server.ssl.key-store-password=
server.ssl.key-alias=
```

To create a cert file from your [Let's Encrypt](https://letsencrypt.org/)-certificate, use 

```
openssl pkcs12 -export -in fullchain.pem -inkey privkey.pem -CAfile chain.pem -caname root -name ghs-server -out ghs-server.p12
```

This will ask for a password and afterwards create a `ghs-server.p12`-file to be referenced as `server.ssl.key-store`.


#### Automatic HTTP

When running with SSL, a non-SSL server will be automatically available at port `8081`. To change this port, edit the `application.properties`-file in GHS server config folder `<your-home-folder>/.ghs` and add the following line: `server.http.port=<HTTP PORT>`.

## How to use with GHS

Go to the main menu in Gloomhaven Secretary (GHS) and click on **Connect to Server**. Enter the server's IP/Hostname into **Host** (on same machine just use `localhost`), set **Port** to `8080` (if not changed default port).

On the first time, just choose the **Password** of your choice. This will create a new Game with this password. Afterwards, any connection to the server will need the same password to be set (It is not changeable by now!). Alternatively make the instance [public](#run-public) to allow multiple games/passwords. 

## Missing / Upcoming

- ~~Adding/Changing passwords with specific permissions~~
  - ~~for example grant clients only updating a special character, so each player can only change it's own values~~
  - ~~allow different games on same server (for public servers for example)~~
- updated GUI (it's more a placeholder by now)
  - ~~show available IPs/Hostnames + port for easier connection~~
  - add/change/update password/permissions
- optional: track Undo/Redo also on server

## Workarounds

- on first time initialization, a new game is created for your password. If you want to have your latest local game synced, simple use the **Undo**-function directly after first connection established. This will sync your last state to the server.
- The database is a simple `ghs.sqlite`-file in GHS server config folder `<your-home-folder>/.ghs`. You can manipulate the file directly with `Sqlite`. To reset the database, simple delete the `sqlite`-file.
- on startup, all passwords are written into syslog in plaintext.

## Privacy

This application does NOT collect ANY personal data besides the GHS game state, authentication and permission data. Please keep in mind that this data is NOT ENCRYPTED. Take care that you need to trust any third party provider of a server component to not collect any more data like IP addresses.

## Copyright / License

Gloomhaven and all related properties, images and text are owned by [Cephalofair Games](https://cephalofair.com).

Source code is licenced under [AGPL](/LICENSE)

## Personal disclaimer

This is a hobby project I do in my free-time. The software provides a practical need due to the end of the original Helper app and so I completely follow the **Quick'n'Dirty** approach to get things fast done. This leads of course to a lack of quality and testing and the code base does definitely not comply with my profession.
	 
