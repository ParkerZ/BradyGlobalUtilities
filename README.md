# BradyGlobalUtilities
Java simple 2D graphics framework that is simple to get started with, also includes Java Utilities that can be used anywhere


###Game Actions<br>
####Info:<br>
Classes and interfaces that can be used to make a simple starter graphics game.<br>
<br>
<br>
###Order and implementation of class<br>
<br>
####Screen:<br>
Interface<br>
Implements - Key, Action, Mouse listeners<br>
#####Summary:<br>
Direction methods for pressed and released directional keys and needed methods for games<br>
<br>
####Control:<br>
Super Class<br>
Implements - Screen<br>
Extends - JPanel<br>
#####Summary:<br>
The framework that runs and has all needed methods for a game.<br>
Method calls - tries to call subclass UserGame methods if overriden, otherwise it's own methods get called<br>
Calls methods through UserGame object variable, if method not in UserGame, because subclass, Control method gets called<br>
<br>
####Directions:<br>
Super/Middle abstract Class<br>
Extends - Control<br>
#####Summary:<br>
The UserGame class can extend this or control class. Extending this class also includes extending Control class<br>
The reason for extending this class would be to force implement the directional methods for when keys are pressed<br>
<br>
####PlayerInterface:<br>
Interface<br>
#####Summary:<br>
UserGame implements this. Ensures that methods for game play and settings can be called<br>
Methods Summary:<br>
**moves** - gets called every refresh - so add movement and everything goes here<br>
**checkIfDead** - return true of false if game should end<br>
**draw** - what should be drawn on all screens<br>
**setup** - used to initialize all variable and asign values<br>
**drawStart** - What should be drawn on start screen<br>
**drawPlaying** - everything that should be drawn while playing<br>
**drawEnd** - drawing the end screen<br>
<br>
These methods don't have to in UserGame because they are already in Control class as default cases<br>
Only rewrite the drawStart and drawEnd methods if you want a custom start or end screen<br>
<br>
####UserGame:<br>
Class - The Only class that should be modified<br>
#####Summary:<br>
This is the class that you would modify to make your game. Check PlayerInterface for method summaries.<br>
There are small inline javadocs for more info<br>
<br>
####Runner:<br>
Class - Runs UserGame<br>
#####Summary:<br>
Run this method to play game.  Creates a JFrame.<br>
<br>
<br>
<br>
<br>
###GameFolder<br>
<br>
####GameInfo:<br>
Has a couple variables that the game uses, also refers to the Window class in Utilities<br>
<br>
<br>
<br>
<br>
###Utilities<br>
#####Info:<br>
Has a couple small classes that can be used to to different things<br>
All static and most have multiple versions of the same method with differing parameters (overloaded)<br>
Very useful for getting simple things done that would be annoying to insert inline or as sepreate methods<br>
<br>
#####Includes:<br>
<br>
**CenteredText** - Centers text on screen at specified Y or in the center of a specified rectangle<br>
**CheckPort** - Checks if a port is open at given host and port number<br>
**CustomFont** - Creates a font from a file path given and has methods to get variations of the font<br>
**FileList** - Easily get and set file contents as a list<br>
**Panel** - basic JPanel template<br>
**ScanNetwork** - Scans all Ips of a network for a specified port and returns witch ips are open<br>
**ScoreInfo** - Used to read and write to 2 score files for a game, one for person name and score, also creates the files if not there<br>
**Window** - Classes use this for all variable reference, so to customize, use Window or not use it and get errors to know where to change<br>

