//EFFICIENCY OF SORTING WORDS
My dictionary is formed using a TreeMap.
This means that checking for prefixes is easier; that was one of the hardest problems in finding the words on the Board. 

//EFFICIENCY OF FINDING WORDS
findWords(String in, int x, int y, List<Integer> visit) uses recursion to find all the words on a board. 
It takes 4 arguments, the string so far, the new tile x and y, then the array of already visited cells. 
If the cell it goes into has already been visited, then it will just return, and the recursive code ends. 
If the current old string plus the new character at the tile [x, y] is not a prefix of any word in the dictionary, it will return. 
If the current string is a word in the dictionary, it will add it to the list of possible words and keep going until one of the other conditions are met.
This is run on every tile, eventually building the complete list of every possible word on the board.
This list is then used to check against the player words. 
Every word the player types in is checked against the machine list, thereby only having to find all the words one time 
without having to check every time to see if a word is within the board.

//CONCLUSION
This assignment was difficult and took way too much of my time during my hardest week of school thus far. 
Would not recommend.  

Robert Skelton
robertjskelton@gmail.com
11.18.12