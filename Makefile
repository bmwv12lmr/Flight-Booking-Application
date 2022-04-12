arg1 := src/test/data/Sample.csv
arg2 := src/test/data/flights.csv
arg3 := src/test/play_ground/test.csv
arg4 := src/test/play_ground/test.txt

ans3 := src/test/data/Output.csv
ans4 := src/test/data/Output.txt

build:
	mvn compile
	mvn clean install
run:
	@rm -rf $(arg3) $(arg4)
	mvn exec:java -Dexec.mainClass=test.RunClient -Dexec.args="$(arg1) $(arg2) $(arg3) $(arg4)"
diff:
	vimdiff $(arg3) $(ans3)
	vimdiff $(arg4) $(ans4)
test:
	mvn test
clean:
	mvn clean
	@rm -rf $(arg3) $(arg4)