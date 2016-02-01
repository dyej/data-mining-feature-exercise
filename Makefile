#compile: javac ./src/*.java -d ./bin
#run: java -cp ./bin PreProcess

default:
	javac ./src/*.java -d ./bin

clean:
	$(RM) ./bin/*.class
