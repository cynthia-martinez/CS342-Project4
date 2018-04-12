
Name: Cynthia Martinez, Nathan He, Fernando Avila
NetID: cmarti65, nhe3, favila6

Cynthia Martinez worked on: NumQuestion, NumAnswer, SAQuestion, SAAnswer, Answer, ExamTaker

Nathan He worked on:ExamBuilder, Exam, Question, MCQuestion

Fernando Avila worked on: MCAnswer, MCMAAnswer, MCMAQuestion,MCSAAnswer, MCSAQuestion, ScannerFactory, ExamGrader

*****NOTE*****: My student answers do not save and I have not tested my restoring of student answers.
------------------------------------------------------------------------------------------------------
CS 342 HW 3 Overview:
The purpose of the assignment was to continue to develop the program from HW 3. This involved adding another type of question: multiple choice multiple answer questions. Also added a class to keep track of only one Scanner.The following classes were added:
-MCMAAnswer
-MCMAQuestion
-ScannerFactory

in addition to the previous classes which were:
-Answer class
-Question Class
-Exam Class
-ExamTester Class
-MCAnswer
-SAAnswer
-MCSAAnswer
-MCQuestion
-SAQuestion
-MCSAQuestion
-----------------------------------------------------------------------------------------------------
Answer Class: The Answer class is abstract and represents an answer to an exam. It has the following methods:

	-Answer() : a protected default constructor

	-print() : an abstract print method to be defined
	
	-getCredit(Answer compAnswer) : an abstract method, to be defined, that returns a double
-----------------------------------------------------------------------------------------------------
MCAnswer Class : The MCAnswer class is abstract that is a child of Answer and represents a multiple choice answer with the following methods:
	
	-MCAnswer(String text, double creditifSelected) : protected constructor to create multiple choice answer with given text and credit

	-print() : prints answer to the screen

	-getCredit(Answer compAnswer) : determines credit given for an answer
-----------------------------------------------------------------------------------------------------
SAAnswer Class : This class represnts a short answer answer and is a child of Answer with the following methods:

	-SAAnswer(String text) : construct to create a short answer with given String

	-print() : prints answer to the screen
-----------------------------------------------------------------------------------------------------
MCSAAnswer Class: This class represents a multiple choice answer of a question that can only have ONE answer. It is a child of MCAnswer. It has the following methods:
	
	-MCSAAnswer(String text, double creditifSelected): constructor to create multiple choice answer with given text and credit
	
-----------------------------------------------------------------------------------------------------
MCMAnswer Class: This class represents a multiple choice answer of a question that can have MULTIPLE answers. It is a child of MCAnswer. It has the following methods:
	
	-MCSAAnswer(String text, double creditifSelected): constructor to create multiple choice answer with given text and credit
	
-----------------------------------------------------------------------------------------------------
Question Class: The Question class is abstract and represents a question on an exam. It has the following methods:

	-Question(String text, double maxValue) : protected constructor to create a question. maxValue is credit question receives for full credit
	
	-print(): prints the question 
	
	-setRightAnswer(Answer ans): sets the right answer for the question

	-getNewAnswer(): abstract method that returns an Answer

	-getAnswerFromStudent(): abstract method to be defined later

	-getValue(): abstract method to be defined later. Returns a double

	-save(PrintWriter): abstract method defined later
	
	-saveStudentAnswer(PrintWriter): saves student answer to external 	file( passed in)

	-restoreStudentAnswers(PrintWriter): abstract method to be defined 	later	
-----------------------------------------------------------------------------------------------------
MCQuestion: This class represents a multiple choice question. It is a child of Question and has the following methods:
	
	-print(): prints the question and its possible answers to the screen. 

	-addAnswer(Answer) : adds an answer to a question

	-reorderAnswers() : randomly reorders the possible answers to a question

	-getValue(MCAnswer): returns a double

	-save(PrintWriter):
-----------------------------------------------------------------------------------------------------
SAQuestion: This class represents a short answer question. It is a child of Question and has the following methods:
	
	-SAQuestion(String text, double maxValue): constructor to create a short answer question

	-getNewAnswer(): creates and returns an Answer 

	-getNewAnswer(String text): creates and returns an Answer with given String
	
	-getAnswerFromStudent(): gets answer from student (user input) and stores the answer in studentAnswer field
	
	-getValue(): calculates the number of points the question contributes based on the current student answer. Returns a double
	-save(PrintWriter):

	-restoreStudentAnswer(PrintWriter):
---------------------------------------------------------------------------------------------------------------
MCSAQuestion: This class represents a multiple choice question that can only have a single answer. It is a child of MCQuestion. It has the following methods:

	-getNewAnswer(): creates and returns an Answer 

	-getNewAnswer(String text): creates and returns an Answer with given String

	-getNewAnswer(String text, double creditifSelected): creates and returns an Answer with given String and credit value
	
	-getAnswerFromStudent(): gets answer from student (user input) and stores the answer in studentAnswer field. Expects a single letter (A-E)
	
	-getValue(): calculates the number of points the question contributes based on the current student answer. Returns a double
	-save(PrintWriter):

	-restoreStudentAnswer(PrintWriter):
---------------------------------------------------------------------------------------------------------------
MCMAQuestion: This class represents a multiple choice question that can have multiple answers. It is a child of MCQuestion. It has the following methods:

	-getNewAnswer(): creates and returns an Answer 


	-getNewAnswer(String text, double creditifSelected): creates and returns an Answer with given String and credit value
	
	-getAnswerFromStudent(): gets answer from student (user input) and stores the answer in studentAnswer field. Expects a single letter (A-E)
	
	-getValue(): calculates the number of points the question contributes based on the current student answer. Returns a double
	
	-save(PrintWriter):
	
	-saveStudentAnswer(PrintWriter):

	-restoreStudentAnswer(PrintWriter):
---------------------------------------------------------------------------------------------------------------
Exam Class: represents a collection of different types of Questions that can be graded. It has the following methods:

	-Exam(String): constructor for creating an Exam; does not have any questions until added; input parameter is the title/header of an exam
	
	-print(): prints the exam title, and all of its questions(along with their answers, if any)
	
	-addQuestion(Question): adds a question to an exam
	
	-reorderQuestions(): randomly reorders the questions in the exam

	-reorderMCAnswers(int position): if position parameter is negative, reorders all MCAnswers of a queistio if it's multiple choice. if it is psoitive, reorders MCAnswers for that question as long as it is of type MCQuestion

	-getAnswerFromStudent(int position): Gets answer from student input. if position is negative, asks for all questions. Else, asks for that specific question

	-getValue(): gets the overall score/value/points on the exam based on the points earned for each of the questions within the exam. Returns a double

	-reportQuestionValues(): produces a table of values each question contributes on the exam
------------------------------------------------------------------------------------------------------------------------
ScannerFactory Class: produces keyboard Scanners as needed. Has the following methods:
	
	-getKeyboardScanner(): if static variable null, return new Scanner(System.in). if not, return static variable.
------------------------------------------------------------------------------------------------------------------------
ExamTester Class: This is the test driver for the other classes and contains main().It prints out my name and netID. After, it prints an exam given from an input data file. After, it reorders the exam and saves it to a different file. Then, it prints an exam with questions and answers that are reordered and in random positions. After it'll ask for user input to answer each of the questions. At this point it should save the answers to an answer file, clear the Exam and student answers, then restore them both and grade it.My program does not do this as I did not get my student answers to store yet and have not tested my restore. Lastly, it prints out the points earned per question on the exam and the overall score.




