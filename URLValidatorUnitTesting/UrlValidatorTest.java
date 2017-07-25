/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// Cherie Lo
// Corey Hemphill - hemphilc@oregonstate.edu
// Dat Tran
// CS362_400 - Spring 2016
// Team Project - Part B - Manual/Partition/Unit Tests

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import junit.framework.TestCase;

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May 2011) $
 */
public class UrlValidatorTest extends TestCase {

   @SuppressWarnings("unused")
private boolean printStatus = false;
   @SuppressWarnings("unused")
private boolean printIndex = false; // Print index that indicates current scheme, host, port, path,query test we're using.

   public UrlValidatorTest(String testName) {
      super(testName);
   }

   public void testManualTest()
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   // Manual test URL Schemes
	   
	   // Expected Valid URL Schemes
	   System.out.println("Testing Expected Valid URL Schemes\n");
	   
	   // Test http valid scheme input
	   System.out.println("-Test http valid input");
	   if (urlVal.isValid("http://www.google.com")) {
		   System.out.println("http://www.google.com is valid\n");
	   } else {
	       System.out.println("http://www.google.com is invalid\n");
	   }
	   
	   // Test https valid scheme input
	   System.out.println("-Test https valid input");
	   if (urlVal.isValid("https://www.facebook.com")) {
		   System.out.println("https://www.facebook.com is valid\n");
	   } else {
	       System.out.println("https://www.facebook.com is invalid\n");
	   }
	   
	   // Test ftp valid scheme input
	   System.out.println("-Test ftp valid input");
	   if (urlVal.isValid("ftp://www.google.com")) {
		   System.out.println("ftp://www.google.com is valid\n");
	   } else {
	       System.out.println("ftp://www.google.com is invalid\n");
	   }
	   
	   // Expected Invalid URL Schemes
	   System.out.println("Testing Expected Invalid URL Schemes\n");
	   
	   // Test invalid http scheme input
	   System.out.println("-Test http invalid input");
	   if (urlVal.isValid("httpp:///www.google.com")) {
		   System.out.println("httpp://www.google.com is valid\n");
	   } else {
	       System.out.println("httpp://www.google.com is invalid\n");
	   }
	   
	   // Test invalid https scheme input
	   System.out.println("-Test https invalid input");
	   if (urlVal.isValid("httpss://www.google.com")) {
		   System.out.println("httpss://www.google.com is valid\n");
	   } else {
	       System.out.println("httpss://www.google.com is invalid\n");
	   }
	   
	   // Test invalid ftp scheme input
	   System.out.println("-Test ftp invalid input");
	   if (urlVal.isValid("ftpp://www.google.com")) {
		   System.out.println("fart://www.google.com is valid\n");
	   } else {
	       System.out.println("fart://www.google.com is invalid\n");
	   }
	   
	   // Test invalid scheme input
	   System.out.println("-Test invalid input");
	   if (urlVal.isValid("arusha://www.google.com")) {
		   System.out.println("arusha://www.google.com is valid\n");
	   } else {
	       System.out.println("arusha://www.google.com is invalid\n");
	   }
	   
	   // Manual test URL Query Strings
	   
	   // Expected Valid URL Query Strings
	   System.out.println("Testing Expected Valid URL Query Strings\n");
	   
	   // Test valid single query input
	   System.out.println("-Test single query valid input");
	   if (urlVal.isValid("http://www.google.com/whats/that?name=elephant")) {
		   System.out.println("http://www.google.com/whats/that?name=elephant is valid\n");
	   } else {
	       System.out.println("http://www.google.com/whats/that?name=elephant is invalid\n");
	   }
	   
	   // Test valid double query input
	   System.out.println("-Test double query valid input");
	   if (urlVal.isValid("http://www.google.com/manual?field1=value1&field2=value2")) {
		   System.out.println("http://www.google.com/manual?field1=value1&field2=value2 is valid\n");
	   } else {
	       System.out.println("http://www.google.com/manual?field1=value1&field2=value2 is invalid\n");
	   }
	   
