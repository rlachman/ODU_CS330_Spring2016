JOPTIONS=-g
USERHOME=$(HOME)

.SUFFIXES:
.SUFFIXES: .class .java
.java.class: javac $(JOPTIONS) $*.java

#
# As you define new classes, add them to the following list.
# It may not be absolutely necessary, but it will help guarantee that
# necessary recompilation gets done.
#
TOPPACKAGE=.

SOURCES:=$(wildcard *.java)
CLASSES:=$(SOURCES:.java=.class)

TARGET=CreatePolyhedra
ASSIGNMENT=CreatePolyhedra

%.class: %.java
	javac  $(JOPTIONS) $*.java

all: $(ASSIGNMENT).jar

$(ASSIGNMENT).jar: $(CLASSES)
	jar cvfe $(ASSIGNMENT).jar $(TARGET) *.class

retroguard: $(ASSIGNMENT).jar
	mv $(ASSIGNMENT).jar temp.jar
	java -cp .:/home/zeil/src/retroguard/retroguard.jar RetroGuard temp.jar $(ASSIGNMENT).jar
	rm temp.jar

run: $(ASSIGNMENT).jar
	java -jar $(ASSIGNMENT).jar polyhedra1.txt 2

clean:
	-rm -f *.class
	-rm -f $(ASSIGNMENT).jar

grading:
	make $(ASSIGNMENT).jar

zip:
	-rm -f assignment.zip
	zip -9 -r assignment.zip *.java



