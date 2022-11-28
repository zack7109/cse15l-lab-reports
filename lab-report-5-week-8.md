```# Create your grading script here

set -e
#CPATH = ".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar"

rm -rf student-submission
rm -rf list-methods-corrected
rm -rf test.txt
rm -rf runtime-err.txt
rm -rf compile-err.txt
mkdir student-submission

git clone $1 student-submission/


if [ -f "student-submission/ListExamples.java" ]
then
    set +e
    cp student-submission/ListExamples.java .
    echo "File Found!"
else
    echo "File Not Found :("
    exit
fi

javac -cp ".;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar" *.java 2> compile-err.txt

if [[ $? -eq 0 ]]
then
    echo "Compilation Success!"
else
    echo "Compilation Failure :("
    echo "$(cat compile-err.txt)"
    exit
fi

java -cp ".;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar" org.junit.runner.JUnitCore TestListExamples 2> runtime-err.txt > test.txt

if [[ $? -eq 0 ]]
then
    echo "Passed!"
else
    echo "Failed :("
    echo "$(cat runtime-err.txt)"
fi
exit
```

***FIRST EXAMPLE***
<br>
[Sample 2 (with full points)](https://github.com/ucsd-cse15l-f22/list-methods-corrected)
<br>
![Image](https://media.discordapp.net/attachments/481212732562079756/1046844236437401630/image.png)
<br>
**FULL Trace:**
<br>
First, the code runs set -e to make it that the bash script will not automatically exit when we get an error. Then, we prepare our workspace by removing all the files and directories that could have been left previously. It then creates a new ``student-submission`` directory, which it clones our input (in our case, the student example that has all the methods implemented correctly) into after determining that the repository has the correct file (which it does and reports the file has been found). Then we try compiling it, which creates no errors and returns "Compilation Success!". It then tries to run the code using JUnit and our ``TestListExamples.java`` list of tests. Since there is no runtime error, and all the JUnit tests pass, we are left with no error codes, and are told by the autograder that our code has passed.
<br>
<br>
***SECOND EXAMPLE***
<br>
[Sample 3 (with compile error)](https://github.com/ucsd-cse15l-f22/list-methods-compile-error)
<br>
![Image](https://media.discordapp.net/attachments/481212732562079756/1046844571163824210/image.png)
<br>
**Trace:**
<br>
As we can see here, the code caught the compiler error and returned to us that there was a compiler error, and what Java said the error was.
<br>
<br>
***THIRD EXAMPLE***
<br>
[Sample 5 (with incorrect filename)](https://github.com/ucsd-cse15l-f22/list-methods-filename)
<br>
![Image](https://media.discordapp.net/attachments/481212732562079756/1046844727972085870/image.png)
<br>
**Trace:**
As we can see here, the Java file was submitted with the incorrect name, which returned "File Not Found" (since it cannot find the file it is looking for), and exited the code.
