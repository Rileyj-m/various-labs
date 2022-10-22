1) --  (A) -- We can use a heapsort. We can use this method because it is linearithmic time. But this is also an in-place sorting
algorithm. Meaning that it's not creating another array to help with sorting the items. That's we I chose to use this
method, and why it satisfies the requirements of this lab.


1) --  (B) -- By doing this, we make the uniform hashing assumption. That the items in the hashtable will be evenly
distributed throughout the entire table.

2) Both of these methods are really effective. they both work when testing all the files. The runtimes of both of
these approaches are expected to be linearithmic and linear. O(n), and O(NlgN). The impact of the collision is really
non-existentent because of the way that I am handling the collision. Instead of created a new key, I just update the keys
value. This has no addition impact to the size of the array either. Because the same keys are still there.
