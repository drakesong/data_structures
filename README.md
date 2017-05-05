# graph_search_algorithms

#### CS 229 Data Structures HW #4
#### Spring Semester 2017, Professor Justin Li
#### Occidental College, Los Angeles, California

###### HW Handout:

1. Implement the following graph search algorithms. For the purpose of this assignment, if two nodes have the same depth/breadth/priority, your code should select nodes based on their alphabetical ordering.

    a. Depth First Search
  
    b. Breadth First Search
  
    c. Uniform Cost Search

  The starter code on Moodle contains several classes:
  
* SearchAlgorithms contains function stubs for all three searches, which take in a start and end Node, and returns a NodeList of the order in which the Nodes were visited. This is the only file you need to modify, but you may want to add additional test cases in Main.

* Graph, Node, and Edge contain the classes that make up a directed weighted graph. Your search algorithms will only need to use the methods of the Node and Edge classes. In particular, you will mostly be working with the following functions:

  * Node.getChildren() returns an Iterator of the outgoing Edges from a node.
  * Edge.getChild() returns the child Node of an edge.
  * Edge.getWeight() returns the weight of an edge.

  The Graph class is provided mostly to allow easy testing; an example of how to use the class is in Main. The class also has a print() method, which prints out a Graphviz representation of the graph. You can visualize the output of the print() method in the Graph class using the viz.js website (http://viz-js.com/).

* NodeList, NodeSet, NodeNodeMap, NodeIntMap, NodePriorityQueue are utility classes that implement subsets of the Java List, Set, Map, and PriorityQueue interfaces/classes, except specialized for Nodes (so you don't have to deal with generics). The NodePriorityQueue class has three slightly modified methods:

  * The add(Node node, int priority) method allows you to add the node with a specific priority. Java's PriorityQueue requires you to define a binary comparator, which cannot be easily done here. As per convention, a lower priority number is removed from the queue first. This priority queue additionally orders Nodes alphabetically if they have the same priority.

  * The peekNode() method returns the first node in the queue, without removing it from the queue. This is the equivalent of the standard peek() method in PriorityQueue.

  * The peekPriority() method returns priority of the first node in the queue, without removing the node from the queue.

    If you find yourself needing other data structures beyond these, you're probably overthinking whatyou need to do.

  * Main provides example code for creating a graph and using the search algorithms on the graph. You can modify this file for testing. If we start a search at Z and stop at S for the graph below, the correct visiting orders would be:

      Depth first search: Z, X, U, S
      
      Breadth first search: Z, X, Y, U, W, S
      
      Uniform-cost search: Z, Y, X, W, V, U, S

  * EightPuzzle provides an application of search algorithms with sliding puzzles. Several starting puzzles are in there, including an impossible puzzle. For all but the last, running main() should cause the goal board to be printed out at the end. If you are interested in solving 8-puzzle, consider doing the challenge question below.

