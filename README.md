### Hamming Code

The Hamming code is a method of error control while transmitting data via digital communication in binary format.
It can detect inconsistencies in the data and correct up to 1 bit error. To do that it uses parity bits. Parity bits are added to the data at positions that are the power of 2.

For example:
If the original data is 1011 the parity bits would be added at the positions 1, 2 and 4, like this: PP1P011

| POSITIONS | 1 | 2 | 3 | 4 | 5 | 6 | 7 |
| - | - | - | - | - | - | - | - |
| VALUES | P1 | P2 | 1 | P3 | 0 | 1 | 1 |

#### How to run the code
Execute the 'main' function in the 'main' class.

#### How the Hamming code works
The values of the parity bits are calculated by following this process:
<p>
Step 1: <br>
Get the position of the parity bit you want to calculate and transform it to binary. Because the positions are always the power of 2, the resultant binary will only ever have one bit with value one<br>
Ex1: P1 is at the positions 1. The value 1 in binary is equal to 001<br>
Ex2: P3 is at the positions 4. The value 4 in binary is equal to 100<br>
<p>
<p>
Step 2:<br>
Look for all the other positions where the binary value of the position has a 1 in the same position<br>
Ex1:<br>
* 1 in binary is equal to 001 :white_check_mark:<br>
* 2 in binary is equal to 010 :x:<br>
* 3 in binary is equal to 011 :white_check_mark:<br>
* 4 in binary is equal to 100 :x:<br>
* 5 in binary is equal to 101 :white_check_mark:<br>
* 6 in binary is equal to 110 :x:<br>
* 7 in binary is equal to 111 :white_check_mark:<br>
<p>
<p>  
Ex2:<br>
* 1 in binary is equal to 001 :x:<br>
* 2 in binary is equal to 010 white_check_mark:<br>
* 3 in binary is equal to 011 :white_check_mark:<br>
* 4 in binary is equal to 100 :x:<br>
* 5 in binary is equal to 101 :x:<br>
* 6 in binary is equal to 110 white_check_mark:<br>
* 7 in binary is equal to 111 white_check_mark:<br>
<p>
<p>
Step 3:<br>
Sum the values of the bits of the positions that meet the criteria of step 2.<br>
Ex1:<br>
1 + 0 + 1 = 2<br>
Ex2: <br>
1 + 1 + 1 = 3<br>
<p>
<p>
Step 4:<br>
If the sum of the values is even, the parity bit value should be 0. If it it odd it should be 1<br>
Ex1:<br>
P1 = 0<br>
Ex2:<br>
P2 = 1<br>
<p>
    

