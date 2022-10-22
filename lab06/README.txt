Riley Marsden

--------------------------------------------------------------------------------
TASK 1: PQ tester trial runs (10 total trails)
--------------------------------------------------------------------------------
| N Elements   |   Average Runtime (nanoseconds) |
--------------------------------------------------------------------------------
| 10           |   81717 nanoseconds             |
| 100          |   819670 nanoseconds            |
| 1000         |   2447052 nanoseconds           |
| 10000        |   18450197 nanoseconds          |
| 100000       |   111711249 nanoseconds         |
| 1000000      |   948331790 nanoseconds         |
| 10000000     |   5682865163 nanoseconds        |
| 100000000    |   58613348850 nanoseconds       |

________________________________________________________________________________
I think that this representation of data shows an agreement with the time
complexity theory of a priority Queue. O(nlgn)

--------------------------------------------------------------------------------
TASK 2: Heapsort
--------------------------------------------------------------------------------
| N Input Size |    Simple sort Runtime   |    HeapSort Runtime    |
--------------------------------------------------------------------------------
| Nanascnds -> | Construct  | sort        | Construct | sort       |
--------------------------------------------------------------------------------
| 1000         | 1789965    | 3153986     | 594524    | 1538823    |
| 100000       | 54023977   | 115143187   | 76606437  | 73998456   |
| 10000000     | 2996185342 | 7546547705  | 392213770 | 6162540714 |
________________________________________________________________________________
The data shows that a Heapsort is much faster than the simple sort. By quite
some time. This is because the simple sort has to touch all elements in order to
delete all items from the queue. The data shows and supports the time complexity
theory.
