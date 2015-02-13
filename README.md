# BradyGlobalUtilities
Java simple 2D graphics framework that is simple to get started with, also includes Java Utilities that can be used anywhere


Game Actions
Info:
Classes and interfaces that can be used to make a simple starter graphics game.



Order and implementation of class

Screen:
Interface
Implements - Key, Action, Mouse listeners
Summary:
Direction methods for pressed and released directional keys and needed methods for games

Control:
Super Class
Implements - Screen
Extends - JPanel
Summary:
The framework that runs and has all needed methods for a game.
Method calls - tries to call subclass UserGame methods if overriden, otherwise it's own methods get called
Calls methods through UserGame object variable, if method not in UserGame, because subclass, Control method gets called

Directions:
Super/Middle abstract Class
Extends - Control
Summary:
The UserGame class can extend this or control class. Extending this class also includes extending Control class
The reason for extending this class would be to force implement the directional methods for when keys are pressed

PlayerInterface:
Interface
Summary:
UserGame implements this. Ensures that methods for game play and settings can be called
Methods Summary:
moves - gets called every refresh - so add movement and everything goes here
checkIfDead - return true of false if game should end
draw - what should be drawn on all screens
setup - used to initialize all variable and asign values
drawStart - What should be drawn on start screen
drawPlaying - everything that should be drawn while playing
drawEnd - drawing the end screen

These methods don't have to in UserGame because they are already in Control class as default cases
Only rewrite the drawStart and drawEnd methods if you want a custom start or end screen

UserGame:
Class - The Only class that should be modified
Summary:
This is the class that you would modify to make your game. Check PlayerInterface for method summaries.
There are small inline javadocs for more info

Runner:
Class - Runs UserGame
Summary:
Run this method to play game.  Creates a JFrame.





GameFolder

GameInfo:
Has a couple variables that the game uses, also refers to the Window class in Utilities






Utilities
Info:
Has a couple small classes that can be used to to different things
All static and most have multiple versions of the same method with differing parameters (overloaded)
Very useful for getting simple things done that would be annoying to insert inline or as sepreate methods

Includes:

CenteredText - Centers text on screen at specified Y or in the center of a specified rectangle
CheckPort - Checks if a port is open at given host and port number
CustomFont - Creates a font from a file path given and has methods to get variations of the font
FileList - Easily get and set file contents as a list
Panel - basic JPanel template
ScanNetwork - Scans all Ips of a network for a specified port and returns witch ips are open
ScoreInfo - Used to read and write to 2 score files for a game, one for person name and score, also creates the files if not there
Window - Classes use this for all variable reference, so to customize, use Window or not use it and get errors to know where to change

