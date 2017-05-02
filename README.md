# avl_tree

#### CS 229 Data Structures HW #2
#### Spring Semester 2017, Professor Justin Li
#### Occidental College, Los Angeles, California

###### HW Handout:
This homework is out of 150 points, with 15 points of extra credit. Any code and writing you submit must be your work and yours alone.

1. (135 points) Recall that a Map is an ADT that allows you to associate a value with a key. As an example, think of an English dictionary - every word has a definition, you can look up the definition with the word, and the words are unique. In this case, the key would be the words, and the value would be the definition of each word.

    This main question of the homework asks you to implement the AVLTreeMap class, which creates a map based on the self-balancing AVL tree. A number of starter files have been provided for you:

* Map.java: The Map interface, which is implemented by the AVLTreeMap and SortedArrayMap classes. This interface defines the three methods:
  * public int size(): This method returns the number of keys and values in the map.
  * public void put(String key, String value): This method associates the given value with the given key. For the purpose of this homework, if the key is already in the map, the map is not changed and the existing value remains associated with the key.
  * public String get(String key): This method returns the value associated with the given key. For the purpose of this homework, if the key is not in the map, this function should return null.

  For example, the follow code could be used to create a dictionary of three words.
    
       Map map = new AVLTreeMap();     
       map.put("doe", "A deer, a female deer.");     
       map.put("ray", "A drop of golden sun.");     
       map.put("me", "A name I call myself.");     
       map.put("far", "A long long way to run.");     
       System.out.println(map.size()); // 4     
       System.out.println(map.get("ray")); // "A drop of golden sun."
     
* AVLTreeMap.java: This is the main file which you will be working on. Most of the file is the AVLTreeMap class, but I have also provided you with a Node class. Because you are writing a Map, each Node does not contain just a single number, but instead contains a key and a value. The Node class also contains the balance() function, which you should complete.

  In addition to the empty methods from the Map interface, the AVLTreeMap class has two other public methods:

  * A static main() that runs a small test case.
  * A print() that will help you debug your tree. This function prints the AVL tree in a preorder traversal, together with the height and balance information of each node. For example, if you insert the keys "7", "9", "6", "0", "4", "2", "1" (in that order) into your AVLTreeMap, your tree would look like:
 
     | | | | | | | |
     |-|-|-|-|-|-|-|
     | | | |4| | | |
     | |1| | | |7| |
     |0| |2| |6| |9|

  Calling print() on the tree will then print:

       4 (H:3, B:0)
         L:1 (H:2, B:0)
           L:0 (H:1, B:0)
           R:2 (H:1, B:0)
         R:7 (H:2, B:0)
           L:6 (H:1, B:0)
           R:9 (H:1, B:0)

 
  Note: because both key and value are Strings, you will need to use the .compareTo() method to compare them. a.compareTo(b) returns a negative number if a is less than b, returns 0 if a is equal to b, and returns a positive number if a is greater than b. So instead of:
 
      String a = "hello";
      String b = "world";
      if (a < b) {
          ...
      }
     
  Instead you would do:
 
      String a = "hello";
      String b = "world";
      if (a.compareTo(b) < 0) {
          ...
      }
     
* SortedArrayMap.java: This file provides an alternate, slower Map implementation using a sorted array - that is, binary search is used to find the index for a new key, and the array is shifted to create space. You do not need to modify this file.

* Main.java: This file contains the dictionary example above. You do not need to modify this file.

* TimingTest.java: This file contains some code to insert a large number of keys into your tree, and prints out the amount of time required to do so. You will need to modify this file for Question 2. See below for more details.

2. (15 points) Experiment with your AVLTreeMap and compare its performance to the SortedArrayMap using the code in TimingTest.java. The main of this file adds numElements keys to each type of Map, but does so in two ways: forwardTest adds numbers from 0 up to numElements, while backwardTest adds numbers from numElements down to 0. After each test, the amount of time required (in milliseconds) is printed out.

    What happens when you change the numElements variable to change the number of elements added to the tree? When does your AVLTreeMap become faster than the SortedArrayMap? How does the speed of adding numbers forwards or backwards change the timing? Why? Include a table of your timing data in your answer to this question.

3. (15 extra points) Do Question 1, but where the Node class does not have a parent pointer. The appropriate line to delete in the Node class has been identified for you. Practically, this means that all your functions must be recursive. Please write that you are attempting the extra credit in your submission.
