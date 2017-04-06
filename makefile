
Tigger.class: Tigger.java
	javac Tigger.java

Tigger.java: Tigger.jj
	javacc Tigger.jj

check: Check.java
	javac Check.java

clean:
	$(RM) *.class
	$(RM) ast/*.class
	$(RM) ParseException.java Tigger.java TokenMgrError.java SimpleCharStream.java TiggerTokenManager.java TiggerConstants.java Token.java

.PHONY: clean check
