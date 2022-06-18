# Gloomhaven Secretary Server (ghs-server)

This is a server component for [Gloomhaven Secretary](https://ghs.champonthis.de) ([Source](https://github.com/Lurkars/gloomhavensecretary)). It synchronizes the game state between all clients via websockets. Access is controlled by providing a password in all messages.

It's a java application to run on most systems the old [Gloomhaven Helper](http://esotericsoftware.com/gloomhaven-helper) (by [Esoteric Software®](http://esotericsoftware.com)) Desktop version run. Besides an headless mode is integrated.

## How to run

Prerequisite:

- Java 11 (or higher) Runtime Environment

Download the corresponding latest `jar`-executable from the [latest release](https://github.com/Lurkars/ghs-server/releases/latest) assets.

Execute the `jar`-file with your Java Runtime Environment or run `java -jar ghs-server-*.jar` in your terminal.

### Run headless

To run the server in headless mode, just set `-Djava.awt.headless=true` parameter for execution. For example  `java -jar ghs-server-*.jar -Djava.awt.headless=true`.

### Change port

To run the server on a different port (default: 8080), place/edit the `application.properties`-file next to the `jar`-executable and add the following line: `server.port=9999`.

Replace `9999` with the port of your choice.

### Run public

A public server accepts any password and creates a game for it. So the password is more an identifier for an individual game than a protection. To make a public server place/edit the `application.properties`-file next to the `jar`-executable and add the following line: `ghs-server.public=true`.

## How to use with GHS

Go to the main menu in Gloomhaven Secretary (GHS) and click on **Connect to Server**. Enter the server's IP/Hostname into **Host** (on same machine just use `localhost`), set **Port** to `8080` (if not changed default port).

On the first time, just choose the **Password** of your choice. This will create a new Game with this password. Afterwards, any connection to the server will need the same password to be set (It is not changeable by now!).

## Missing / Upcoming

- Adding/Changing passwords with specific permissions
	- for example grant clients only updating a special character, so each player can only change it's own values
	- allow different games on same server (for public servers for example)
- updated GUI (it's more a placeholder by now)
	- show available IPs/Hostnames + port for easier connection
	- add/change/update password/permissions
- optional: track Undo/Redo also on server

## Workarounds

- on first time initialization, a new game is created for your password. If you want to have your latest local game synced, simple use the **Undo**-function directly after first connection established. This will sync your last state to the server.
- The database is a simple `ghs.sqlite`-file next to the `jar`-executable. You can manipulate the file directly with `Sqlite`. To reset the database, simple delete the `sqlite`-file.
- on startup, the passwords are written into syslog in plaintext.

## Copyright / License

Gloomhaven and all related properties, images and text are owned by [Cephalofair Games](https://cephalofair.com).

Source code is licenced under [AGPL](/LICENSE)

## Personal disclaimer

This is a hobby project I do in my free-time. The software provides a practical need due to the end of the original Helper app and so I completely follow the **Quick'n'Dirty** approach to get things fast done. This leads of course to a lack of quality and testing and the code base does definitely not comply with my profession.
	 