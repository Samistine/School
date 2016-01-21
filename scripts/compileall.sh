for f in *.java
do
 echo "Compiling $f"
 javac $f
 echo "Executing ${f::-5}"
 java ${f::-5}
done
echo "Cleaning class files"
rm *.class
