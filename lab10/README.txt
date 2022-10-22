Appraoch that was discussed with time during Friday's lab.

How does this approach help solve the problem? Why is this a good approach?

This is a good approach because we are trying to get this done in NlgK time,
and with Red-black bst the put() and deleteMin() are lgK because it has k keys;
and we get the N from the elements in the arrays. This helps solve the problem
because if we are not at the end of the array and the key is not in the BST,
then the next key is added from the array. Otherwise, there is a duplicate, and we must stop.

how does this scale?
(n)          | (k)        |(Time)
n = 1000000  | k = 400    | elapsed time: 0.890175 seconds
n = 10000000 | k = 400    | elapsed time: 6.05569 seconds

(n)          | (k)        |(Time)
n = 1000000  | k = 40     | elapsed time: 0.695945 seconds
n = 1000000  | k = 400    | elapsed time: 0.912253 seconds

This scales as it should be expected. Although when increasing N, it seems like
it might scale a little better than N time. An K scales in lgK time as it should.
