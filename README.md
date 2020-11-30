# BOOTH-IMPLEMENTATION
 
 
INPUT-
First Number
Second Number


OUTPUT-
Result of multiplication of two numbers in binary as well as magnitude.
Text file named "answer.txt" containing input numbers,step used in approach for result and result of multiplication.


LANGUAGE USED
Implemented in JAVA


METHODOLOGY
1.Two input number taken from user are converted into binary by keeping in mind whether the number is negative or not.
2.Set the upper bound on number of register bit as 12 bit if binary form two number has maximum length of  12 or as 24 bit if the maximum length exceeds 12.
3.First number is assigned M and second number is assigned Q with accumulator initialized as acc containing 12 or 24 bit zero string.
4.Run a loop which check Q0 and Q-1 in each cycle and perform steps accordingly:-
    for Q0=0 and Q-1=0   Arithmetic Shift Right
    for Q0=0 and Q-1=1   acc=cc+M 
                         Arithmetic Shift Right
    for Q0=1 and Q-1=0   acc=cc+(-M) 
                         Arithmetic Shift Right
    for Q0=1 and Q-1=1   Arithmetic Shift Right
5.Final result after complete run of loop is displayed and its magnitude is also putted on output.


FUNCTIONS CREATED
1. multiply(String,String,PrintWriter)                  which multiply two binary string and return resultant binary string.
2. magnitude(String)                                    which return integer magnitude of passed binary string.
3. change_to_bits(String,int)                           which return string of required number of bits passes as int.
4. t(String)                                            which return two's complement of passed binary string.
5. add_binary(String,String)                            which add two binary numbered string and return string resultant.
