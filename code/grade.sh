set -e
rm -rf student-submission/
mkdir student-submission/
git clone $1 student-submission/

cp GradeServer.java student-submission/
cd student-submission


if [[-f "ListExamples.java" ]]
then set +e
else echo "File not Found"
    exit
fi

javac -cp ".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar" *.java 2> compile-err.txt 
if [[$? -eq 0]]
then echo "compilation success"
else echo "compilation failure"
    exit
fi

java -cp ".:lib/hamcrest-core-1.3.jar:lib/junit-4.13.2.jar" org.junit.runner.JUnitCore TestListExamples 2> runtime-err.txt > test.txt
if [[$? -eq 0]]
then echo "passed"
else echo "failed"
    exit
fi
