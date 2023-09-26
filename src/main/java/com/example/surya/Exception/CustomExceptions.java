package com.example.surya.Exception;

public class CustomExceptions {

    public static class StudentNotFoundException extends RuntimeException 
    {
		private static final long serialVersionUID = 1L;
//
//		public StudentNotFoundException() 
//		{
//            super("Student with given id not found!");
//        }
//		
		 public StudentNotFoundException(String message) {
		        super(message);
		    }
    }

    public static class CourseNotFoundException extends RuntimeException
    {
    	
		private static final long serialVersionUID = 1L;

		public CourseNotFoundException() 
		{
            super("Course not found");
        }
		
    }

}
