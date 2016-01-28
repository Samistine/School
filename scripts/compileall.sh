for f in *.java
do
 echo "Compiling $f"
 javac $f
 echo "Executing ${f:: ${#f}-5 }"
 java ${f:: ${#f}-5 }
done
echo "Cleaning class files"
rm *.class
