
show:
	@echo make lint - Run linter 
	@echo make cov	- Run coverage 
	@echo make test - Run all tests
	@echo make clean- remove all generated data

lint:
	@sbt scapegoat

cov:
	@sbt coverage

test:
	@sbt test 

clean:
	@rm -rf target/ project/project/ project/target/
