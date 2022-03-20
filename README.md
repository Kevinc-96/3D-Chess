<!-- Readme Start:
* This readme format was taken from a previous project
Source: https://github.com/Kevinc-96/Phresh/blob/main/README.md#general-info -->

# 3D-Chess

* [General info](#general-info)
* [Contents](#contents)
* [Technologies](#technologies)
* [Setting up](#setting-up)
* [Playing](#playing)
* [Notes](#notes)


## General Info
3D-Chess is a 3D chess game that utilizes the Java GUI to render the game, play with your friends today! Imagine traversing the boards like walking up or down stairs, meaning that to move up or down 1 board, you must also appear on the tile that is either directly after or before the current tile you are on. If you want to move up two boards, the same stair case logic applies, but with 2 tiles instead. A piece can only traverse 2 boards if they can traverse 2 tiles or more normally.

## Contents
Listed below is the structure of the project.

```
 Main project folder: 
├── 3D-Chess.jar                
├── Bishop.java              
├── Board.java              
├── ChessBoard.java
├── ChessBoard3D.java
├── Game.java                 # the main class of the game
├── Games.java
├── Graveyard.java
├── King.java
├── Knight.java
├── Pawn.java
├── Piece.java
├── PieceType.java
├── Player.java
├── Queen.java
├── README.md
├── Rook.java
├── Side.java
├── Tile.java
└── README.md

```
## Technologies
Technologies used for this project:
* Java

## Setting up
How to set up a development environment on Windows.
1. Install Microsoft Visual Studio Code IDE
    * Head on over to https://code.visualstudio.com/download
    * Click on the version that matches your system specifications
    * Click on the downloaded file and install the software

2. Join the GitHub Repo
    * Here is the GitHub repo link: https://github.com/Kevinc-96/FOMONO
    * Provide me with your email address and I will add you to my GitHub repo

4. Download our Project Files 
    * Create a folder on your computer to store our project files.
    * Head over to our GitHub repo and clone the master repo via "git clone https://github.com/Kevinc-96/3D-Chess"
    * Create your own branch, and start coding away!

## Playing
There are two ways to run the game:
1. Compile game.java and then run the file.
2. Run the jar file: 3D-Chess.jar.

## Notes
The 3D moves work fully for the Queen and Pawn pieces. Other pieces are capable of 3D movement, but their functionality is incomplete. As a result, they may be able to perform illegal moves when traversing boards. 

Regular chess can be played as normal, as all of the pieces are fully functional on a single board.

```
