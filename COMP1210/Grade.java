   /** 
    *	This is a class to calculate your grade in java. 
	 *
	 * @author Robert Skelton
	 * @version 2.13.2012
    */
 
   public class Grade {
   //declare variables
      private double exam1;
      private double exam2;
      private double finalExam;
      private double activityAvg;
      private double quizAvg;
      private double projectAvg;
      private String studentName;
       /**
       * @types of exams
       */
      public static final int EXAM_1 = 0, EXAM_2 = 1, FINAL = 2;
      private static final double EXAM_WEIGHT = .15,
      FINAL_WEIGHT = .3, LAB_WEIGHT = .1, PROJ_WEIGHT = .2;
   
   //constructor
    /**
       * @param nameIn inputs a name
       */
      public Grade(String nameIn) {
         studentName = nameIn;
      }
      
   //methods
    /**
       * @param activityAvgIn inputs the activity average
   	 * @param quizAvgIn inputs the quiz average
       */
      public void setLabAverages(double activityAvgIn,
      double quizAvgIn) {
         activityAvg = activityAvgIn;
         quizAvg = quizAvgIn;
      }
      
   	 /**
       * @param examType exam1, 2, or final
   	 * @param examScore what you earned on your exam
       */
      public void setExamScore(int examType, double examScore) {
         if (examType == EXAM_1) {
            exam1 = examScore;
         }
         else if (examType == EXAM_2) {
            exam2 = examScore;
         }
         else if (examType == FINAL) {
            finalExam = examScore;
         }
      }
      
   	 /**
       * @param average the grade on your projects
       */
      public void setProjectAverage(double average) {
         projectAvg = average;
      }
      
   	 /**
       * @return name returns the owners name
       */
      public double calculateGrade() {
         double grade = exam1 * EXAM_WEIGHT + exam2 * EXAM_WEIGHT
            + finalExam * FINAL_WEIGHT + activityAvg * LAB_WEIGHT
            + quizAvg * LAB_WEIGHT + projectAvg * PROJ_WEIGHT;
         return grade;
      }
   
   //toString method
    /**
       * @return name returns the owners name
       */
      public String toString() {
         return "Name: " + studentName
            + "\r\nFinal Grade: " + calculateGrade();
      }
   
   }