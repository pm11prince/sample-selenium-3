package com.seedbank.common.reporting;

import java.io.FileOutputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;  
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.ParserConfigurationException;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerException;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;  
import org.w3c.dom.Document;  
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import com.seedbank.common.utils.Logger;

/**
 * <copyright file="Run.java" company="ITC INFOTECH"> Reproduction or
 * transmission in whole or in part, in any form or by any means, electronic,
 * mechanical or otherwise, is prohibited without the prior written permission
 * of the copyright owner. </copyright>
 * 
 * @author 11763
 */

public class XMLBuffer {


	private Document xml;

	/**
	 * This method initializes the XML DOM document using newDocument() method of DocumentBuilder
	 */

	protected void initializeXMLDocument() throws IOException, TransformerException
	{
		try
		{
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder;
			documentBuilder = documentFactory.newDocumentBuilder();
			xml = documentBuilder.newDocument();
		}
		catch (ParserConfigurationException e)
		{
			e.printStackTrace();
		}

	}


	/**
	 * Creates the root element node of the Document, using createElement(String tagName) API method 
	 * of Document, with the given tagname set to "root" and append it in the Document 
	 * with appendChild(Node newChild) API method of Document.
	 */
	protected void CreateRootElement(String nodeName)
	{
		Element rootElement = xml.createElement(nodeName);  
		xml.appendChild(rootElement);
	}

	/**
	 * Create a new element(metadata node), and add it after the first child of the root element, 
	 * using appendChild(Node newChild) API method.
	 */

	protected void AddExecutionMetadataNode()
	{
		// Create Metadata Node
		Node root = xml.getFirstChild();
		Element metadata = xml.createElement("MetaData");
		root.appendChild(metadata);
	}

	/**
	 * Create a new node under MetaData tag 
	 * e.g <MetaData>
	 *	<AutomationTool>Appium</AutomationTool>
	 */

	protected void AddExecutionMetadata(String nodeName, String nodeValue)
	{
		// Get MetaData node
		Node root = xml.getFirstChild();
		Node metadataNode = root.getFirstChild();

		// Add Metadata
		Element metadata = xml.createElement(nodeName);
		metadata.appendChild(xml.createTextNode(nodeValue));
		metadataNode.appendChild(metadata);
	}

	/**
	 * Create a new node for TestSuite under root element with attribute as Test suite ID
	 * e.g <TestSuite id="1">
	 */

	protected void AddTestSuite(int tsID)
	{
		// Create TestCase Node
		Node root = xml.getFirstChild();
		Element testCase = xml.createElement("TestSuite");
		root.appendChild(testCase);

		// Set id attribute
		Attr attribute = xml.createAttribute("id");
		attribute.setValue(String.valueOf(tsID));
		testCase.setAttributeNode(attribute);
	}

	/**
	 * Create a new node for MetaData under TestSuite node
	 * e.g <TestSuite id="1">
	 *	<MetaData>
	 */

	protected void AddTestSuiteMetadataNode(int tcID)
	{
		// Create Metadata Node
		Node testCase = xml.getElementsByTagName("TestSuite").item(tcID - 1);
		Element metadata = xml.createElement("MetaData");
		testCase.appendChild(metadata);
	}

	/**
	 * Create a new node for adding MetaData under MetaData node
	 * e.g <TestSuite id="1">
	 *	<MetaData>
	 *		<Name>Registration_Validations</Name>
	 *		<TotalTestCases>2</TotalTestCases>
	 */


	protected void AddTestSuiteMetadata(int tcID, String nodeName, String nodeValue)
	{
		// Get Metadata Node
		Node testCase = xml.getElementsByTagName("TestSuite").item(tcID - 1);
		Node metadataNode = testCase.getFirstChild();

		// Add Metadata
		if (nodeValue != null)
		{
			Element metadata = xml.createElement(nodeName);
			metadata.appendChild(xml.createTextNode(nodeValue));
			metadataNode.appendChild(metadata);
		}
		else
		{
			Element metadata = xml.createElement(nodeName);
			metadata.appendChild(xml.createTextNode(""));
			metadataNode.appendChild(metadata);			
		}
	}

	/**
	 * Create a new node for TestCase under Test suite with attribute as test case ID
	 * e.g <TestSuite id="1">
	 *	<MetaData>
	 *		<Name>Registration_Validations</Name>
	 *		<TotalTestCases>2</TotalTestCases>
	 *      <TestCase id="1">
	 */

	protected void AddTestCase(int tcID, int itID)
	{
		// Create Iteration Node
		Node testCase = xml.getElementsByTagName("TestSuite").item(tcID - 1);
		Element iteration = xml.createElement("TestCase");
		testCase.appendChild(iteration);

		// Set id attribute
		Attr attribute = xml.createAttribute("id");
		attribute.setValue(String.valueOf(itID));
		iteration.setAttributeNode(attribute);
	}