	   // Expected Invalid URL Query Strings
	   System.out.println("Testing Expected Invalid URL Query Strings\n");
	   
	   // Test invalid incomplete single query input
	   System.out.println("-Test incomplete single query invalid input");
	   if (urlVal.isValid("http://www.google.com/manual?")) {
		   System.out.println("http://www.google.com/manual? is valid\n");
	   } else {
	       System.out.println("http://www.google.com/manual? is invalid\n");
	   }
	   
	   // Test invalid character placement in single query input
	   System.out.println("-Test invalid character placement in single query invalid input");
	   if (urlVal.isValid("http://www.google.com/manual/?action=value")) {
		   System.out.println("http://www.google.com/manual/?action=value is valid\n");
	   } else {
	       System.out.println("http://www.google.com/manual/?action=value is invalid\n");
	   }
   }
   
   
   public void testYourFirstPartition()
   {
	   //Test Port Number Domain Partition
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String urlVal1 = "";
	   String urlVal2 = "";
	   String urlVal3 = "";
	   String urlVal4 = "";
	   String urlVal5 = "";
	   String urlVal6 = "";
	   
	   // Expected Valid Port Numbers
	   urlVal1 = "http://www.oregonstate.edu:0";
	   urlVal2 = "http://www.oregonstate.edu:1";
	   urlVal3 = "http://www.oregonstate.edu:73";
	   urlVal4 = "http://www.oregonstate.edu:321";
	   urlVal5 = "http://www.oregonstate.edu:8080";
	   urlVal6 = "http://www.oregonstate.edu:99999";
	   
	   assert urlVal.isValid(urlVal1) == true;
	   assert urlVal.isValid(urlVal2) == true;
	   assert urlVal.isValid(urlVal3) == true;
	   assert urlVal.isValid(urlVal4) == true;
	   assert urlVal.isValid(urlVal5) == true;
	   assert urlVal.isValid(urlVal6) == true;
	   
	   // Expected Invalid Port Numbers
	   urlVal1 = "http://www.oregonstate.edu:qwerty";
	   urlVal2 = "http://www.oregonstate.edu:G11";
	   urlVal3 = "http://www.oregonstate.edu:3729f";
	   urlVal4 = "http://www.oregonstate.edu:1u88T";
	   urlVal5 = "http://www.oregonstate.edu:100000";
	   urlVal6 = "http://www.oregonstate.edu:1497521";
	   
	   assert urlVal.isValid(urlVal1) == false;
	   assert urlVal.isValid(urlVal2) == false;
	   assert urlVal.isValid(urlVal3) == false;
	   assert urlVal.isValid(urlVal4) == false;
	   assert urlVal.isValid(urlVal5) == false;
	   assert urlVal.isValid(urlVal6) == false;
   }
   
   public void testYourSecondPartition()
   {
	   //Test Character Domain Partition
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   String urlVal1 = "";
	   String urlVal2 = "";
	   String urlVal3 = "";
	   String urlVal4 = "";
	   String urlVal5 = "";
	   String urlVal6 = "";
	   String urlVal7 = "";
	   String urlVal8 = "";
	   
	   // Expected Valid Characters
	   urlVal1 = "http://www.google.com/~hello";
	   urlVal2 = "http://www.google.com/123";
	   urlVal3 = "http://www.google.com/!hello";
	   urlVal4 = "http://www.google.com/#hello";
	   urlVal5 = "http://www.google.com/he_llo";
	   urlVal6 = "http://www.google.com/hello-there";
	   urlVal7 = "http://www.google.com/$hello";
	   urlVal8 = "http://www.google.com/he+llo";
	   
	   // Test Assertions
	   assert urlVal.isValid(urlVal1) == true;
	   assert urlVal.isValid(urlVal2) == true;
	   assert urlVal.isValid(urlVal3) == true;
	   assert urlVal.isValid(urlVal4) == true;
	   assert urlVal.isValid(urlVal5) == true;
	   assert urlVal.isValid(urlVal6) == true;
	   assert urlVal.isValid(urlVal7) == true;
	   assert urlVal.isValid(urlVal8) == true;
	   
	   // Expected Invalid Characters
	   urlVal1 = "http://www.goog{e.com";
	   urlVal2 = "http://www.google.com}";
	   urlVal3 = "http://www.googl.com";
	   urlVal4 = "http://www.google.com`";
	   urlVal5 = "http://www.google.com";
	   urlVal6 = "http://www.go^gle.com";
	   urlVal7 = "http://www.%oogle.com";
	   urlVal8 = "http://www.go gle.com";
	   
	   // Test Assertions
	   assert urlVal.isValid(urlVal1) == false;
	   assert urlVal.isValid(urlVal2) == false;
	   assert urlVal.isValid(urlVal3) == false;
	   assert urlVal.isValid(urlVal4) == false;
	   assert urlVal.isValid(urlVal5) == false;
	   assert urlVal.isValid(urlVal6) == false;
	   assert urlVal.isValid(urlVal7) == false;
	   assert urlVal.isValid(urlVal8) == false;
   }
   
   public void testIsValid() throws IOException
   {
	   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
	   
	   // Sanity test isValid() method with both valid and invalid URLs
	   System.out.println("Sanity Testing isValid() method\n");
	   
	   // Test valid input
	   assert urlVal.isValid("http://www.google.com") == true;
	   
	   // Test valid input
	   assert urlVal.isValid("https://www.facebook.com") == true;
	   
	   // Test valid input
	   assert urlVal.isValid("ftp://www.google.com") == true;
	   
	   // Test valid input
	   assert urlVal.isValid("http://www.google.com/whats/that?name=elephant") == true;
	   
	   // Test invalid input
	   assert urlVal.isValid("http:///www.google.com") == false;
	   
	   // Test invalid input
	   assert urlVal.isValid("https://www.google..com") == false;

	   // Test invalid input
	   assert urlVal.isValid("ftp:://www.google.com") == false;
	   
	   // Test invalid input
	   assert urlVal.isValid("arusha://www.google.com//") == false;
	   
	   // Test invalid input
	   assert urlVal.isValid("http://www.google.com/manual?field1=value1&&field2=value2") == false;
   
	   // All sanity tests for isValid() method passed
	   System.out.println("Sanity Testing isValid() method PASSED\n");
   }
   
   public void testAnyOtherUnitTest() throws IOException
   {
	   String filename = "UrlsToVerify";
	   for (int i = 0; i < 10000; i++)
	   {
		   // Output file for test result
		   PrintWriter writer = new PrintWriter(filename+"_results.txt", "UTF-8");
		   // URLs input file
		   String line = null;
		   //FileReader fileReader = new FileReader(filename+".txt");
		   FileReader fileReader = new FileReader("UrlsToVerify.txt");
		   BufferedReader bufferedReader = new BufferedReader(fileReader);
		   // Result string
		   String testResult;
		   String urlstr = "";
		   String expstr = "";
		   String[] splited = null;
		   UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		   // line = "Tested URL: <URL> - Expected: <true/false>
		   while ((line = bufferedReader.readLine()) != null)
		   {
			   splited = line.split("\\s+");
			   // Extract URL from line
			   urlstr = splited[0];
			   // Extract expected result from line <valid/invalid>
			   expstr = splited[1];
			   // Compare with isValid result
			   if (urlVal.isValid(urlstr) == true)
			   {
				   expstr = "valid";
				   testResult = "PASSED";
			   }
			   else
			   {
				   expstr = "invalid";
				   testResult = "FAILED";
			   }
			   // Print result to output file
			   writer.println("Tested URL: "+urlstr
				   		+"- Expected: "+expstr
				   		+"- Result: "+testResult);
		   }
		   // Close input file
		   bufferedReader.close();
		   // Close output file
		   writer.close();
	   }
   }
}
