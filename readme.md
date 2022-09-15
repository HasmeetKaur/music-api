# **READ ME (MUSIC API):**

## **Who we are:**
![Alt](/logo.png "Logo")
**This isn’t just a Spotify clone, this is a BNTA Spotify clone.**

## **Project Overview:**
We are the team behind the MusicAPI. 4 members of Cohort 6 from the Bright Network Technology Academy!

* Faizan Khan
    * (Github)[https://github.com/faizanahmkhan]
    * (LinkedIn)[https://www.linkedin.com/in/fkhan38/]

* Hasmeet Kaur
    * (Github)[https://github.com/HasmeetKaur]
    * (LinkedIn)

* Milo Curran
    * (Github)[https://github.com/Obilisk-audio]
    * (LinkedIn)[https://www.linkedin.com/in/milo-curran96]

* Joao Pedro Canale Pulsz
    * (Github)[https://github.com/joaopulsz]
    * (LinkedIn)[https://www.linkedin.com/in/joao-pedro-canale-pulsz/]

## **Project Overview**
As part of the Bright Network Technology Academy, we were assigned a group project to research, plan and develop an API in less than a week. As a group, we wanted to create an API which we would want to use personally.

## **This API features:**
- One-to-Many and Many-to-Many relationships
- Derived queries and queries for multiple endpoints
- Full CRUD functionality

## **Table of Contents:**

## **Setup and Instructions for using the Project:**
1. Make sure that you have Java 17 installed to run BeatzNTA API
2. Clone this repository by typing the following command into your terminal:
   git clone git@github.com:HasmeetKaur/music-api.git
3. You can access the endpoints via an API platform such as Postman or through the browser at https://localhost:8080/{endpoint}

## **Project Structure:**

## **Unified Modelling Language Diagrams (UML):**
![Alt](/UML_diagram.png "Logo")

## **Entity Relationship Diagrams (ERD):**
![Alt](/ERD_Diagram.png "Logo")

### **MVP:**
For our MVP, we wanted to create an API with full CRUD functionality.with 6x classes:

* User
* Playlist
* Artist
* Track
* Album

### **Extension:**

For our extension, we wanted to
* add a 'shuffle' button method to generate a randomised playlist.
* search tracks, albums, tracks

## **Plain Old Java Objects (POJOs):**
| POJO 	| Type 	| Input Structure 	|
|:---:	|---	|---	|
| Track 	| String name;<br>Artist artist;<br>Genre genre (Enum);<br>double length; 	| {<br>"name": "",<br>"artist": {    <br>     "id": Long,<br>     "name": "",<br>     "genre": ""<br>           },<br>"genre": "",<br>"length": double<br>} 	|
| Album 	| String name;<br>Artist artist;<br>int year;<br>Genre genre(Enum);<br>ArrayList<Track> tracks; 	| {<br>"name": "",<br>"artist": {<br>     "id": Long,<br>     "name": "",<br>     "genre": ""<br>           },<br>"year": int,<br>"genre": "",<br>"tracks": [ ]<br>} 	|
| Artist 	| String name;<br>Genre genre (Enum);<br>ArrayList<Album> albums;<br>ArrayList<Track> tracks; 	| {<br>"id": Long,        <br>"name": "",<br>"genre": "",<br>"albums": [ ],      <br>"tracks": [ ]<br>} 	|
| Playlist 	| String name;<br>User user;<br>ArrayList<Track> tracks; 	| {<br>"id": Long,<br>"name": "",<br>"user": { },<br>"tracks": { }<br>} 	|
| User 	| String userName; <br>ArrayList<Album> favouriteAlbums;<br>ArrayList<Album> favouriteAlbums;<br>ArrayList<Artist> favouriteTracks;<br>ArrayList<Playlist> playlists; 	| {<br>"userName": "",<br>"favouriteAlbums": [],<br>"favouriteArtists": [],<br>"favouriteTracks": [],<br>"playlists": []<br>} 	|

## **Running the API - List of Possible Commands (CRUD Functionality):**

## **Testing:**
Example of Postman testing:
Postman:

## **Further Implementations & Extensions:**

## **Acknowledgments:**