	/**
	 * Create a new node for adding meta data for TestCase under Test case node
	 * e.g <TestSuite id="1">
	 *	<MetaData>
	 *		<Name>Registration_Validations</Name>
	 *		<TotalTestCases>2</TotalTestCases>
	 *      <TestCase id="1">
	 *      <MetaData>
	 *		
	 */


	protected void AddTestCaseMetadataNode(int tcID, int itID)
	{
		// Create Metadata Node
		Node testCase = xml.getElementsByTagName("TestSuite").item(tcID - 1);
		Node iteration = testCase.getChildNodes().item(itID);
		Element metadata = xml.createElement("MetaData");
		iteration.appendChild(metadata);
	}

	/**
	 * Create a new node for adding meta data for TestCase under Test case node
	 * e.g <TestSuite id="1">
	 *	<MetaData>
	 *		<Name>Registration_Validations</Name>
	 *		<TotalTestCases>2</TotalTestCases>
	 *      <TestCase id="1">
	 *      <MetaData>
	 *			<TestCaseName>REGISTRATION_INVALID MOBILE NUMBER</TestCaseName>
	 *			<TestCaseDescription>Test Description</TestCaseDescription>
	 */

	protected void AddTestCaseMetadata(int tcID, int itID, String nodeName, String nodeValue)
	{
		// Get Metadata Node
		Node testCase = xml.getElementsByTagName("TestSuite").item(tcID - 1);
		Node iteration = testCase.getChildNodes().item(itID);
		Node metadataNode = iteration.getFirstChild();

		// Add Metadata
		if (nodeValue != null)
		{
			Element metadata = xml.createElement(nodeName);
			metadata.appendChild(xml.createTextNode(nodeValue));
			metadataNode.appendChild(metadata);
		}
		else
		{
			Element metadata = xml.createElement(nodeName);
			metadata.appendChild(xml.createTextNode(""));
			metadataNode.appendChild(metadata);
		}
	}

	/**
	 * Create a new node for adding step data with attribute as step id.
	 * e.g <TestSuite id="1">
	 *	<MetaData>
	 *		<Name>Registration_Validations</Name>
	 *		<TotalTestCases>2</TotalTestCases>
	 *      <TestCase id="1">
	 *      <MetaData>
	 *			<TestCaseName>REGISTRATION_INVALID MOBILE NUMBER</TestCaseName>
	 *			<TestCaseDescription>Test Description</TestCaseDescription>
	 *		</MetaData>
	 *		<Step id="1">	
	 */
	protected void AddStep(int tcID, int itID, int stepID)
	{
		// Get the specific Iteration Node
		Node testCase = xml.getElementsByTagName("TestSuite").item(tcID - 1);
		Node iteration = testCase.getChildNodes().item(itID);

		// Create the Step Node
		Element step = xml.createElement("Step");
		iteration.appendChild(step);

		// Set id attribute
		Attr attribute = xml.createAttribute("id");
		attribute.setValue(String.valueOf(stepID));
		step.setAttributeNode(attribute);
	}


	/**
	 * Create a new node for adding step meta data under step node
	 * e.g <TestSuite id="1">
	 *	<MetaData>
	 *		<Name>Registration_Validations</Name>
	 *		<TotalTestCases>2</TotalTestCases>
	 *      <TestCase id="1">
	 *      <MetaData>
	 *			<TestCaseName>REGISTRATION_INVALID MOBILE NUMBER</TestCaseName>
	 *			<TestCaseDescription>Test Description</TestCaseDescription>
	 *		</MetaData>
	 *		<Step id="1">	
	 *		<TestStepDescription>Check For Invalid Mobile Number_ Special Char
	 *			</TestStepDescription>
	 *			<TestData />
	 *			<ExecutionStatus>Failed</ExecutionStatus>
	 *
	 */

	protected void AddStepMetadata(int tcID, int itID, int stepID, String nodeName, String nodeValue)
	{
		// Get Step node
		Node testCase = xml.getElementsByTagName("TestSuite").item(tcID - 1);
		Node iteration = testCase.getChildNodes().item(itID);
		Node step = iteration.getChildNodes().item(stepID);

		// Add Metadata
		if (nodeValue != null)
		{
			Element metadata = xml.createElement(nodeName);
			metadata.appendChild(xml.createTextNode(nodeValue));
			step.appendChild(metadata);
		}
		else
		{
			Element metadata = xml.createElement(nodeName);
			metadata.appendChild(xml.createTextNode(""));
			step.appendChild(metadata);
		}
	}
	/**
	 * Method saves the constructed DOM to an XML file using Transformer and SteamResult in order to
	 * write DOM object to stream i.e file.
	 *
	 */
	protected  void SaveXML(String path) throws IOException, TransformerException
	{
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(xml);
		StreamResult streamResult = new StreamResult(new FileOutputStream(path));
		transformer.transform(domSource, streamResult);
		Logger.log("Saving XML file");
		//	TextLog.IsolatedWrite(DateTime.GetLongDateAndTime() + ": -------------------- The XML Report has been saved --------------------");
	}

}
