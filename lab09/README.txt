1.) Already drawn on a scratch piece of paper.
--------------------------------------------------------------------------------

2.) Firstly, we are reading in the file and then constructing a digraph with the file
that was read in. In the file the top two lines are used in the Digraph api to
specify how many edges and vertices there will be. And then the remaining lines in the
txt file are used to put into the digraph. With the first part being the vertices, and the
second part being the edge to that vertices (V + E). Whatever V and E are, they get
connected in the digraph in that order. Then, we use this information
to compute a directed path from 10 to every other vertices in the digraph. It does
this by selecting the starting node, 10, and then recursively go to the edges of 10
and connecting that edge to ten, then setting it to marked. Then it starts at that
edge and sets that to the vertex, and does the same thing with its edges. It
continues this pattern until it has reached all nodes that it can in the digraph.
After all of this has been constructed, we check in the for loop if ten has a connection
to any specific node that was specified. Starting from zero. If no, then we continue,
if yes, then we print out the path to that node from ten.
--------------------------------------------------------------------------------

5.)
Debugging can be extremely valuable when looking at recursive calls because you
can see the different variables and their values. You can also step into different
loops/methods to understand the inter-workings of these variable values. Debugging allows
the user the ability to walk through the operations of their code in realtime, step into
methods, step out, and understanding how their code works/runs.

DFS checks paths in the order that it decides to store them. DFS just cares about a
path to a node from another node. It's not checking for the shortest path, by the inner workings
of DFS. If we wanted to display the shortest path we should consider using BFS. DFS is worried
about finding a path, not finding the optimal path.
--------------------------------------------------------------------------------

6.)
This lab relates to Wordnet because we are going to be implementing a digraph
to represent the data in Wordnet. The API of Wordnet has a lot of the same ideas
of this lab, finding a path to return a synset. The only difference is that we
should consider using BFS instead of DFS because we are concerned about finding
the shortest common ancestor of the two nouns. We can also use BFS to find the
distance between the two nouns.

-----Note-----
I have discussed all of this information with Tim, he told me to write this instead
of him keeping track of everyone that he talked to.