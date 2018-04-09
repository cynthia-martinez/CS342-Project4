JCC = javac
JFLAGS = -g

default: Answer.class  MCAnswer.java MCSAAnswer.java SAAnswer.java MCMAAnswer.java Question.class MCQuestion.java SAQuestion.java MCSAQuestion.java MCMAQuestion.java Exam.class ExamTester.class ScannerFactory.class

Answer.class: Answer.java
	$(JCC) $(JFLAGS) Answer.java
SAAnswer.class: SAAnswer.java
	$(JCC) $(JFLAGS) SAAnswer.java
MCAnswer.class: MCAnswer.java
	$(JCC) $(JFLAGS) MCAnswer.java
MCSAAnswer.class: MCSAAnswer.java
	$(JCC) $(JFLAGS) MCSAAnswer.java
MCMAAnswer.class: MCMAAnswer.java
	$(JCC) $(JFLAGS) MCMAAnswer.java
Question.class: Question.java
	$(JCC) $(JFLAGS) Question.java
MCQuestion.class: MCQuestion.java
	$(JCC) $(JFLAGS) MCQuestion.java
MCSAQuestion.class: MCSAQuestion.java
	$(JCC) $(JFLAGS) MCSAQuestion.java
MCMAQuestion.class: MCMAQuestion.java
	$(JCC) $(JFLAGS) MCMAQuestion.java
SAQuestion.class: SAQuestion.java
	$(JCC) $(JFLAGS) SAQuestion.java
Exam.class: Exam.java
	$(JCC) $(JFLAGS) Exam.java
ExamTester.class: ExamTester.java
	$(JCC) $(JFLAGS) ExamTester.java
ScannerFactory.class: ScannerFactory.java
	$(JCC) $(JFLAGS) ScannerFactory.java
clean:
	rm *.class
