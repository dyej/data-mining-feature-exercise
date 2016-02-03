#compile: javac ./src/*.java -d ./bin
#run: java -cp ./bin PreProcess

default:
	javac ./src/*.java -d ./bin

run:
	java -cp ./bin PreProcess

clean:
	$(RM) ./bin/*.class
