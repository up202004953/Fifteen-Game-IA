# Fifteen-Game-IA

This is a program that can solve the fifteen puzzle with different AI algorithms. To execute the program you need to have java 8 installed on your computer and run the following command:

**$> javac \*.java && java Main**

If you want to insert an input file, the file must be in this format:

*** FILE ***  
(Puzzle side size)  
(Initial board state in extension with blank piece being 0)  
(Final board state in extension with blank piece being 0)  
(Algorithm ID)  
(Heuristic ID [only for informed algorithms])  
*** FILE ***  

And then run the command:

**$> javac \*.java && java Main < [filename].[extension]**  

Algorithm ID:  
  1 - A*  
  2 - BFS  
  3 - DFS  
  4 - IDS  
  5 - GREEDY  

Heuristic ID:  
  1 - Summation of the misplaced pieces  
  2 - Manhattan distance  
  
Example of a file:  

*** FILE ***  
4  
1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 0  
1 2 3 4 5 6 0 7 9 10 11 8 13 14 15 12  
5  
2  
*** FILE ***  
No need for external libraries. The program was compiled with Linux (Fedora v31) using the javac (v1.8.0_272) compiler. 
