For the first linear probing, I got some similiar results when a= 1/2. Although
they were a little larger than the expected 2.5. My results were around the 2.6-2.7
range. for n=1000, it was 2.6; 10000, it was 2.7; 100000, it was 2.6; and 1000000
it was 2.7. So they weren't the exact results, but I think that this does provide
some justification for the validation of assumption J.

The results were also justified when N was decreased. This is as to be expected
because you have less spaces for the random number to choose and be placed to.
So, there is going to be far fewer spaces that are false. For 1.5N I got
1000 = 3.1
10000 = 3.1
100000 = 3.1
1000000 = 3.1

Interestingly, the final results when n was decresed. N*1.25 show results that
also line up with the assumption. (mostly). I think that the numbers show how a decrease
in n can increase the average number of probes required. Because you have far more
trues than you do falses. So you are going to have to probe a much bigger number
of array indicies in order to find one that is false.
1000 = 3.2
10000 = 3.3
100000 = 3.3
1000000 = 3.3